package com.dicoding.moviecatalogue.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dicoding.moviecatalogue.data.source.remote.RemoteDataSource
import com.dicoding.moviecatalogue.utils.DataDummy
import com.dicoding.moviecatalogue.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import junit.framework.TestCase.assertEquals
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class CatalogueRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val catalogueRepository = FakeCatalogueRepository(remote)

    private val moviesResponse = DataDummy.getRemoteMovies()
    private val movieId = moviesResponse[0].id
    private val movieDetail = DataDummy.getRemoteDetailMovie()
    private val movieCreditResponse = DataDummy.getRemoteCreditMovies()

    private val tvShowResponse = DataDummy.getRemoteTvShows()
    private val tvShowId = tvShowResponse[0].id
    private val tvShowDetail = DataDummy.getRemoteDetailTvShow()
    private val tvShowCreditResponse = DataDummy.getRemoteCreditTvShows()

    @Test
    fun getMovie() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadMoviesCallback).onAllMoviesReceived(moviesResponse)
            null
        }.`when`(remote).getMovies(eq(1),any())

        val movieEntities = LiveDataTestUtil.getValue(catalogueRepository.getMovies(1))
        verify(remote).getMovies(eq(1),any())
        Assert.assertNotNull(movieEntities)
        assertEquals(moviesResponse.size, movieEntities.size)
    }

    @Test
    fun getTvShow() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadTvShowsCallback).onAllTvShowReceived(tvShowResponse)
            null
        }.`when`(remote).getTvShows(eq(1),any())

        val tvShowEntities = LiveDataTestUtil.getValue(catalogueRepository.getTvShows(1))
        verify(remote).getTvShows(eq(1),any())
        Assert.assertNotNull(tvShowEntities)
        assertEquals(tvShowResponse.size, tvShowEntities.size)
    }

    @Test
    fun getCreditTvShow() {
        doAnswer { invocation ->
            (invocation.arguments[2] as RemoteDataSource.LoadCreditCallback).onAllCreditReceived(tvShowCreditResponse)
            null
        }.`when`(remote).getCredit(eq(tvShowId),eq("tv"),any())

        val tvShowCreditEntities = LiveDataTestUtil.getValue(catalogueRepository.getCredits(tvShowId,"tv"))
        verify(remote).getCredit(eq(tvShowId),eq("tv"),any())
        Assert.assertNotNull(tvShowCreditEntities)
        assertEquals(tvShowCreditResponse.id, tvShowCreditEntities.id)
    }

    @Test
    fun getCreditMovie() {
        doAnswer { invocation ->
            (invocation.arguments[2] as RemoteDataSource.LoadCreditCallback).onAllCreditReceived(movieCreditResponse)
            null
        }.`when`(remote).getCredit(eq(movieId),eq("movie"),any())

        val movieCreditEntities = LiveDataTestUtil.getValue(catalogueRepository.getCredits(movieId,"movie"))
        verify(remote).getCredit(eq(movieId),eq("movie"),any())
        Assert.assertNotNull(movieCreditEntities)
        assertEquals(movieCreditResponse.id, movieCreditEntities.id)
    }

    @Test
    fun getDetailMovie() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadDetailMovieCallback).onAllDetailMovieReceived(movieDetail)
            null
        }.`when`(remote).getDetailMovie(eq(movieId),any())

        val movieDetailEntity = LiveDataTestUtil.getValue(catalogueRepository.getDetailMovie(movieId))
        verify(remote).getDetailMovie(eq(movieId),any())
        Assert.assertNotNull(movieDetailEntity)
        assertEquals(movieDetail.id, movieDetailEntity.id)
    }

    @Test
    fun getDetailTvShow() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadDetailTvShowCallback).onAllDetailTvShowReceived(tvShowDetail)
            null
        }.`when`(remote).getDetailTv(eq(tvShowId),any() )

        val tvShowDetailEntity = LiveDataTestUtil.getValue(catalogueRepository.getDetailTvShow(tvShowId))
        verify(remote).getDetailTv(eq(tvShowId),any())
        Assert.assertNotNull(tvShowDetailEntity)
        assertEquals(tvShowDetail.id, tvShowDetailEntity.id)
    }
}