package com.dicoding.moviecatalogue.ui.catalogues.home.moviedb.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.moviecatalogue.data.source.CatalogueRepository
import com.dicoding.moviecatalogue.data.source.local.entity.CatalogueEntity
import com.dicoding.moviecatalogue.vo.Resource

class TvShowViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    fun getTvShows(page: Int): LiveData<Resource<PagedList<CatalogueEntity>>> = catalogueRepository.getTvShows(page)
}