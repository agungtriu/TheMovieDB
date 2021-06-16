package com.dicoding.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dicoding.moviecatalogue.data.source.local.entity.CatalogueEntity
import com.dicoding.moviecatalogue.data.source.local.entity.FavoriteEntity
import com.dicoding.moviecatalogue.vo.Resource

interface CatalogueDataSource {

    fun getMovies(page: Int): LiveData<Resource<PagedList<CatalogueEntity>>>

    fun getTvShows(page: Int): LiveData<Resource<PagedList<CatalogueEntity>>>

    fun getCredits(id: Int, catalogue: String): LiveData<Resource<CatalogueEntity>>

    fun getDetailMovie(id: Int): LiveData<Resource<CatalogueEntity>>

    fun getDetailTvShow(id: Int): LiveData<Resource<CatalogueEntity>>

    fun insertFavoriteCatalogue(favoriteEntity: FavoriteEntity)

    fun getListFavorite(catalogue:String): LiveData<PagedList<FavoriteEntity>>

    fun getFavoriteById(id: Int): LiveData<FavoriteEntity>

    fun deleteFavoriteCatalogue(id: Int)

}