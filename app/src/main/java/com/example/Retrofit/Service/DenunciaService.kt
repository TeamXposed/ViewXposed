package com.example.Retrofit.Service

import com.example.Model.Denuncia
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface DenunciaService {

    @POST("denuncia")
    fun insert(@Body denuncia: Denuncia): Call<Denuncia>
}