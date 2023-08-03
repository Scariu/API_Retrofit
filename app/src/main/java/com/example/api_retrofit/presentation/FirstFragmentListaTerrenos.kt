package com.example.api_retrofit.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.api_retrofit.R
import com.example.api_retrofit.databinding.FragmentFirstListaTerrenosBinding

class FirstFragmentListaTerrenos : Fragment() {
    lateinit var binding: FragmentFirstListaTerrenosBinding
    private val viewModel: TerrenoViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstListaTerrenosBinding.inflate(layoutInflater)
        initListeners()
        return binding.root
    }

    private fun initListeners() {
        binding.btnCargar.setOnClickListener{
            viewModel.getListaTerrenos()
        }
    }
}