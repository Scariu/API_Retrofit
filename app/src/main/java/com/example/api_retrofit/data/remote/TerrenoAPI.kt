package com.example.api_retrofit.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface TerrenoAPI {
    @GET("realestate")
    //Se ejecuta un GET en un ulr realestate y retorna con la lista
    suspend fun getData(): Response<List<Terreno>>
}