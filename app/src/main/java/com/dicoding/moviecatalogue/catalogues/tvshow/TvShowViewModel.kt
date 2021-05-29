package com.dicoding.moviecatalogue.catalogues.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.moviecatalogue.data.source.CatalogueRepository
import com.dicoding.moviecatalogue.data.source.local.entity.CatalogueEntity

class TvShowViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    fun getTvShows(page: Int): LiveData<List<CatalogueEntity>> = catalogueRepository.getTvShows(page)
}