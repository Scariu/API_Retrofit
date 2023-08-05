package com.example.api_retrofit.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.api_retrofit.R
import com.example.api_retrofit.databinding.FragmentSecondDetalleTerrenosBinding

class SecondFragmentDetalleTerrenos : Fragment() {
    lateinit var binding: FragmentSecondDetalleTerrenosBinding
    private val viewModel: TerrenoViewModel by activityViewModels()
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString("id")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondDetalleTerrenosBinding.inflate(layoutInflater)
        setComponents()
        return binding.root
    }

    private fun setComponents() {
        viewModel.terrenosLiveDataPorId(param1.toString()).observe(viewLifecycleOwner) {
            binding.tvId.text = it.id
            binding.imageTerreno.load(it.image)
            binding.tvTypeSecond.text = it.type
            binding.tvPriceSecond.text = "$ ${it.price}"
        }
    }
}
