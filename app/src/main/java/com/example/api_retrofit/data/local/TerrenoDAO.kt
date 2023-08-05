package com.example.api_retrofit.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TerrenoDAO {
    @Insert
    suspend fun insertarTerrenoFromEntity(terrenoEntity: TerrenoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarTerrenosFromEntity(terrenoEntity: List<TerrenoEntity>)

    @Query("SELECT * FROM tabla_terrenos order by id ASC")
    fun getTodosTerrenosFromEntity(): LiveData<List<TerrenoEntity>>

    @Query("SELECT * FROM tabla_terrenos WHERE id = :id")
    fun getTerrenoWithId(id: String): LiveData<TerrenoEntity>


}
