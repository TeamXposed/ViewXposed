package com.example.xposedtelas.Retrofit

import com.example.Retrofit.Service.DenunciaService
import com.example.xposedtelas.Retrofit.Service.ClienteService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val retrofit = Retrofit.Builder()

        // Colocar o ip da sua máquina
        .baseUrl("http://10.0.45.172:3000")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun clienteservice(): ClienteService = retrofit.create(ClienteService::class.java)
    fun denunciaservice(): DenunciaService = retrofit.create(DenunciaService::class.java)

}