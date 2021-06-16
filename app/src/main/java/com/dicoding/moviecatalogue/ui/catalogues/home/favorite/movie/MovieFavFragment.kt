package com.dicoding.moviecatalogue.ui.catalogues.home.favorite.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.moviecatalogue.databinding.FragmentMovieBinding
import com.dicoding.moviecatalogue.ui.catalogues.home.favorite.FavoriteAdapter
import com.dicoding.moviecatalogue.ui.catalogues.viewmodel.ViewModelFactory

class MovieFavFragment : Fragment() {
    private lateinit var fragmentMovieFavBinding: FragmentMovieBinding
    private lateinit var movieAdapter: FavoriteAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMovieFavBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieFavBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(
                this,
                factory
            )[MovieFavViewModel::class.java]

            movieAdapter = FavoriteAdapter()
            getData(viewModel, movieAdapter)
            with(fragmentMovieFavBinding.recyclerviewMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }

            fragmentMovieFavBinding.swiperefreshMovie.setOnRefreshListener {
                getData(viewModel, movieAdapter)
            }
        }
    }

    private fun getData(viewModel: MovieFavViewModel, movieAdapter: FavoriteAdapter) {
        showLoading()
        viewModel.getMovieFavorites().observe(viewLifecycleOwner, { movies ->
            if (movies.isEmpty()) {
                dataEmpty()
            } else {
                dataAvailable()
                movieAdapter.submitList(movies)
                movieAdapter.notifyDataSetChanged()
            }
            hideLoading()
        })
    }

    private fun dataEmpty() {
        fragmentMovieFavBinding.apply {

            imgMovieEmpty.visibility = View.VISIBLE
            textviewMovieEmpty.visibility = View.VISIBLE

            recyclerviewMovie.visibility = View.GONE
        }
    }

    private fun dataAvailable() {
        fragmentMovieFavBinding.apply {

            imgMovieEmpty.visibility = View.GONE
            textviewMovieEmpty.visibility = View.GONE

            recyclerviewMovie.visibility = View.VISIBLE
        }
    }

    private fun showLoading() {
        fragmentMovieFavBinding.apply {
            if (swiperefreshMovie.isRefreshing) {
                progressbarMovie.visibility = View.GONE
            } else {
                progressbarMovie.visibility = View.VISIBLE
            }
        }
    }

    private fun hideLoading() {
        fragmentMovieFavBinding.apply {
            progressbarMovie.visibility = View.GONE
            if (swiperefreshMovie.isRefreshing) {
                swiperefreshMovie.isRefreshing = false
            }
        }
    }
}