package com.dicoding.moviecatalogue.ui.catalogues.home.moviedb.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.moviecatalogue.data.source.CatalogueRepository
import com.dicoding.moviecatalogue.data.source.local.entity.CatalogueEntity
import com.dicoding.moviecatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<CatalogueEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<CatalogueEntity>
    @Before
    fun setUp() {
        viewModel = TvShowViewModel(catalogueRepository)
    }

    @Test
    fun getTvShows() {
        val dummyListTvShows = Resource.success(pagedList)
        Mockito.`when`(dummyListTvShows.data?.size).thenReturn(5)
        val expected = MutableLiveData<Resource<PagedList<CatalogueEntity>>>()
        expected.value = dummyListTvShows

        Mockito.`when`(viewModel.getTvShows(1)).thenReturn(expected)
        val tvShowEntities = viewModel.getTvShows(1).value?.data
        verify(catalogueRepository).getTvShows(1)
        TestCase.assertNotNull(tvShowEntities)
        TestCase.assertEquals(5, tvShowEntities?.size)

        viewModel.getTvShows(1).observeForever(observer)
        verify(observer).onChanged(dummyListTvShows)
    }
}