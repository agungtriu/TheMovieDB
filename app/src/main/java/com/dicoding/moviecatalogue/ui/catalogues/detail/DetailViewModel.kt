package com.dicoding.moviecatalogue.ui.catalogues.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.moviecatalogue.data.source.CatalogueRepository
import com.dicoding.moviecatalogue.data.source.local.entity.CatalogueEntity
import com.dicoding.moviecatalogue.data.source.local.entity.FavoriteEntity
import com.dicoding.moviecatalogue.vo.Resource

class DetailViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getDetailTvShow(id: Int): LiveData<Resource<CatalogueEntity>> =
        catalogueRepository.getDetailTvShow(id)

    fun getDetailMovie(id: Int): LiveData<Resource<CatalogueEntity>> =
        catalogueRepository.getDetailMovie(id)

    fun getCredit(id: Int, catalogue: String): LiveData<Resource<CatalogueEntity>> =
        catalogueRepository.getCredits(id, catalogue)

    fun getFavoriteById(id: Int): LiveData<FavoriteEntity> =
        catalogueRepository.getFavoriteById(id)

    fun insertFavoriteCatalogue(favoriteEntity: FavoriteEntity){
        catalogueRepository.insertFavoriteCatalogue(favoriteEntity)
    }

    fun deleteFavoriteCatalogue(id: Int){
        catalogueRepository.deleteFavoriteCatalogue(id)
    }

}