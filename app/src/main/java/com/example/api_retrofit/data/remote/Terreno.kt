package com.example.api_retrofit.data.remote

import com.google.gson.annotations.SerializedName

class Terreno(
    val id: String,
    //@SerializedName le dice como se llama en la API (formato JSON)
    @SerializedName("price") val price: Long,
    @SerializedName("type") val type: String,
    @SerializedName("img_src") val image: String
)