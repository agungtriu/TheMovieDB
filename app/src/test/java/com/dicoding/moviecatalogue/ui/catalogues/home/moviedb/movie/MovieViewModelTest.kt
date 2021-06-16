package com.dicoding.moviecatalogue.ui.catalogues.home.moviedb.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.moviecatalogue.data.source.CatalogueRepository
import com.dicoding.moviecatalogue.data.source.local.entity.CatalogueEntity
import com.dicoding.moviecatalogue.vo.Resource
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
    private lateinit var observer: Observer<Resource<PagedList<CatalogueEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<CatalogueEntity>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(catalogueRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = Resource.success(pagedList)
        `when`(dummyMovies.data?.size).thenReturn(5)
        val expected = MutableLiveData<Resource<PagedList<CatalogueEntity>>>()
        expected.value = dummyMovies

        `when`(catalogueRepository.getMovies(1)).thenReturn(expected)
        val movieEntities = viewModel.getMovies(1).value?.data
        verify(catalogueRepository).getMovies(1)
        TestCase.assertNotNull(movieEntities)
        TestCase.assertEquals(5, movieEntities?.size)

        viewModel.getMovies(1).observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}