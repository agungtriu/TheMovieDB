package com.dicoding.moviecatalogue.ui.catalogues.detail

import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dicoding.moviecatalogue.R
import com.dicoding.moviecatalogue.data.source.local.entity.CatalogueEntity
import com.dicoding.moviecatalogue.data.source.local.entity.FavoriteEntity
import com.dicoding.moviecatalogue.databinding.ActivityDetailBinding
import com.dicoding.moviecatalogue.ui.catalogues.viewmodel.ViewModelFactory
import com.dicoding.moviecatalogue.utils.Config
import com.dicoding.moviecatalogue.vo.Status

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TV_SHOW = "extra_tv_show"
        const val EXTRA_FAVORITE = "extra_favorite"
    }

    private lateinit var viewModel: DetailViewModel
    private lateinit var detailBinding: ActivityDetailBinding
    private var detailTitle: String? = null
    private var detailPoster: String? = null
    private var stateFavorite: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]
        getData()
        setListener()
    }

    private fun getData() {
        showLoading()
        val extras = intent.extras

        if (extras != null) {
            val movie = extras.getParcelable<CatalogueEntity>(EXTRA_MOVIE)
            val tvShow = extras.getParcelable<CatalogueEntity>(EXTRA_TV_SHOW)
            val favorite = extras.getParcelable<FavoriteEntity>(EXTRA_FAVORITE)
            when {
                movie != null -> {
                    viewModel.getDetailMovie(movie.id)
                        .observe(this, { catalogues ->
                            if (catalogues != null) {
                                when (catalogues.status) {
                                    Status.LOADING -> showLoading()
                                    Status.SUCCESS -> catalogues.data?.let { getCredit(it) }
                                    Status.ERROR -> {
                                        hideLoading()
                                        dataNotLoad()
                                    }
                                }
                            }
                        })
                    detailBinding.textviewDetailToolbar.text = getString(R.string.movie_title)
                }
                tvShow != null -> {
                    viewModel.getDetailTvShow(tvShow.id)
                        .observe(this, { catalogues ->
                            if (catalogues != null) {
                                when (catalogues.status) {
                                    Status.LOADING -> showLoading()
                                    Status.SUCCESS -> catalogues.data?.let { getCredit(it) }
                                    Status.ERROR -> {
                                        hideLoading()
                                        dataNotLoad()
                                    }
                                }
                            }
                        })
                    detailBinding.textviewDetailToolbar.text = getString(R.string.tvshow_title)
                }
                favorite != null -> {
                    detailBinding.apply {
                        if (favorite.category==getString(R.string.tvshow)){
                            textviewDetailToolbar.text = getString(R.string.tvshow_title)
                        }else{
                            textviewDetailToolbar.text = getString(R.string.movie_title)
                        }
                    }
                    populateCatalogue(CatalogueEntity(favorite.id,favorite.title,favorite.release,favorite.overview,favorite.score,favorite.poster,favorite.category,favorite.genres,favorite.creator,favorite.casts))

                    hideLoading()
                    dataSuccess()
                }
            }
        }
    }

    private fun setListener() {
        detailBinding.imgDetailBack.setOnClickListener {
            onBackPressed()
        }
        detailBinding.fabDetailShare.setOnClickListener {
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

    private fun getCredit(catalogueEntity: CatalogueEntity) {
        viewModel.getCredit(catalogueEntity.id, catalogueEntity.category)
            .observe(this, { catalogues ->
                if (catalogues != null) {
                    when (catalogues.status) {
                        Status.LOADING -> showLoading()
                        Status.SUCCESS -> {
                            hideLoading()
                            dataSuccess()
                            catalogues.data?.let {
                                populateCatalogue(it)
                            }
                        }
                        Status.ERROR -> {
                            hideLoading()
                            dataNotLoad()
                        }
                    }
                }
            })
    }

    private fun populateCatalogue(catalogueEntity: CatalogueEntity) {
        detailTitle = catalogueEntity.title
        detailBinding.apply {
            textviewDetailTitle.text = detailTitle
            textviewDetailScore.text = catalogueEntity.score
            textviewDetailGenres.text = catalogueEntity.genres
            textviewDetailRelease.text = catalogueEntity.release
            checkDirector(catalogueEntity.creator)
            textviewDetailCast.text = catalogueEntity.casts
            checkOverview(catalogueEntity.overview)
            detailPoster = Config.imagePath.plus(catalogueEntity.poster)
            Glide.with(this@DetailActivity)
                .load(detailPoster)
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(imgDetailPoster)

            if (catalogueEntity.category==getString(R.string.tvshow)){
                textviewDetailDirectorSubtitle.text = getString(R.string.detail_creator)
            }else{
                textviewDetailDirectorSubtitle.text = getString(R.string.all_director)
            }
        }


        checkFavorite(catalogueEntity)
        setListenerFavorite(catalogueEntity)
    }

    private fun checkDirector(directors: String) {
        detailBinding.apply {
            if (directors.isBlank()) {
                textviewDetailDirectorSubtitle.visibility = View.INVISIBLE
                textviewDetailDirector.visibility = View.INVISIBLE
            } else {
                textviewDetailDirector.text = directors
            }
        }
    }

    private fun checkOverview(overviewRemote: String) {
        val overview = if (overviewRemote.isEmpty()) {
            getString(R.string.text_detail_nooverview)
        } else {
            overviewRemote
        }
        detailBinding.textviewDetailOverview.text = overview
    }

    private fun checkFavorite(catalogueEntity: CatalogueEntity) {
        viewModel.getFavoriteById(catalogueEntity.id).observe(this, { favorite ->
            detailBinding.apply {
                if (favorite!=null) {
                    imgDetailFavorite.setImageDrawable(
                        ContextCompat.getDrawable(
                            this@DetailActivity,
                            R.drawable.ic_favorite_solid_white
                        )
                    )
                    stateFavorite = true

                } else {
                    imgDetailFavorite.setImageDrawable(
                        ContextCompat.getDrawable(
                            this@DetailActivity,
                            R.drawable.ic_favorite_border_white
                        )
                    )
                    stateFavorite = false
                }
            }
        })
    }

    private fun setListenerFavorite(catalogueEntity: CatalogueEntity){
        detailBinding.apply {
            imgDetailFavorite.setOnClickListener {
                if (stateFavorite) {
                    viewModel.deleteFavoriteCatalogue(catalogueEntity.id)
                    imgDetailFavorite.setImageDrawable(
                        ContextCompat.getDrawable(
                            this@DetailActivity,
                            R.drawable.ic_favorite_border_white
                        )
                    )
                } else {
                    viewModel.insertFavoriteCatalogue(FavoriteEntity(catalogueEntity.id,catalogueEntity.title,catalogueEntity.release,catalogueEntity.overview,catalogueEntity.score,catalogueEntity.poster,catalogueEntity.category,catalogueEntity.genres,catalogueEntity.creator,catalogueEntity.casts))
                    imgDetailFavorite.setImageDrawable(
                        ContextCompat.getDrawable(
                            this@DetailActivity,
                            R.drawable.ic_favorite_solid_white
                        )
                    )
                }
            }
        }
    }

    private fun showLoading() {
        detailBinding.constraintDetailProgress.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        detailBinding.constraintDetailProgress.visibility = View.GONE
    }

    private fun dataNotLoad() {
        detailBinding.apply {
            imgDetailNotload.visibility = View.VISIBLE
            textviewDetailNotload.visibility = View.VISIBLE
            scrollDetailCatalogue.visibility = View.GONE
            fabDetailShare.visibility = View.GONE
            imgDetailFavorite.visibility = View.GONE
        }
    }

    private fun dataSuccess() {
        detailBinding.apply {
            imgDetailNotload.visibility = View.GONE
            textviewDetailNotload.visibility = View.GONE
            scrollDetailCatalogue.visibility = View.VISIBLE
            fabDetailShare.visibility = View.VISIBLE
            imgDetailFavorite.visibility = View.VISIBLE
        }
    }
}