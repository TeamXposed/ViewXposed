package com.example.xposedtelas

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Sampler
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.Model.Denuncia
import com.example.Retrofit.Function.DenunciaWeb
import com.example.Retrofit.Service.DenunciaService
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_list.*
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
            val intent = Intent(this, activity_perfil::class.java)
            startActivity(intent)
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
        
        top1.setText(denuncias[0].nick_denunciado)
        top2.setText(denuncias[1].nick_denunciado)
        top3.setText(denuncias[2].nick_denunciado)


    }


}



