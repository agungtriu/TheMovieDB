package com.dicoding.moviecatalogue.catalogues.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.moviecatalogue.catalogues.Injection
import com.dicoding.moviecatalogue.catalogues.detail.DetailViewModel
import com.dicoding.moviecatalogue.catalogues.movie.MovieViewModel
import com.dicoding.moviecatalogue.catalogues.tvshow.TvShowViewModel
import com.dicoding.moviecatalogue.data.source.CatalogueRepository

class ViewModelFactory private constructor(private val catalogueRepository: CatalogueRepository) :
    ViewModelProvider.NewInstanceFactory() {
        companion object{
            @Volatile
            private var instance: ViewModelFactory? = null

            fun getInstance(): ViewModelFactory =
                instance ?: synchronized(this) {
                    instance ?: ViewModelFactory(Injection.provideRepository()).apply {
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
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}