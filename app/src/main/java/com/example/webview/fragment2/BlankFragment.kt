package com.example.webview.fragment2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.webview.R
import com.example.webview.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {

private lateinit var intirface:FirstFragmentInterface
private lateinit var _binding:FragmentBlankBinding
    private val binding get() = _binding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        intirface=activity as FragmentActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentBlankBinding.inflate(layoutInflater, container, false)

        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            val text=binding.editText.text.toString()
            intirface.onClickButton(text)
        }
    }
}