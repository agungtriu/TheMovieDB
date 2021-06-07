package com.dicoding.moviecatalogue.catalogues.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.moviecatalogue.catalogues.viewmodel.ViewModelFactory
import com.dicoding.moviecatalogue.databinding.FragmentTvShowBinding

class TvShowFragment : Fragment() {
    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding
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

            val factory = ViewModelFactory.getInstance()
            val viewModel = ViewModelProvider(
                this,
                factory
            )[TvShowViewModel::class.java]
            val tvShowAdapter = TvShowAdapter()
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
    private fun getTvShow(viewModel: TvShowViewModel, tvShowAdapter: TvShowAdapter){
        showLoading()
        viewModel.getTvShows(1).observe(viewLifecycleOwner, {tvShows ->
            hideLoading()
            if (tvShows.isEmpty()){
                dataEmpty()
            }else{
                dataAvailable()
                tvShowAdapter.setTvShow(tvShows)
                tvShowAdapter.notifyDataSetChanged()
            }
        })
    }

    private fun dataEmpty() {
        fragmentTvShowBinding.constraintTvshowEmpty.visibility = View.VISIBLE
        fragmentTvShowBinding.recyclerviewTvshow.visibility = View.GONE
    }

    private fun dataAvailable() {
        fragmentTvShowBinding.constraintTvshowEmpty.visibility = View.GONE
        fragmentTvShowBinding.recyclerviewTvshow.visibility = View.VISIBLE
    }

    private fun showLoading() {
        if (fragmentTvShowBinding.swiperefreshTvshow.isRefreshing){
            fragmentTvShowBinding.progressbarTvshow.visibility = View.GONE
        }else{
            fragmentTvShowBinding.progressbarTvshow.visibility = View.VISIBLE
        }

    }

    private fun hideLoading() {
        fragmentTvShowBinding.progressbarTvshow.visibility = View.GONE
        if (fragmentTvShowBinding.swiperefreshTvshow.isRefreshing){
            fragmentTvShowBinding.swiperefreshTvshow.isRefreshing=false
        }
    }
}