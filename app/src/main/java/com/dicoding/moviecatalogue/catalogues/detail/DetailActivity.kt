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
import com.dicoding.moviecatalogue.data.CatalogueEntity
import com.dicoding.moviecatalogue.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    private lateinit var detailBinding: ActivityDetailBinding
    private lateinit var detailTitle: String
    private lateinit var detailPoster: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null) {
                viewModel.setSelectedMovie(movieId)
                checkCatalogue(viewModel.getMovie(),getString(R.string.movie_title))
            }
            val tvShowId = extras.getString(EXTRA_TV_SHOW)
            if (tvShowId != null) {
                viewModel.setSelectedTvShow(tvShowId)
                checkCatalogue(viewModel.getTvShow(),getString(R.string.tvshow_title))
                detailBinding.textviewDetailDirectorSubtitle.text =
                    getString(R.string.detail_creator)
            }
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


        toolbar()
    }

    private fun toolbar(){
        detailBinding.textviewDetailToolbar.text = detailTitle
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
    }
    private fun checkCatalogue(catalogueEntity: CatalogueEntity, catalogue:String){
        if (catalogueEntity.catalogueId.isEmpty()){
            dataCantLoad()
            detailTitle = catalogue
        }else{
            dataAvailable()
            populateCatalogue(catalogueEntity)
        }
    }

    private fun populateCatalogue(catalogueEntity: CatalogueEntity) {
        detailBinding.textviewDetailTitle.text = catalogueEntity.catalogueTitle
        detailBinding.textviewDetailScore.text = catalogueEntity.catalogueScore
        detailBinding.textviewDetailGenres.text = catalogueEntity.catalogueGenres
        detailBinding.textviewDetailRelease.text = catalogueEntity.catalogueRelease
        detailBinding.textviewDetailDirector.text = catalogueEntity.catalogueDirector
        detailBinding.textviewDetailCast.text = catalogueEntity.catalogueCast
        detailBinding.textviewDetailOverview.text = catalogueEntity.catalogueOverview

        Glide.with(this)
            .load(catalogueEntity.cataloguePoster)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(detailBinding.imgDetailPoster)
        detailPoster = catalogueEntity.cataloguePoster
        detailTitle = catalogueEntity.catalogueTitle
    }

    private fun dataAvailable() {
        detailBinding.scrollDetailCatalogue.visibility = View.VISIBLE
        detailBinding.constraintDetailEmpty.visibility = View.GONE
    }
    private fun dataCantLoad(){
        detailBinding.scrollDetailCatalogue.visibility = View.GONE
        detailBinding.constraintDetailEmpty.visibility = View.VISIBLE
    }
}