package com.example.webview.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.webview.R
import com.example.webview.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {


    private var nullBinding: FragmentSecondBinding? = null
    private val binding get() = nullBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        FragmentSecondBinding.inflate(layoutInflater, container, false)
        return nullBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding!!.textFragment2.text=arguments?.let {
            it.getString("key2")
        }
    }

}