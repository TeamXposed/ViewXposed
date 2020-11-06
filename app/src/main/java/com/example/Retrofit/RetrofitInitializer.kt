package com.example.xposedtelas.Retrofit

import com.example.xposedtelas.Retrofit.Service.ClientService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val retrofit = Retrofit.Builder()

        // Colocar o ip da sua máquina
        .baseUrl("http://192.168.11.10:3000")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun clientservice(): ClientService = retrofit.create(ClientService::class.java)

}