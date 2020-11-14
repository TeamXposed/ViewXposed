package com.example.xposedtelas.Retrofit.Client

import com.example.Model.Cliente
import com.example.xposedtelas.Retrofit.RetrofitInitializer
import com.example.xposedtelas.Retrofit.callback

class ClienteWeb {

    fun insert(
        cliente: Cliente, success: (cliente: Cliente) -> Unit,
        failure: (throwable: Throwable) -> Unit
    ) {
        val call = RetrofitInitializer().clienteservice().insert(cliente)
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

    fun select(
        cliente: Cliente, success: (cliente: Cliente) -> Unit,
        failure: (throwable: Throwable) -> Unit
    ) {
        val call = RetrofitInitializer().clienteservice().select(cliente)
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