package com.dicoding.moviecatalogue.catalogues.tvshow

import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun getTvShows() {
        val tvShowEntities = viewModel.getTvShows()
        TestCase.assertNotNull(tvShowEntities)
        TestCase.assertEquals(10, tvShowEntities.size)
    }
}