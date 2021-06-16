package com.dicoding.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.dicoding.moviecatalogue.data.source.local.entity.CatalogueEntity
import com.dicoding.moviecatalogue.data.source.local.entity.FavoriteEntity
import com.dicoding.moviecatalogue.data.source.local.room.CatalogueDao

class LocalDataSource private constructor(private val catalogueDao: CatalogueDao) {
    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(catalogueDao: CatalogueDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(catalogueDao)
    }

    fun getListCatalogue(category: String): DataSource.Factory<Int,CatalogueEntity> =
        catalogueDao.getListCatalogue(category)

    fun insertListCatalogue(catalogues: List<CatalogueEntity>) =
        catalogueDao.insertListCatalogue(catalogues)

    fun updateCatalogueByDetailMovie(genres: String, id: Int) {
        catalogueDao.updateCatalogueByDetailMovie(genres, id)
    }

    fun updateCatalogueByDetailTv(genres: String, creator: String, id: Int) {
        catalogueDao.updateCatalogueByDetailTv(genres, creator, id)
    }

    fun updateCatalogueByCreditMovie(casts: String, director: String, id: Int) {
        catalogueDao.updateCatalogueByCreditMovie(casts, director, id)
    }

    fun updateCatalogueByCreditTv(casts: String, id: Int) {
        catalogueDao.updateCatalogueByCreditTv(casts, id)
    }

    fun getCatalogueById(id: Int): LiveData<CatalogueEntity> = catalogueDao.getCatalogueById(id)

    fun insertFavoriteCatalogue(favoriteEntity: FavoriteEntity) {
        catalogueDao.insertFavorite(favoriteEntity)
    }

    fun getListFavorite(category: String): DataSource.Factory<Int,FavoriteEntity> =
        catalogueDao.getListFavoriteCatalogue(category)


    fun getFavoriteById(id: Int): LiveData<FavoriteEntity> = catalogueDao.getFavoriteById(id)

    fun deleteFavoriteCatalogue(id: Int) {
        catalogueDao.deleteFavoriteById(id)
    }

}