package com.example.webview.instagram

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.webview.R
import com.example.webview.databinding.InstagramLayoutBinding

class InstagramNavigation :AppCompatActivity() {
    lateinit var binding:InstagramLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= InstagramLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment=supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as
                NavHostFragment
        binding.instagramNavigation.setupWithNavController(navHostFragment.navController)

        val app=
            AppBarConfiguration.Builder(R.id.instagramHome,R.id.instagramSearch,R.id.instagramAdd,R.id.instagramReels,R.id.instagramProfile).build()
        NavigationUI.setupActionBarWithNavController(this,navHostFragment.navController,app)
    }
}