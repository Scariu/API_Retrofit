package com.example.api_retrofit.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.api_retrofit.R
import com.example.api_retrofit.databinding.FragmentSecondDetalleTerrenosBinding

class SecondFragmentDetalleTerrenos : Fragment() {
lateinit var binding: FragmentSecondDetalleTerrenosBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentSecondDetalleTerrenosBinding.inflate(layoutInflater)
        return binding.root
    }
}