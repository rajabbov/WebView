package com.example.webview.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class CustomViewPagerAdapter(activity: MainActivity) :FragmentStateAdapter(activity){
    override fun getItemCount(): Int {
        return 10
    }

    override fun createFragment(position: Int): Fragment {
        return SimpleFragment().apply {
            arguments= Bundle().apply {
                putString("key",position.toString())
            }
        }
    }
}