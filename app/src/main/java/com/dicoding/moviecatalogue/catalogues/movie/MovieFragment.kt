package com.dicoding.moviecatalogue.catalogues.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
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
            val viewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[MovieViewModel::class.java]
            val movies = viewModel.getMovies()
            if (movies.isEmpty()){
                dataEmpty()
            }else{
                dataAvailable()
            }
            val movieAdapter = MovieAdapter()
            movieAdapter.setMovie(movies)
            with(fragmentMovieBinding.recyclerviewMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }
    private fun dataEmpty() {
        fragmentMovieBinding.constraintMovieEmpty.visibility = View.VISIBLE
        fragmentMovieBinding.recyclerviewMovie.visibility = View.GONE
    }
    private fun dataAvailable(){
        fragmentMovieBinding.constraintMovieEmpty.visibility = View.GONE
        fragmentMovieBinding.recyclerviewMovie.visibility = View.VISIBLE
    }
}