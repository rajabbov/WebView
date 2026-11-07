package com.example.webview.button

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.webview.R
import com.example.webview.databinding.BottomLayoutBinding

class BottomNavigation :AppCompatActivity() {
    lateinit var binding:BottomLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= BottomLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment=supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as
                NavHostFragment
        binding.bottomNavigation.setupWithNavController(navHostFragment.navController)

        val app=
            AppBarConfiguration.Builder(R.id.homeFragment,R.id.settingFragment,R.id.addFragment,R.id.searchFragment,R.id.timeFragment).build()
        NavigationUI.setupActionBarWithNavController(this,navHostFragment.navController,app)
    }
}