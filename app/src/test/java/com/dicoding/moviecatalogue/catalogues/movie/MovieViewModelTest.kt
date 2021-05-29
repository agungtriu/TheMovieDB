package com.dicoding.moviecatalogue.catalogues.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.moviecatalogue.data.source.CatalogueRepository
import com.dicoding.moviecatalogue.data.source.local.entity.CatalogueEntity
import com.dicoding.moviecatalogue.utils.DataDummy
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository


    @Mock
    private lateinit var observer: Observer<List<CatalogueEntity>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(catalogueRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = DataDummy.generateDummyListMovies()
        val movies = MutableLiveData<List<CatalogueEntity>>()
        movies.value = dummyMovies

        `when`(catalogueRepository.getMovies(1)).thenReturn(movies)
        val movieEntities = viewModel.getMovies(1)
        verify(catalogueRepository).getMovies(1)
        TestCase.assertNotNull(movieEntities)
        TestCase.assertEquals(5, movieEntities.value?.size)

        viewModel.getMovies(1).observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}