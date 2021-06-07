package com.dicoding.moviecatalogue.catalogues.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.moviecatalogue.data.source.CatalogueRepository
import com.dicoding.moviecatalogue.data.source.local.entity.CatalogueEntity
import com.dicoding.moviecatalogue.utils.DataDummy
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
    private lateinit var observer: Observer<List<CatalogueEntity>>
    @Before
    fun setUp() {
        viewModel = TvShowViewModel(catalogueRepository)
    }

    @Test
    fun getTvShows() {
        val dummyListTvShows = DataDummy.generateDummyListTvShows()
        val tvShows = MutableLiveData<List<CatalogueEntity>>()
        tvShows.value = dummyListTvShows

        Mockito.`when`(viewModel.getTvShows(1)).thenReturn(tvShows)
        val tvShowEntities = viewModel.getTvShows(1).value
        verify(catalogueRepository).getTvShows(1)
        TestCase.assertNotNull(tvShowEntities)
        TestCase.assertEquals(5, tvShowEntities?.size)

        viewModel.getTvShows(1).observeForever(observer)
        verify(observer).onChanged(dummyListTvShows)
    }
}