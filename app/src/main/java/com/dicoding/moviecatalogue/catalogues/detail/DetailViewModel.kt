package com.dicoding.moviecatalogue.catalogues.detail

import androidx.lifecycle.ViewModel
import com.dicoding.moviecatalogue.data.CatalogueEntity
import com.dicoding.moviecatalogue.utils.DataDummy

class DetailViewModel : ViewModel() {
    private lateinit var movieId: String
    private lateinit var tvShowId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun getMovie(): CatalogueEntity {
        lateinit var movie: CatalogueEntity
        val moviesEntities = DataDummy.generateDummyMovies()
        for (movieEntity in moviesEntities) {
            if (movieEntity.catalogueId == movieId) {
                movie = movieEntity
                break
            }
        }
        return movie
    }

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId = tvShowId
    }

    fun getTvShow(): CatalogueEntity {
        lateinit var tvShow: CatalogueEntity
        val tvShowsEntities = DataDummy.generateDummyTvShows()
        for (tvShowEntity in tvShowsEntities) {
            if (tvShowEntity.catalogueId == tvShowId) {
                tvShow = tvShowEntity
                break
            }
        }
        return tvShow
    }
}