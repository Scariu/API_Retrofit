package com.example.api_retrofit.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "tabla_terrenos")
data class TerrenoEntity(@PrimaryKey var id: String, val price: Long, val type: String, val image: String)