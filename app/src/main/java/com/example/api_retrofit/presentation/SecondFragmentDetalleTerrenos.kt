package com.example.api_retrofit.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.example.api_retrofit.R
import com.example.api_retrofit.databinding.FragmentSecondDetalleTerrenosBinding

class SecondFragmentDetalleTerrenos : Fragment() {
lateinit var binding: FragmentSecondDetalleTerrenosBinding
    private var param1: String? = null
    private var param2: String? = null
    private var param3: String? = null
    private var param4: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString("id")
            param2 = it.getString("type")
            param3 = it.getString("price")
            param4 = it.getString("image")
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
            binding.imageTerreno.load(param4)
            binding.tvTypeSecond.text = param2
            binding.tvPriceSecond.text ="$ $param3"
        }
    }
