package com.example.api_retrofit.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TerrenoDAO {
    @Insert
    suspend fun insertarTerrenoFromEntity(terrenoEntity: TerrenoEntity)

    @Query("SELECT * FROM tabla_terrenos order by id ASC")
    fun getTodosTerrenosFromEntity(): LiveData<List<TerrenoEntity>>
}
