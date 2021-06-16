package com.dicoding.moviecatalogue.ui.catalogues.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.dicoding.moviecatalogue.R
import com.dicoding.moviecatalogue.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)

        val navController = findNavController(R.id.fragment_home_nav)
        activityHomeBinding.bottomnavHome.setupWithNavController(navController)
    }
}