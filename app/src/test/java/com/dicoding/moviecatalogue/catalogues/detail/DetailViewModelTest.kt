package com.dicoding.moviecatalogue.catalogues.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.moviecatalogue.data.source.CatalogueRepository
import com.dicoding.moviecatalogue.data.source.local.entity.CreditEntity
import com.dicoding.moviecatalogue.data.source.local.entity.DetailMovieEntity
import com.dicoding.moviecatalogue.data.source.local.entity.DetailTvShowEntity
import com.dicoding.moviecatalogue.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var detailMovieObserver: Observer<DetailMovieEntity>

    @Mock
    private lateinit var detailTvShowObserver: Observer<DetailTvShowEntity>

    @Mock
    private lateinit var creditObserver: Observer<CreditEntity>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(catalogueRepository)
    }

    @Test
    fun getDetailTvShow() {
        val catalogue = "tv"

        val dummyTvShow = DataDummy.generateDummyDetailTvShows()
        val tvShowId = dummyTvShow.id
        val tv = MutableLiveData<DetailTvShowEntity>()
        tv.value = dummyTvShow

        val dummyCreditTvShow = DataDummy.generateDummyTvShowsCredit()
        val tvCredit = MutableLiveData<CreditEntity>()
        tvCredit.value = dummyCreditTvShow

        `when`(catalogueRepository.getDetailTvShow(tvShowId)).thenReturn(tv)
        `when`(catalogueRepository.getCredits(tvShowId, catalogue)).thenReturn(tvCredit)
        val detailEntity = viewModel.getDetailTvShow(tvShowId).value as DetailTvShowEntity
        verify(catalogueRepository).getDetailTvShow(tvShowId)
        val creditEntity = viewModel.getCredit(tvShowId, catalogue).value as CreditEntity
        verify(catalogueRepository).getCredits(tvShowId, catalogue)

        TestCase.assertNotNull(detailEntity)
        TestCase.assertNotNull(creditEntity)
        TestCase.assertEquals(dummyTvShow.id, detailEntity.id)
        TestCase.assertEquals(dummyTvShow.name, detailEntity.name)
        TestCase.assertEquals(dummyTvShow.voteAverage, detailEntity.voteAverage)
        TestCase.assertEquals(dummyTvShow.genres, detailEntity.genres)
        TestCase.assertEquals(dummyTvShow.firstAirDate, detailEntity.firstAirDate)
        TestCase.assertEquals(dummyCreditTvShow.crew, creditEntity.crew)
        TestCase.assertEquals(dummyCreditTvShow.cast, creditEntity.cast)
        TestCase.assertEquals(dummyTvShow.overview, detailEntity.overview)
        TestCase.assertEquals(dummyTvShow.posterPath, detailEntity.posterPath)

        viewModel.getDetailTvShow(tvShowId).observeForever(detailTvShowObserver)
        verify(detailTvShowObserver).onChanged(dummyTvShow)
        viewModel.getCredit(tvShowId,catalogue).observeForever(creditObserver)
        verify(creditObserver).onChanged(dummyCreditTvShow)
    }


    @Test
    fun getDetailMovie() {

        val catalogue = "movie"

        val dummyMovies = DataDummy.generateDummyDetailMovies()
        val movieId = dummyMovies.id
        val movies = MutableLiveData<DetailMovieEntity>()
        movies.value = dummyMovies

        val dummyMovieCredits = DataDummy.generateDummyMoviesCredit()
        val movieCredits = MutableLiveData<CreditEntity>()
        movieCredits.value = dummyMovieCredits

        `when`(catalogueRepository.getDetailMovie(movieId)).thenReturn(movies)
        `when`(catalogueRepository.getCredits(movieId, catalogue)).thenReturn(movieCredits)
        val detailEntity = viewModel.getDetailMovie(movieId).value as DetailMovieEntity
        verify(catalogueRepository).getDetailMovie(movieId)
        val creditEntity = viewModel.getCredit(movieId, catalogue).value as CreditEntity
        verify(catalogueRepository).getCredits(movieId, catalogue)

        TestCase.assertNotNull(detailEntity)
        TestCase.assertNotNull(creditEntity)
        TestCase.assertEquals(dummyMovies.id, detailEntity.id)
        TestCase.assertEquals(dummyMovies.title, detailEntity.title)
        TestCase.assertEquals(dummyMovies.voteAverage, detailEntity.voteAverage)
        TestCase.assertEquals(dummyMovies.genres, detailEntity.genres)
        TestCase.assertEquals(dummyMovies.releaseDate, detailEntity.releaseDate)
        TestCase.assertEquals(dummyMovieCredits.crew, creditEntity.crew)
        TestCase.assertEquals(dummyMovieCredits.cast, creditEntity.cast)
        TestCase.assertEquals(dummyMovies.overview, detailEntity.overview)
        TestCase.assertEquals(dummyMovies.posterPath, detailEntity.posterPath)

        viewModel.getDetailMovie(movieId).observeForever(detailMovieObserver)
        verify(detailMovieObserver).onChanged(dummyMovies)
        viewModel.getCredit(movieId,catalogue).observeForever(creditObserver)
        verify(creditObserver).onChanged(dummyMovieCredits)
    }
}