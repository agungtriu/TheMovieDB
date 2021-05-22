package com.dicoding.moviecatalogue.catalogues.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.moviecatalogue.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)

        val sectionPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        activityHomeBinding.viewpagerHome.adapter = sectionPagerAdapter
        activityHomeBinding.tabHome.setupWithViewPager(activityHomeBinding.viewpagerHome)

    }
}