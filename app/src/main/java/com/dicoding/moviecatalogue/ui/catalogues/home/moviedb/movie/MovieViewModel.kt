package com.dicoding.moviecatalogue.ui.catalogues.home.moviedb.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.moviecatalogue.data.source.CatalogueRepository
import com.dicoding.moviecatalogue.data.source.local.entity.CatalogueEntity
import com.dicoding.moviecatalogue.vo.Resource

class MovieViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {
    fun getMovies(page:Int) : LiveData<Resource<PagedList<CatalogueEntity>>> = catalogueRepository.getMovies(page)
}