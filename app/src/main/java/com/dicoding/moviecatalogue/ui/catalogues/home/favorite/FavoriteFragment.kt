package com.dicoding.moviecatalogue.ui.catalogues.home.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dicoding.moviecatalogue.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {
    private lateinit var favoriteBinding: FragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        favoriteBinding = FragmentFavoriteBinding.inflate(layoutInflater,container,false)
        return favoriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity!=null){
            val sectionPagerAdapter = context?.let { SectionsPagerAdapterFav(it, parentFragmentManager) }
            favoriteBinding.viewpagerFavorite.adapter = sectionPagerAdapter
            favoriteBinding.tabFavorite.setupWithViewPager(favoriteBinding.viewpagerFavorite)
        }
    }
}