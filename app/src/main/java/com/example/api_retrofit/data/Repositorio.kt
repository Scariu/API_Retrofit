package com.example.api_retrofit.data

import com.example.api_retrofit.data.remote.Terreno
import com.example.api_retrofit.data.remote.TerrenoAPI

class Repositorio(private val terrenoAPI: TerrenoAPI) {
    suspend fun cargarTerreno(): List<Terreno> {
        val response = terrenoAPI.getData()
        if (response.isSuccessful) {
            val resp = response.body()
            resp?.let {
                return it
            }
        }
        return emptyList()
    }
}