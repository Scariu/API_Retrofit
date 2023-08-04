package com.example.api_retrofit.data

import androidx.lifecycle.LiveData
import com.example.api_retrofit.data.local.TerrenoDAO
import com.example.api_retrofit.data.local.TerrenoEntity
import com.example.api_retrofit.data.remote.Terreno
import com.example.api_retrofit.data.remote.TerrenoAPI
import retrofit2.Response

class Repositorio(private val terrenoAPI: TerrenoAPI, private val terrenoDAO: TerrenoDAO) {

    fun obtenerTerrenos(): LiveData<List<TerrenoEntity>> = terrenoDAO.getTodosTerrenosFromEntity()
    suspend fun cargarTerreno() {
        val response: Response<List<Terreno>> = terrenoAPI.getData()
        if (response.isSuccessful) {
            val resp: List<Terreno>? = response.body()
            resp?.let { terrenos ->
                val terrenosEntity = terrenos.map { it.transformToEntity() }
                terrenoDAO.insertarTerrenosFromEntity(terrenosEntity)
            }
        }
    }
}

//Desde un terreno creamos un terrenoEntity
fun Terreno.transformToEntity(): TerrenoEntity =
    TerrenoEntity(this.id, this.price, this.type, this.image)