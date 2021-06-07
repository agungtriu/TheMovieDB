package com.dicoding.moviecatalogue.catalogues

import com.dicoding.moviecatalogue.data.source.CatalogueRepository
import com.dicoding.moviecatalogue.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(): CatalogueRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return CatalogueRepository.getInstance(remoteDataSource)
    }
}