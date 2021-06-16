package com.dicoding.moviecatalogue.ui.catalogues.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.moviecatalogue.data.source.CatalogueRepository
import com.dicoding.moviecatalogue.data.source.local.entity.CatalogueEntity
import com.dicoding.moviecatalogue.data.source.local.entity.FavoriteEntity
import com.dicoding.moviecatalogue.utils.DataDummy
import com.dicoding.moviecatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel

    private val dummyTvShow = DataDummy.generateDummyListTvShows()[0]
    private val tvShowId = dummyTvShow.id
    private val dummyMovie = DataDummy.generateDummyListMovies()[0]
    private val movieId = dummyMovie.id

    private val dummyTvShowFavorite = DataDummy.generateDummyListTvShowFavorites()[0]
    private val tvShowFavoriteId = dummyTvShowFavorite.id
    private val dummyMovieFavorite = DataDummy.generateDummyListMovieFavorites()[0]
    private val movieFavoriteId = dummyMovieFavorite.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var detailMovieObserver: Observer<Resource<CatalogueEntity>>

    @Mock
    private lateinit var detailTvShowObserver: Observer<Resource<CatalogueEntity>>

    @Mock
    private lateinit var creditObserver: Observer<Resource<CatalogueEntity>>

    @Mock
    private lateinit var favoriteObserver: Observer<FavoriteEntity>


    @Before
    fun setUp() {
        viewModel = DetailViewModel(catalogueRepository)
    }

    @Test
    fun getDetailTvShow() {
        val expected = MutableLiveData<Resource<CatalogueEntity>>()
        expected.value = Resource.success(dummyTvShow)

        `when`(catalogueRepository.getDetailTvShow(tvShowId)).thenReturn(expected)
        val detailEntity = viewModel.getDetailTvShow(tvShowId).value?.data as CatalogueEntity
        verify(catalogueRepository).getDetailTvShow(tvShowId)

        TestCase.assertNotNull(detailEntity)
        TestCase.assertEquals(dummyTvShow.id, detailEntity.id)
        TestCase.assertEquals(dummyTvShow.title, detailEntity.title)
        TestCase.assertEquals(dummyTvShow.score, detailEntity.score)
        TestCase.assertEquals(dummyTvShow.genres, detailEntity.genres)
        TestCase.assertEquals(dummyTvShow.release, detailEntity.release)
        TestCase.assertEquals(dummyTvShow.overview, detailEntity.overview)
        TestCase.assertEquals(dummyTvShow.poster, detailEntity.poster)

        viewModel.getDetailTvShow(tvShowId).observeForever(detailTvShowObserver)
        verify(detailTvShowObserver).onChanged(expected.value)
    }

    @Test
    fun getCreditDetailTvShow() {
        val catalogue = "tv"

        val expected = MutableLiveData<Resource<CatalogueEntity>>()
        expected.value = Resource.success(dummyTvShow)

        `when`(catalogueRepository.getCredits(tvShowId, catalogue)).thenReturn(expected)
        val creditEntity = viewModel.getCredit(tvShowId, catalogue).value?.data as CatalogueEntity
        verify(catalogueRepository).getCredits(tvShowId, catalogue)

        TestCase.assertNotNull(creditEntity)
        TestCase.assertEquals(dummyTvShow.creator, creditEntity.creator)
        TestCase.assertEquals(dummyTvShow.casts, creditEntity.casts)

        viewModel.getCredit(tvShowId,catalogue).observeForever(creditObserver)
        verify(creditObserver).onChanged(expected.value)
    }


    @Test
    fun getDetailMovie() {
        val expected = MutableLiveData<Resource<CatalogueEntity>>()
        expected.value = Resource.success(dummyMovie)

        `when`(catalogueRepository.getDetailMovie(movieId)).thenReturn(expected)
        val detailEntity = viewModel.getDetailMovie(movieId).value?.data as CatalogueEntity
        verify(catalogueRepository).getDetailMovie(movieId)

        TestCase.assertNotNull(detailEntity)
        TestCase.assertEquals(dummyMovie.id, detailEntity.id)
        TestCase.assertEquals(dummyMovie.title, detailEntity.title)
        TestCase.assertEquals(dummyMovie.score, detailEntity.score)
        TestCase.assertEquals(dummyMovie.genres, detailEntity.genres)
        TestCase.assertEquals(dummyMovie.release, detailEntity.release)
        TestCase.assertEquals(dummyMovie.overview, detailEntity.overview)
        TestCase.assertEquals(dummyMovie.poster, detailEntity.poster)

        viewModel.getDetailMovie(movieId).observeForever(detailMovieObserver)
        verify(detailMovieObserver).onChanged(expected.value)
    }
    @Test
    fun getCreditDetailMovie() {
        val catalogue = "movie"

        val expected = MutableLiveData<Resource<CatalogueEntity>>()
        expected.value = Resource.success(dummyMovie)

        `when`(catalogueRepository.getCredits(tvShowId, catalogue)).thenReturn(expected)
        val creditEntity = viewModel.getCredit(tvShowId, catalogue).value?.data as CatalogueEntity
        verify(catalogueRepository).getCredits(tvShowId, catalogue)

        TestCase.assertNotNull(creditEntity)
        TestCase.assertEquals(dummyMovie.creator, creditEntity.creator)
        TestCase.assertEquals(dummyMovie.casts, creditEntity.casts)

        viewModel.getCredit(tvShowId,catalogue).observeForever(creditObserver)
        verify(creditObserver).onChanged(expected.value)
    }

    @Test
    fun getFavoriteByTvShowId() {
        val expected = MutableLiveData<FavoriteEntity>()
        expected.value = dummyTvShowFavorite

        `when`(catalogueRepository.getFavoriteById(tvShowFavoriteId)).thenReturn(expected)
        val favoriteTvShowEntity = viewModel.getFavoriteById(tvShowFavoriteId).value as FavoriteEntity
        verify(catalogueRepository).getFavoriteById(tvShowFavoriteId)

        TestCase.assertNotNull(favoriteTvShowEntity)
        TestCase.assertEquals(dummyTvShowFavorite.id, favoriteTvShowEntity.id)
        TestCase.assertEquals(dummyTvShowFavorite.title, favoriteTvShowEntity.title)
        TestCase.assertEquals(dummyTvShowFavorite.score, favoriteTvShowEntity.score)
        TestCase.assertEquals(dummyTvShowFavorite.genres, favoriteTvShowEntity.genres)
        TestCase.assertEquals(dummyTvShowFavorite.release, favoriteTvShowEntity.release)
        TestCase.assertEquals(dummyTvShowFavorite.overview, favoriteTvShowEntity.overview)
        TestCase.assertEquals(dummyTvShowFavorite.poster, favoriteTvShowEntity.poster)
        TestCase.assertEquals(dummyTvShowFavorite.creator, favoriteTvShowEntity.creator)
        TestCase.assertEquals(dummyTvShowFavorite.casts, favoriteTvShowEntity.casts)

        viewModel.getFavoriteById(tvShowFavoriteId).observeForever(favoriteObserver)
        verify(favoriteObserver).onChanged(expected.value)
    }

    @Test
    fun getFavoriteByMovieId() {
        val expected = MutableLiveData<FavoriteEntity>()
        expected.value = dummyMovieFavorite

        `when`(catalogueRepository.getFavoriteById(movieFavoriteId)).thenReturn(expected)
        val favoriteMovieEntity = viewModel.getFavoriteById(movieFavoriteId).value as FavoriteEntity
        verify(catalogueRepository).getFavoriteById(movieFavoriteId)

        TestCase.assertNotNull(favoriteMovieEntity)
        TestCase.assertEquals(dummyMovieFavorite.id, favoriteMovieEntity.id)
        TestCase.assertEquals(dummyMovieFavorite.title, favoriteMovieEntity.title)
        TestCase.assertEquals(dummyMovieFavorite.score, favoriteMovieEntity.score)
        TestCase.assertEquals(dummyMovieFavorite.genres, favoriteMovieEntity.genres)
        TestCase.assertEquals(dummyMovieFavorite.release, favoriteMovieEntity.release)
        TestCase.assertEquals(dummyMovieFavorite.overview, favoriteMovieEntity.overview)
        TestCase.assertEquals(dummyMovieFavorite.poster, favoriteMovieEntity.poster)
        TestCase.assertEquals(dummyMovieFavorite.creator, favoriteMovieEntity.creator)
        TestCase.assertEquals(dummyMovieFavorite.casts, favoriteMovieEntity.casts)

        viewModel.getFavoriteById(movieFavoriteId).observeForever(favoriteObserver)
        verify(favoriteObserver).onChanged(expected.value)
    }

    @Test
    fun insertMovieFavoriteCatalogue(){
        viewModel.insertFavoriteCatalogue(dummyMovieFavorite)
        verify(catalogueRepository).insertFavoriteCatalogue(dummyMovieFavorite)
        verifyNoMoreInteractions(favoriteObserver)
    }

    @Test
    fun insertTvShowFavoriteCatalogue(){
        viewModel.insertFavoriteCatalogue(dummyTvShowFavorite)
        verify(catalogueRepository).insertFavoriteCatalogue(dummyTvShowFavorite)
        verifyNoMoreInteractions(favoriteObserver)
    }

    @Test
    fun deleteMovieFavoriteCatalogue() {
        viewModel.deleteFavoriteCatalogue(movieFavoriteId)
        verify(catalogueRepository).deleteFavoriteCatalogue(movieFavoriteId)
        verifyNoMoreInteractions(favoriteObserver)
    }

    @Test
    fun deleteTvShowFavoriteCatalogue() {
        viewModel.deleteFavoriteCatalogue(tvShowFavoriteId)
        verify(catalogueRepository).deleteFavoriteCatalogue(tvShowFavoriteId)
        verifyNoMoreInteractions(favoriteObserver)
    }
}