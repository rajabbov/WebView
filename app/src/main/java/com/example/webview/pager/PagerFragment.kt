package com.example.webview.pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.webview.R
import com.example.webview.databinding.ItemPagerBinding

class PagerFragment :Fragment() {
    private var _binding:ItemPagerBinding?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    _binding=ItemPagerBinding.inflate(layoutInflater,container,false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.apply {
binding.imageView.setImageResource(getInt("image",R.drawable.telegram))
            binding.titleTv.text=getString("title")
            binding.descriptionTv.text=getString("des")
        }
    }
}