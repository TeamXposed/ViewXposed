package com.example.xposedtelas.Retrofit.Service

import com.example.Model.Cliente
import com.example.Model.Denuncia
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ClienteService {

    @POST("usuario")
    fun insert(@Body cliente: Cliente): Call<Cliente>

    @POST("usuarioselect")
    fun select(@Body cliente: Cliente): Call<Cliente>

    @GET("usuario")
    fun list(): Call<List<Cliente>>

}