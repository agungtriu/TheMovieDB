package com.dicoding.moviecatalogue.catalogues.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.moviecatalogue.data.source.CatalogueRepository
import com.dicoding.moviecatalogue.data.source.local.entity.CatalogueEntity

class MovieViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {
    fun getMovies(page:Int) : LiveData<List<CatalogueEntity>> = catalogueRepository.getMovies(page)
}