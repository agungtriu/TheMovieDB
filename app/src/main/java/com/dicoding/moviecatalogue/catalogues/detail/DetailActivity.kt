package com.dicoding.moviecatalogue.catalogues.detail

import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dicoding.moviecatalogue.R
import com.dicoding.moviecatalogue.catalogues.viewmodel.ViewModelFactory
import com.dicoding.moviecatalogue.data.source.local.entity.CatalogueDetailEntity
import com.dicoding.moviecatalogue.data.source.local.entity.CatalogueEntity
import com.dicoding.moviecatalogue.data.source.local.entity.DetailMovieEntity
import com.dicoding.moviecatalogue.data.source.local.entity.DetailTvShowEntity
import com.dicoding.moviecatalogue.databinding.ActivityDetailBinding
import com.dicoding.moviecatalogue.utils.Config

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    private lateinit var viewModel: DetailViewModel
    private lateinit var detailBinding: ActivityDetailBinding
    private var detailTitle: String? = null
    private var detailPoster: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        val factory = ViewModelFactory.getInstance()
        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]
        getData()
        setListener()
    }

    private fun getData(){
        showLoading()
        val extras = intent.extras
        if (extras != null) {
            val movie = extras.getParcelable<CatalogueEntity>(EXTRA_MOVIE)
            if (movie != null) {
                viewModel.getDetailMovie(movie.id)
                    .observe(this, { detailMovieResponse ->
                        getCreditMovie(detailMovieResponse)
                    })
                detailBinding.textviewDetailToolbar.text = getString(R.string.movie_title)
            }
            val tvShow = extras.getParcelable<CatalogueEntity>(EXTRA_TV_SHOW)
            if (tvShow != null) {
                viewModel.getDetailTvShow(tvShow.id)
                    .observe(this, { detailTvShowResponse ->
                        getCreditTvShow(detailTvShowResponse)
                    })
                detailBinding.textviewDetailDirectorSubtitle.text = getString(R.string.detail_creator)
                detailBinding.textviewDetailToolbar.text = getString(R.string.tvshow_title)
            }
        }
    }

    private fun setListener(){
        detailBinding.imgDetailBack.setOnClickListener {
            onBackPressed()
        }
        detailBinding.imgDetailShare.setOnClickListener {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(getString(R.string.all_share))
                .setText("Check $detailTitle on The Movie DB")
                .startChooser()
        }
        detailBinding.imgDetailPoster.setOnClickListener {
            val builder = Dialog(this)
            builder.setContentView(R.layout.image_show)
            Glide.with(this)
                .load(detailPoster)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                        .override(1000)
                )
                .into(builder.findViewById(R.id.img_show))
            builder.show()
        }
    }

    private fun getCreditMovie(detailMovieEntity: DetailMovieEntity) {
        viewModel.getCredit(detailMovieEntity.id, "movie").observe(this, { creditEntity ->
            val detailCatalogueDetailEntity = CatalogueDetailEntity(detailMovieEntity.id, detailMovieEntity.title, detailMovieEntity.releaseDate, detailMovieEntity.overview, detailMovieEntity.voteAverage, detailMovieEntity.genres, creditEntity.crew, creditEntity.cast, detailMovieEntity.posterPath)
            populateCatalogue(detailCatalogueDetailEntity)
        })
    }

    private fun getCreditTvShow(detailTvShowEntity: DetailTvShowEntity) {
        viewModel.getCredit(detailTvShowEntity.id, "tv").observe(this, { creditEntity ->
            val detailCatalogueDetailEntity = CatalogueDetailEntity(detailTvShowEntity.id, detailTvShowEntity.name, detailTvShowEntity.firstAirDate, detailTvShowEntity.overview, detailTvShowEntity.voteAverage, detailTvShowEntity.genres, detailTvShowEntity.createdBy, creditEntity.cast, detailTvShowEntity.posterPath)
            populateCatalogue(detailCatalogueDetailEntity)
        })
    }

    private fun populateCatalogue(catalogueEntity: CatalogueDetailEntity) {
        detailTitle = catalogueEntity.catalogueTitle
        detailBinding.textviewDetailTitle.text = detailTitle
        detailBinding.textviewDetailScore.text = catalogueEntity.catalogueScore
        detailBinding.textviewDetailGenres.text = catalogueEntity.catalogueGenres
        detailBinding.textviewDetailRelease.text = catalogueEntity.catalogueRelease
        checkDirector(catalogueEntity.catalogueDirector)
        detailBinding.textviewDetailCast.text = catalogueEntity.catalogueCast
        checkOverview(catalogueEntity.catalogueOverview)
        detailPoster = Config.imagePath.plus(catalogueEntity.cataloguePoster)
        Glide.with(this)
            .load(detailPoster)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(detailBinding.imgDetailPoster)
        hideLoading()
    }

    private fun checkDirector(directors: String){
        if (directors.isBlank()){
            detailBinding.textviewDetailDirectorSubtitle.visibility = View.INVISIBLE
            detailBinding.textviewDetailDirector.visibility = View.INVISIBLE
        }else{
            detailBinding.textviewDetailDirector.text = directors
        }
    }
    private fun checkOverview(overviewRemote:String){
        val overview = if (overviewRemote.isEmpty()){
            getString(R.string.text_detail_nooverview)
        }else{
            overviewRemote
        }
        detailBinding.textviewDetailOverview.text = overview
    }
    private fun showLoading() {
        detailBinding.constraintDetailProgress.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        detailBinding.constraintDetailProgress.visibility = View.GONE
    }
}