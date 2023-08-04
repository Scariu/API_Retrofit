package com.example.api_retrofit.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.api_retrofit.data.local.TerrenoEntity
import com.example.api_retrofit.data.remote.Terreno
import com.example.api_retrofit.databinding.ItemBinding

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {
    lateinit var binding: ItemBinding
    private val listaTerrenos = mutableListOf<TerrenoEntity>()

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

    fun setData(listaTerrenos: List<TerrenoEntity>) {
            this.listaTerrenos.clear()
            this.listaTerrenos.addAll(listaTerrenos)
            notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(terrenoEntity: TerrenoEntity) {
            binding.imagenTerreno.load(terrenoEntity.image)
            binding.tvType.text = terrenoEntity.type
            binding.tvPrice.text = terrenoEntity.price.toString()
        }
    }
}