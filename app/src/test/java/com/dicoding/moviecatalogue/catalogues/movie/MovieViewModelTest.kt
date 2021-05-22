package com.dicoding.moviecatalogue.catalogues.movie

import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel
    @Before
    fun setUp() {
        viewModel = MovieViewModel()
    }

    @Test
    fun getMovies() {
        val movieEntities = viewModel.getMovies()
        TestCase.assertNotNull(movieEntities)
        TestCase.assertEquals(10, movieEntities.size)
    }
}