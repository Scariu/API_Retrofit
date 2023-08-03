package com.example.api_retrofit.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.api_retrofit.data.Repositorio
import com.example.api_retrofit.data.remote.Terreno
import com.example.api_retrofit.data.remote.TerrenoRetrofitClient
import kotlinx.coroutines.launch

class TerrenoViewModel(application: Application): AndroidViewModel(application) {
    private val repositorio: Repositorio
    val terrenosLiveData = MutableLiveData<List<Terreno>>()
    init {
        val api = TerrenoRetrofitClient.getRetrofitClientTerreno()
        repositorio = Repositorio(api)
    }
    fun getListaTerrenos() = viewModelScope.launch{
        terrenosLiveData.value = repositorio.cargarTerreno()
    }
}