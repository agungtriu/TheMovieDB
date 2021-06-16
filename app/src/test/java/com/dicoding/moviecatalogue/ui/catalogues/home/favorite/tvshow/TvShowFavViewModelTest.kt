package com.dicoding.moviecatalogue.ui.catalogues.home.favorite.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.moviecatalogue.data.source.CatalogueRepository
import com.dicoding.moviecatalogue.data.source.local.entity.FavoriteEntity
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowFavViewModelTest {
    private lateinit var viewModel: TvShowFavViewModel


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository


    @Mock
    private lateinit var observer: Observer<PagedList<FavoriteEntity>>

    @Mock
    private lateinit var pagedList: PagedList<FavoriteEntity>

    @Before
    fun setUp() {
        viewModel = TvShowFavViewModel(catalogueRepository)
    }

    @Test
    fun getTvShowFavorites() {
        val catalogueName = "tv"
        val dummyTvShows = pagedList
        Mockito.`when`(dummyTvShows.size).thenReturn(5)
        val expected = MutableLiveData<PagedList<FavoriteEntity>>()
        expected.value = dummyTvShows

        Mockito.`when`(catalogueRepository.getListFavorite(catalogueName)).thenReturn(expected)
        val movieEntities = viewModel.getTvShowFavorites().value
        Mockito.verify(catalogueRepository).getListFavorite(catalogueName)
        TestCase.assertNotNull(movieEntities)
        TestCase.assertEquals(5, movieEntities?.size)

        viewModel.getTvShowFavorites().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTvShows)
    }
}