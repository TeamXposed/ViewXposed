package com.example.xposedtelas.Retrofit.Service

import com.example.Model.Client
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ClientService {

    @POST("usuario")
    fun insert(@Body client: Client): Call<Client>

    @POST("usuarioselect")
    fun select(@Body client: Client): Call<Client>


}