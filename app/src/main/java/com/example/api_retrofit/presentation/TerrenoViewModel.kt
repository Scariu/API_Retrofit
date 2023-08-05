package com.example.api_retrofit.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.api_retrofit.data.Repositorio
import com.example.api_retrofit.data.local.TerrenoDAO
import com.example.api_retrofit.data.local.TerrenoDataBase
import com.example.api_retrofit.data.remote.Terreno
import com.example.api_retrofit.data.remote.TerrenoRetrofitClient
import kotlinx.coroutines.launch

class TerrenoViewModel(application: Application): AndroidViewModel(application) {
    private val repositorio: Repositorio
    fun terrenosLiveData()= repositorio.obtenerTerrenos()
    init {
        val api = TerrenoRetrofitClient.getRetrofitClientTerreno()
        val terrenoBaseDatos: TerrenoDAO = TerrenoDataBase.getDataBase(application).getTerrenoFromDao()
        repositorio = Repositorio(api, terrenoBaseDatos)
    }
    fun getListaTerrenos() = viewModelScope.launch{
       repositorio.cargarTerreno()
    }
    fun terrenosLiveDataPorId(id: String)= repositorio.obtenerTerrenosConId(id)
}