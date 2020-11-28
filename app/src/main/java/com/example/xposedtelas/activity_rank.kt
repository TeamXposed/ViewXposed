package com.example.xposedtelas


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.example.Model.Denuncia
import com.example.Retrofit.Function.DenunciaWeb

import kotlinx.android.synthetic.main.activity_rank.*
import java.util.*
import kotlinx.android.synthetic.main.activity_list.nick_denunciado as nick_denunciado1

class activity_rank : AppCompatActivity() {

    private val denuncias: MutableList<Denuncia> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rank)

        butt_denuncia.setOnClickListener {
            val intent = Intent(this, activity_denunciar::class.java)
            startActivity(intent)
        }

        butt_perfil.setOnClickListener {
            guardarEmail()
        }

        ButtonTeste.setOnClickListener {
            val intent = Intent(this, activity_listDenuncia::class.java)
            startActivity(intent)
        }

        DenunciaWeb().list({
            denuncias.addAll(it)
            onClick()
        }, {
            Toast.makeText(this, "Falha ao buscar denunciados", Toast.LENGTH_LONG).show()
        })
    }

    private fun onClick() {

        for (i in denuncias.indices) {
            if (i == 0) {
                top1.setText(denuncias[0].nick_denunciado)
            }
            if (i == 1) {
                top2.setText(denuncias[1].nick_denunciado)
            }
            if (i == 2) {
                top3.setText(denuncias[2].nick_denunciado)
            }
        }
    }

    private fun guardarEmail() {

        var intent1 = Intent(getIntent())
        var parametros1 = Bundle(intent1.getExtras())

        val intent = Intent(applicationContext, activity_perfil::class.java)
        val parametros = Bundle()

        parametros.putString("email", parametros1.getString("email").toString())
        intent.putExtras(parametros1)
        startActivity(intent)
    }
}



