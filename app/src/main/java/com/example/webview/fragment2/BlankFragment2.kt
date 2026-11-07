package com.example.webview.fragment2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.webview.R
import com.example.webview.databinding.FragmentBlank2Binding

class BlankFragment2 : Fragment() {

    private lateinit var _binding: FragmentBlank2Binding
    val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBlank2Binding.inflate(layoutInflater, container, false)
        return _binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textView.text=arguments?.let {
            it.getString("key")
        }
    }
}



