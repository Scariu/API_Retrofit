package com.example.api_retrofit.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.api_retrofit.R
import com.example.api_retrofit.databinding.FragmentFirstListaTerrenosBinding

class FirstFragmentListaTerrenos : Fragment() {
    lateinit var binding: FragmentFirstListaTerrenosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstListaTerrenosBinding.inflate(layoutInflater)
        return binding.root
    }
}