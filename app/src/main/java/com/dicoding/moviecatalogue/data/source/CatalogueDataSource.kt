package com.dicoding.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import com.dicoding.moviecatalogue.data.source.local.entity.CatalogueEntity
import com.dicoding.moviecatalogue.data.source.local.entity.CreditEntity
import com.dicoding.moviecatalogue.data.source.local.entity.DetailMovieEntity
import com.dicoding.moviecatalogue.data.source.local.entity.DetailTvShowEntity

interface CatalogueDataSource {

    fun getMovies(page: Int): LiveData<List<CatalogueEntity>>

    fun getTvShows(page: Int): LiveData<List<CatalogueEntity>>

    fun getCredits(id: Int, catalogue: String): LiveData<CreditEntity>

    fun getDetailMovie(id: Int): LiveData<DetailMovieEntity>

    fun getDetailTvShow(id: Int): LiveData<DetailTvShowEntity>

}