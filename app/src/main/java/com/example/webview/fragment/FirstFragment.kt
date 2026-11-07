package com.example.webview.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.webview.R
import com.example.webview.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private var nullableBinding: FragmentFirstBinding? = null
    private val binding get() = nullableBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        nullableBinding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return nullableBinding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding!!.textFragment1.text = arguments?.let {
            it.getString("key1")
        }
    }
}


