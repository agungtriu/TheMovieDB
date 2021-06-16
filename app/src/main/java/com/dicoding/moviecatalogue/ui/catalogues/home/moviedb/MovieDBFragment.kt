package com.dicoding.moviecatalogue.ui.catalogues.home.moviedb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dicoding.moviecatalogue.databinding.FragmentMoviedbBinding


class MovieDBFragment : Fragment() {
    private lateinit var moviedbBinding: FragmentMoviedbBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        moviedbBinding = FragmentMoviedbBinding.inflate(layoutInflater,container,false)
        return moviedbBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity!=null){
            val sectionPagerAdapter = context?.let { SectionsPagerAdapter(it, parentFragmentManager) }
            moviedbBinding.viewpagerMoviedb.adapter = sectionPagerAdapter
            moviedbBinding.tabMoviedb.setupWithViewPager(moviedbBinding.viewpagerMoviedb)
        }
    }
}