package com.dicoding.moviecatalogue.catalogues.detail

import com.dicoding.moviecatalogue.utils.DataDummy
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.catalogueId
    private val dummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val tvShowId = dummyTvShow.catalogueId

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
        viewModel.setSelectedMovie(movieId)
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getMovie() {
        viewModel.setSelectedMovie(dummyMovie.catalogueId)
        val movieEntity = viewModel.getMovie()
        TestCase.assertNotNull(movieEntity)
        TestCase.assertEquals(dummyMovie.catalogueId, movieEntity.catalogueId)
        TestCase.assertEquals(dummyMovie.catalogueTitle, movieEntity.catalogueTitle)
        TestCase.assertEquals(dummyMovie.catalogueScore, movieEntity.catalogueScore)
        TestCase.assertEquals(dummyMovie.catalogueGenres, movieEntity.catalogueGenres)
        TestCase.assertEquals(dummyMovie.catalogueRelease, movieEntity.catalogueRelease)
        TestCase.assertEquals(dummyMovie.catalogueDirector, movieEntity.catalogueDirector)
        TestCase.assertEquals(dummyMovie.catalogueCast, movieEntity.catalogueCast)
        TestCase.assertEquals(dummyMovie.catalogueOverview, movieEntity.catalogueOverview)
        TestCase.assertEquals(dummyMovie.cataloguePoster, movieEntity.cataloguePoster)
    }

    @Test
    fun getTvShow() {
        viewModel.setSelectedTvShow(dummyTvShow.catalogueId)
        val tvShowEntity = viewModel.getTvShow()
        TestCase.assertNotNull(tvShowEntity)
        TestCase.assertEquals(dummyTvShow.catalogueId, tvShowEntity.catalogueId)
        TestCase.assertEquals(dummyTvShow.catalogueTitle, tvShowEntity.catalogueTitle)
        TestCase.assertEquals(dummyTvShow.catalogueScore, tvShowEntity.catalogueScore)
        TestCase.assertEquals(dummyTvShow.catalogueGenres, tvShowEntity.catalogueGenres)
        TestCase.assertEquals(dummyTvShow.catalogueRelease, tvShowEntity.catalogueRelease)
        TestCase.assertEquals(dummyTvShow.catalogueDirector, tvShowEntity.catalogueDirector)
        TestCase.assertEquals(dummyTvShow.catalogueCast, tvShowEntity.catalogueCast)
        TestCase.assertEquals(dummyTvShow.catalogueOverview, tvShowEntity.catalogueOverview)
        TestCase.assertEquals(dummyTvShow.cataloguePoster, tvShowEntity.cataloguePoster)
    }
}