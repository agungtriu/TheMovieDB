package com.dicoding.moviecatalogue.ui.catalogues.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.moviecatalogue.data.source.CatalogueRepository
import com.dicoding.moviecatalogue.ui.catalogues.Injection
import com.dicoding.moviecatalogue.ui.catalogues.detail.DetailViewModel
import com.dicoding.moviecatalogue.ui.catalogues.home.favorite.movie.MovieFavViewModel
import com.dicoding.moviecatalogue.ui.catalogues.home.favorite.tvshow.TvShowFavViewModel
import com.dicoding.moviecatalogue.ui.catalogues.home.moviedb.movie.MovieViewModel
import com.dicoding.moviecatalogue.ui.catalogues.home.moviedb.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val catalogueRepository: CatalogueRepository) :
    ViewModelProvider.NewInstanceFactory() {
        companion object{
            @Volatile
            private var instance: ViewModelFactory? = null

            fun getInstance(context: Context): ViewModelFactory =
                instance ?: synchronized(this) {
                    instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                        instance = this
                    }
                }
        }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(catalogueRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                TvShowViewModel(catalogueRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(catalogueRepository) as T
            }
            modelClass.isAssignableFrom(MovieFavViewModel::class.java) -> {
                MovieFavViewModel(catalogueRepository) as T
            }
            modelClass.isAssignableFrom(TvShowFavViewModel::class.java) -> {
                TvShowFavViewModel(catalogueRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}