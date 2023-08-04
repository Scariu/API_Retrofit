package com.example.api_retrofit.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.api_retrofit.R
import com.example.api_retrofit.databinding.FragmentFirstListaTerrenosBinding
import kotlinx.coroutines.launch

class FirstFragmentListaTerrenos : Fragment() {
    lateinit var binding: FragmentFirstListaTerrenosBinding
    private val viewModel: TerrenoViewModel by activityViewModels()
    private val adapter = Adapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstListaTerrenosBinding.inflate(layoutInflater)
        initListeners()
        return binding.root
    }

    private fun initAdapter() {
        viewModel.getListaTerrenos()//Obtiene informacion
        val adapter = Adapter()
        binding.recyclerViewFirst.adapter = adapter
        //Observa la lista y esta atento a cambios
        viewModel.terrenosLiveData().observe(viewLifecycleOwner){
            adapter.setData(it)
        }
    }

    private fun initListeners() {
        binding.btnCargar.setOnClickListener{
            viewModel.getListaTerrenos()
            initAdapter()
        }
    }
}