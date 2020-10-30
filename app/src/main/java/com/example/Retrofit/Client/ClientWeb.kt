package com.example.xposedtelas.Retrofit.Client

import com.example.xposedtelas.Model.Client
import com.example.xposedtelas.Retrofit.RetrofitInitializer
import com.example.xposedtelas.Retrofit.callback

class ClientWeb {

    fun insert(
        client: Client, success: (client: Client) -> Unit,
        failure: (throwable: Throwable) -> Unit
    ) {
        val call = RetrofitInitializer().clientservice().insert(client)
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