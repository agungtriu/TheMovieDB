package com.dicoding.moviecatalogue.ui.catalogues.home.favorite.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.moviecatalogue.databinding.FragmentTvShowBinding
import com.dicoding.moviecatalogue.ui.catalogues.home.favorite.FavoriteAdapter
import com.dicoding.moviecatalogue.ui.catalogues.viewmodel.ViewModelFactory

class TvShowFavFragment : Fragment() {
    private lateinit var fragmentTvShowFavBinding: FragmentTvShowBinding
    private lateinit var tvShowAdapter: FavoriteAdapter
    private lateinit var viewModel:TvShowFavViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvShowFavBinding = FragmentTvShowBinding.inflate(layoutInflater,container,false)
        return fragmentTvShowFavBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(
                this,
                factory
            )[TvShowFavViewModel::class.java]
            tvShowAdapter = FavoriteAdapter()
            getTvShow(viewModel, tvShowAdapter)
            with(fragmentTvShowFavBinding.recyclerviewTvshow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
            fragmentTvShowFavBinding.swiperefreshTvshow.setOnRefreshListener {
                getTvShow(viewModel, tvShowAdapter)
            }
        }
    }

    private fun getTvShow(viewModel: TvShowFavViewModel, tvShowAdapter: FavoriteAdapter) {
        showLoading()
        viewModel.getTvShowFavorites().observe(viewLifecycleOwner, { tvShows ->
            if (tvShows.isEmpty()) {
                dataEmpty()
            } else {
                dataAvailable()
                tvShowAdapter.submitList(tvShows)
                tvShowAdapter.notifyDataSetChanged()
            }
            hideLoading()
        })
    }

    private fun dataEmpty() {
        fragmentTvShowFavBinding.apply {

            imgTvshowEmpty.visibility = View.VISIBLE
            textviewTvshowEmpty.visibility = View.VISIBLE

            recyclerviewTvshow.visibility = View.GONE
        }
    }

    private fun dataAvailable() {
        fragmentTvShowFavBinding.apply {

            imgTvshowEmpty.visibility = View.GONE
            textviewTvshowEmpty.visibility = View.GONE

            recyclerviewTvshow.visibility = View.VISIBLE
        }
    }

    private fun showLoading() {
        fragmentTvShowFavBinding.apply {
            if (swiperefreshTvshow.isRefreshing) {
                progressbarTvshow.visibility = View.GONE
            } else {
                progressbarTvshow.visibility = View.VISIBLE
            }
        }
    }

    private fun hideLoading() {
        fragmentTvShowFavBinding.apply {
            progressbarTvshow.visibility = View.GONE
            if (swiperefreshTvshow.isRefreshing) {
                swiperefreshTvshow.isRefreshing = false
            }
        }
    }
}