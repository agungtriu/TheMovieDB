package com.dicoding.moviecatalogue.ui.catalogues.home.favorite.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.moviecatalogue.data.source.CatalogueRepository
import com.dicoding.moviecatalogue.data.source.local.entity.FavoriteEntity

class MovieFavViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {
    fun getMovieFavorites() : LiveData<PagedList<FavoriteEntity>> = catalogueRepository.getListFavorite("movie")
}