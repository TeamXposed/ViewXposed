package com.example.xposedtelas.Retrofit.Service

import com.example.Model.Cliente
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ClienteService {

    @POST("usuario")
    fun insert(@Body cliente: Cliente): Call<Cliente>

    @POST("usuarioselect")
    fun select(@Body cliente: Cliente): Call<Cliente>

}