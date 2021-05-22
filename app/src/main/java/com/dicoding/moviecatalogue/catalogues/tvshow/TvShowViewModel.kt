package com.dicoding.moviecatalogue.catalogues.tvshow

import androidx.lifecycle.ViewModel
import com.dicoding.moviecatalogue.data.CatalogueEntity
import com.dicoding.moviecatalogue.utils.DataDummy

class TvShowViewModel: ViewModel() {
    fun getTvShows() : List<CatalogueEntity> = DataDummy.generateDummyTvShows()
}