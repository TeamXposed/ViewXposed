package com.example.xposedtelas.Retrofit.Service

import com.example.xposedtelas.Model.Client
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ClientService {

    @GET("usuario")
    fun list(): Call<List<Client>>

    @POST("usuario")
    fun insert(@Body client: Client): Call<Client>

}