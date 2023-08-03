package com.example.api_retrofit.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.api_retrofit.data.remote.Terreno
import com.example.api_retrofit.databinding.ItemBinding

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {
    lateinit var binding: ItemBinding
    private val listaTerrenos = mutableListOf<Terreno>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        binding = ItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val terreno = listaTerrenos[position]
        holder.bind(terreno)
    }

    override fun getItemCount(): Int {
        return listaTerrenos.size
    }

    fun setData(listaTerrenos: List<Terreno>) {
            this.listaTerrenos.clear()
            this.listaTerrenos.addAll(listaTerrenos)
            notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(terreno: Terreno) {
            binding.imagenTerreno.load(terreno.image)
            binding.tvType.text = terreno.type
            binding.tvPrice.text = terreno.price.toString()
        }
    }
}