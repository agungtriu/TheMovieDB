package com.dicoding.moviecatalogue.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dicoding.moviecatalogue.data.source.local.LocalDataSource
import com.dicoding.moviecatalogue.data.source.local.entity.CatalogueEntity
import com.dicoding.moviecatalogue.data.source.local.entity.FavoriteEntity
import com.dicoding.moviecatalogue.data.source.remote.RemoteDataSource
import com.dicoding.moviecatalogue.utils.AppExecutors
import com.dicoding.moviecatalogue.utils.DataDummy
import com.dicoding.moviecatalogue.utils.PagedListUtil
import com.dicoding.moviecatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import junit.framework.TestCase.assertEquals
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class CatalogueRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val catalogueRepository = FakeCatalogueRepository(remote, local, appExecutors)

    private val moviesResponse = DataDummy.generateDummyListMovies()
    private val movieId = moviesResponse[0].id
    private val moviesFavorites = DataDummy.generateDummyListMovieFavorites()
    private val movieFavoriteId = moviesFavorites[0].id

    private val tvShowResponse = DataDummy.generateDummyListTvShows()
    private val tvShowId = tvShowResponse[0].id
    private val tvShowFavorites = DataDummy.generateDummyListTvShowFavorites()
    private val tvShowFavoriteId = tvShowFavorites[0].id

    private val catalogueMovie = "movie"
    private val catalogueTvShow = "tv"

    @Test
    fun getMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, CatalogueEntity>
        `when`(local.getListCatalogue(catalogueMovie)).thenReturn(dataSourceFactory)
        catalogueRepository.getMovies(1)

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyListMovies()))
        verify(local).getListCatalogue(catalogueMovie)
        Assert.assertNotNull(movieEntities.data)
        assertEquals(moviesResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getTvShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, CatalogueEntity>
        `when`(local.getListCatalogue(catalogueTvShow)).thenReturn(dataSourceFactory)
        catalogueRepository.getTvShows(1)

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyListTvShows()))
        verify(local).getListCatalogue(catalogueTvShow)
        Assert.assertNotNull(tvShowEntities.data)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getCreditMovie() {
        val expected = MutableLiveData<CatalogueEntity>()
        expected.value = DataDummy.generateDummyListMovies()[0]
        `when`(local.getCatalogueById(movieId)).thenReturn(expected)
        catalogueRepository.getCredits(movieId,catalogueMovie)

        val movieEntities = Resource.success(DataDummy.generateDummyListMovies())
        verify(local).getCatalogueById(movieId)
        Assert.assertNotNull(movieEntities.data)
        assertEquals(moviesResponse.size.toLong(), movieEntities.data?.size?.toLong())

    }

    @Test
    fun getCreditTvShow() {
        val expected = MutableLiveData<CatalogueEntity>()
        expected.value = DataDummy.generateDummyListTvShows()[0]
        `when`(local.getCatalogueById(tvShowId)).thenReturn(expected)
        catalogueRepository.getCredits(tvShowId,catalogueTvShow)

        val tvShowEntities = Resource.success(DataDummy.generateDummyListTvShows())
        verify(local).getCatalogueById(tvShowId)
        Assert.assertNotNull(tvShowEntities.data)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getDetailMovie() {
        val expected = MutableLiveData<CatalogueEntity>()
        expected.value = DataDummy.generateDummyListMovies()[0]
        `when`(local.getCatalogueById(movieId)).thenReturn(expected)
        catalogueRepository.getDetailMovie(movieId)

        val movieEntities = Resource.success(DataDummy.generateDummyListMovies())
        verify(local).getCatalogueById(movieId)
        Assert.assertNotNull(movieEntities.data)
        assertEquals(moviesResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getDetailTvShow() {
        val expected = MutableLiveData<CatalogueEntity>()
        expected.value = DataDummy.generateDummyListTvShows()[0]
        `when`(local.getCatalogueById(tvShowId)).thenReturn(expected)
        catalogueRepository.getDetailTvShow(tvShowId)

        val tvShowEntities = Resource.success(DataDummy.generateDummyListTvShows())
        verify(local).getCatalogueById(tvShowId)
        Assert.assertNotNull(tvShowEntities.data)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getListMovieFavorite() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, FavoriteEntity>
        `when`(local.getListFavorite(catalogueMovie)).thenReturn(dataSourceFactory)
        catalogueRepository.getListFavorite(catalogueMovie)

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyListMovieFavorites()))
        verify(local).getListFavorite(catalogueMovie)
        Assert.assertNotNull(movieEntities.data)
        assertEquals(moviesFavorites.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getListTvShowFavorite() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, FavoriteEntity>
        `when`(local.getListFavorite(catalogueTvShow)).thenReturn(dataSourceFactory)
        catalogueRepository.getListFavorite(catalogueTvShow)

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyListTvShowFavorites()))
        verify(local).getListFavorite(catalogueTvShow)
        Assert.assertNotNull(tvShowEntities.data)
        assertEquals(tvShowFavorites.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getMovieFavoriteById() {
        val expected = MutableLiveData<FavoriteEntity>()
        expected.value = DataDummy.generateDummyListMovieFavorites()[0]
        `when`(local.getFavoriteById(movieFavoriteId)).thenReturn(expected)
        catalogueRepository.getFavoriteById(movieFavoriteId)

        val movieEntities = Resource.success(DataDummy.generateDummyListMovieFavorites())
        verify(local).getFavoriteById(movieFavoriteId)
        Assert.assertNotNull(movieEntities.data)
        assertEquals(moviesFavorites.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getTvShowFavoriteById() {
        val expected = MutableLiveData<FavoriteEntity>()
        expected.value = DataDummy.generateDummyListTvShowFavorites()[0]
        `when`(local.getFavoriteById(tvShowFavoriteId)).thenReturn(expected)
        catalogueRepository.getFavoriteById(tvShowFavoriteId)

        val tvShowEntities = Resource.success(DataDummy.generateDummyListTvShowFavorites())
        verify(local).getFavoriteById(tvShowFavoriteId)
        Assert.assertNotNull(tvShowEntities.data)
        assertEquals(tvShowFavorites.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun insertMovieFavoriteCatalogue() {
        catalogueRepository.insertFavoriteCatalogue(DataDummy.generateDummyListMovieFavorites()[0])
        verify(local).insertFavoriteCatalogue(DataDummy.generateDummyListMovieFavorites()[0])
        verifyNoMoreInteractions(local)
    }

    @Test
    fun insertTvShowFavoriteCatalogue() {
        catalogueRepository.insertFavoriteCatalogue(DataDummy.generateDummyListTvShowFavorites()[0])
        verify(local).insertFavoriteCatalogue(DataDummy.generateDummyListTvShowFavorites()[0])
        verifyNoMoreInteractions(local)
    }

    @Test
    fun deleteMovieFavoriteCatalogue() {
        catalogueRepository.deleteFavoriteCatalogue(movieFavoriteId)
        verify(local).deleteFavoriteCatalogue(movieFavoriteId)
        verifyNoMoreInteractions(local)
    }
    @Test
    fun deleteTvShowFavoriteCatalogue() {
        catalogueRepository.deleteFavoriteCatalogue(tvShowFavoriteId)
        verify(local).deleteFavoriteCatalogue(tvShowFavoriteId)
        verifyNoMoreInteractions(local)
    }

}