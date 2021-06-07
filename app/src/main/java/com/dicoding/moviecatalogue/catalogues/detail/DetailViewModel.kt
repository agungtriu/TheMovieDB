package com.dicoding.moviecatalogue.catalogues.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.moviecatalogue.data.source.CatalogueRepository
import com.dicoding.moviecatalogue.data.source.local.entity.CreditEntity
import com.dicoding.moviecatalogue.data.source.local.entity.DetailMovieEntity
import com.dicoding.moviecatalogue.data.source.local.entity.DetailTvShowEntity

class DetailViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getDetailTvShow(id: Int): LiveData<DetailTvShowEntity> =
        catalogueRepository.getDetailTvShow(id)

    fun getDetailMovie(id: Int): LiveData<DetailMovieEntity> =
        catalogueRepository.getDetailMovie(id)

    fun getCredit(id: Int, catalogue: String): LiveData<CreditEntity> =
        catalogueRepository.getCredits(id, catalogue)
}