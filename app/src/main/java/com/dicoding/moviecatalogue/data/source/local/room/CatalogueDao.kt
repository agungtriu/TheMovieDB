package com.dicoding.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dicoding.moviecatalogue.data.source.local.entity.CatalogueEntity
import com.dicoding.moviecatalogue.data.source.local.entity.FavoriteEntity

@Dao
interface CatalogueDao {
    @Query("SELECT * FROM catalogueentities WHERE category = :mCategory")
    fun getListCatalogue(mCategory: String): DataSource.Factory<Int,CatalogueEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertListCatalogue(catalogues: List<CatalogueEntity>)

    @Query("UPDATE catalogueentities SET genres = :genres WHERE id = :id")
    fun updateCatalogueByDetailMovie(genres: String, id: Int)

    @Query("UPDATE catalogueentities SET genres = :genres, creator = :creator  WHERE id = :id")
    fun updateCatalogueByDetailTv(genres: String, creator: String, id: Int)

    @Query("UPDATE catalogueentities SET casts = :casts, creator = :director  WHERE id = :id")
    fun updateCatalogueByCreditMovie(casts: String, director: String, id: Int)

    @Query("UPDATE catalogueentities SET casts = :casts  WHERE id = :id")
    fun updateCatalogueByCreditTv(casts: String, id: Int)

    @Query("SELECT * FROM catalogueentities WHERE id = :id")
    fun getCatalogueById(id: Int): LiveData<CatalogueEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavorite(favorite: FavoriteEntity)

    @Query("SELECT * FROM favoriteentities WHERE category = :mCategory")
    fun getListFavoriteCatalogue(mCategory: String): DataSource.Factory<Int,FavoriteEntity>

    @Query("SELECT * FROM favoriteentities WHERE id = :id")
    fun getFavoriteById(id: Int): LiveData<FavoriteEntity>

    @Query("DELETE FROM favoriteentities WHERE id = :id")
    fun deleteFavoriteById(id: Int)

}