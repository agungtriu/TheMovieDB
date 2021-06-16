package com.dicoding.moviecatalogue.ui.catalogues.home.favorite.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.moviecatalogue.data.source.CatalogueRepository
import com.dicoding.moviecatalogue.data.source.local.entity.FavoriteEntity

class TvShowFavViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {
    fun getTvShowFavorites() : LiveData<PagedList<FavoriteEntity>> = catalogueRepository.getListFavorite("tv")
}