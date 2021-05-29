package com.dicoding.moviecatalogue.catalogues.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.moviecatalogue.catalogues.viewmodel.ViewModelFactory
import com.dicoding.moviecatalogue.databinding.FragmentMovieBinding

class MovieFragment : Fragment() {
    private lateinit var fragmentMovieBinding: FragmentMovieBinding
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
            val factory = ViewModelFactory.getInstance()
            val viewModel = ViewModelProvider(
                this,
                factory
            )[MovieViewModel::class.java]

            val movieAdapter = MovieAdapter()
            getData(viewModel,movieAdapter)
            with(fragmentMovieBinding.recyclerviewMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }

            fragmentMovieBinding.swiperefreshMovie.setOnRefreshListener {
                getData(viewModel, movieAdapter)
            }
        }
    }

    private fun getData(viewModel: MovieViewModel, movieAdapter: MovieAdapter){
        showLoading()
        viewModel.getMovies(1).observe(viewLifecycleOwner, { movies ->
            hideLoading()
            if (movies.isEmpty()){
                dataEmpty()
            }else{
                dataAvailable()
                movieAdapter.setMovie(movies)
                movieAdapter.notifyDataSetChanged()
            }
        })
    }

    private fun dataEmpty() {
        fragmentMovieBinding.constraintMovieEmpty.visibility = View.VISIBLE
        fragmentMovieBinding.recyclerviewMovie.visibility = View.GONE
    }

    private fun dataAvailable() {
        fragmentMovieBinding.constraintMovieEmpty.visibility = View.GONE
        fragmentMovieBinding.recyclerviewMovie.visibility = View.VISIBLE
    }

    private fun showLoading() {
        if (fragmentMovieBinding.swiperefreshMovie.isRefreshing){
            fragmentMovieBinding.progressbarMovie.visibility = View.GONE
        }else{
            fragmentMovieBinding.progressbarMovie.visibility = View.VISIBLE
        }
    }

    private fun hideLoading() {
        fragmentMovieBinding.progressbarMovie.visibility = View.GONE
        if (fragmentMovieBinding.swiperefreshMovie.isRefreshing){
            fragmentMovieBinding.swiperefreshMovie.isRefreshing=false
        }
    }
}