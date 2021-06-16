package com.dicoding.moviecatalogue.ui.catalogues.home.moviedb.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.moviecatalogue.databinding.FragmentTvShowBinding
import com.dicoding.moviecatalogue.ui.catalogues.viewmodel.ViewModelFactory
import com.dicoding.moviecatalogue.vo.Status

class TvShowFragment : Fragment() {
    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding
    private lateinit var tvShowAdapter: TvShowAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(
                this,
                factory
            )[TvShowViewModel::class.java]
            tvShowAdapter = TvShowAdapter()
            getTvShow(viewModel, tvShowAdapter)
            with(fragmentTvShowBinding.recyclerviewTvshow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
            fragmentTvShowBinding.swiperefreshTvshow.setOnRefreshListener {
                getTvShow(viewModel, tvShowAdapter)
            }
        }
    }

    private fun getTvShow(viewModel: TvShowViewModel, tvShowAdapter: TvShowAdapter) {
        showLoading()
        viewModel.getTvShows(1).observe(viewLifecycleOwner, { tvShows ->
            if (tvShows != null) {
                when (tvShows.status) {
                    Status.LOADING -> showLoading()
                    Status.SUCCESS -> {
                        hideLoading()
                        if (tvShows.data.isNullOrEmpty()) {
                            dataEmpty()
                        } else {
                            dataAvailable()
                            tvShowAdapter.submitList(tvShows.data)
                            tvShowAdapter.notifyDataSetChanged()
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
        fragmentTvShowBinding.apply {
            imgTvshowNotload.visibility = View.VISIBLE
            textviewTvshowNotload.visibility = View.VISIBLE

            imgTvshowEmpty.visibility = View.GONE
            textviewTvshowEmpty.visibility = View.GONE

            recyclerviewTvshow.visibility = View.GONE
        }
    }

    private fun dataEmpty() {
        fragmentTvShowBinding.apply {
            imgTvshowNotload.visibility = View.GONE
            textviewTvshowNotload.visibility = View.GONE

            imgTvshowEmpty.visibility = View.VISIBLE
            textviewTvshowEmpty.visibility = View.VISIBLE

            recyclerviewTvshow.visibility = View.GONE
        }
    }

    private fun dataAvailable() {
        fragmentTvShowBinding.apply {
            imgTvshowNotload.visibility = View.GONE
            textviewTvshowNotload.visibility = View.GONE

            imgTvshowEmpty.visibility = View.GONE
            textviewTvshowEmpty.visibility = View.GONE

            recyclerviewTvshow.visibility = View.VISIBLE
        }
    }

    private fun showLoading() {
        fragmentTvShowBinding.apply {
            if (swiperefreshTvshow.isRefreshing) {
                progressbarTvshow.visibility = View.GONE
            } else {
                progressbarTvshow.visibility = View.VISIBLE
            }
        }
    }

    private fun hideLoading() {
        fragmentTvShowBinding.apply {
            progressbarTvshow.visibility = View.GONE
            if (swiperefreshTvshow.isRefreshing) {
                swiperefreshTvshow.isRefreshing = false
            }
        }
    }
}