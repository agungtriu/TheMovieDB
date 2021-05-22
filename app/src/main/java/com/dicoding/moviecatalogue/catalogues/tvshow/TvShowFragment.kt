package com.dicoding.moviecatalogue.catalogues.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
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
            val viewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[TvShowViewModel::class.java]
            val tvShows = viewModel.getTvShows()
            if (tvShows.isEmpty()){
                dataEmpty()
            }else{
                dataAvailable()
            }
            val tvShowAdapter = TvShowAdapter()
            tvShowAdapter.setTvShow(tvShows)

            with(fragmentTvShowBinding.recyclerviewTvshow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }

    private fun dataEmpty() {
        fragmentTvShowBinding.constraintTvshowEmpty.visibility = View.VISIBLE
        fragmentTvShowBinding.recyclerviewTvshow.visibility = View.GONE
    }
    private fun dataAvailable(){
        fragmentTvShowBinding.constraintTvshowEmpty.visibility = View.GONE
        fragmentTvShowBinding.recyclerviewTvshow.visibility = View.VISIBLE
    }
}