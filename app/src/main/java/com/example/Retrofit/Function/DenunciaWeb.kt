package com.example.Retrofit.Function

import com.example.Model.Cliente
import com.example.Model.Denuncia
import com.example.xposedtelas.Retrofit.RetrofitInitializer
import com.example.xposedtelas.Retrofit.callback

class DenunciaWeb {

    fun insert(
        denuncia: Denuncia, success: (denuncia: Denuncia) -> Unit,
        failure: (throwable: Throwable) -> Unit
    ) {
        val call = RetrofitInitializer().denunciaservice().insert(denuncia)
        call.enqueue(callback({ response ->
            response?.body()?.let {
                success(it)
            }
        }, { throwable ->
            throwable?.let {
                failure(it)
            }
        }))
    }
}