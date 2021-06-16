package com.dicoding.moviecatalogue.ui.catalogues.home.moviedb.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.moviecatalogue.databinding.FragmentMovieBinding
import com.dicoding.moviecatalogue.ui.catalogues.viewmodel.ViewModelFactory
import com.dicoding.moviecatalogue.vo.Status

class MovieFragment : Fragment() {
    private lateinit var fragmentMovieBinding: FragmentMovieBinding
    private lateinit var movieAdapter: MovieAdapter
    var page = 1
    var size = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(
                this,
                factory
            )[MovieViewModel::class.java]

            movieAdapter = MovieAdapter()
            getData(viewModel, movieAdapter)
            with(fragmentMovieBinding.recyclerviewMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }

            fragmentMovieBinding.swiperefreshMovie.setOnRefreshListener {
                page = 1
                getData(viewModel, movieAdapter)
            }
        }
    }

    private fun getData(viewModel: MovieViewModel, movieAdapter: MovieAdapter) {
        showLoading()
        viewModel.getMovies(page).observe(viewLifecycleOwner, { movies ->
            if (movies != null) {
                when (movies.status) {
                    Status.LOADING -> showLoading()
                    Status.SUCCESS -> {
                        hideLoading()
                        if (movies.data.isNullOrEmpty()) {
                            dataEmpty()
                        } else {
                            dataAvailable()
                            movieAdapter.submitList(movies.data)
                            movieAdapter.notifyDataSetChanged()
                            size = movieAdapter.itemCount
                        }
                    }
                    Status.ERROR -> {
                        hideLoading()
                        dataNotLoad()
                    }
                }
            }
        })
    }

    private fun dataNotLoad() {
        fragmentMovieBinding.apply {
            imgMovieNotload.visibility = View.VISIBLE
            textviewMovieNotload.visibility = View.VISIBLE

            imgMovieEmpty.visibility = View.GONE
            textviewMovieEmpty.visibility = View.GONE

            recyclerviewMovie.visibility = View.GONE
        }
    }

    private fun dataEmpty() {
        fragmentMovieBinding.apply {
            imgMovieNotload.visibility = View.GONE
            textviewMovieNotload.visibility = View.GONE

            imgMovieEmpty.visibility = View.VISIBLE
            textviewMovieEmpty.visibility = View.VISIBLE

            recyclerviewMovie.visibility = View.GONE
        }
    }

    private fun dataAvailable() {
        fragmentMovieBinding.apply {
            imgMovieNotload.visibility = View.GONE
            textviewMovieNotload.visibility = View.GONE

            imgMovieEmpty.visibility = View.GONE
            textviewMovieEmpty.visibility = View.GONE

            recyclerviewMovie.visibility = View.VISIBLE
        }
    }

    private fun showLoading() {
        fragmentMovieBinding.apply {
            if (swiperefreshMovie.isRefreshing) {
                progressbarMovie.visibility = View.GONE
            } else {
                progressbarMovie.visibility = View.VISIBLE
            }
        }
    }

    private fun hideLoading() {
        fragmentMovieBinding.apply {
            progressbarMovie.visibility = View.GONE
            if (swiperefreshMovie.isRefreshing) {
                swiperefreshMovie.isRefreshing = false
            }
        }
    }
}