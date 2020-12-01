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
            passEmailDenuncia()
        }

        butt_perfil.setOnClickListener {
            passEmail()
        }

        ButtonTeste.setOnClickListener {
            val intent = Intent(this, activity_listDenuncia::class.java)
            startActivity(intent)
        }

        imageButton7.setOnClickListener {
            onClickValorant()
        }
        imageButton11.setOnClickListener {
            onClickLol()
        }
        imageButton12.setOnClickListener {
            onClickCs()
        }
        imageButton10.setOnClickListener {
            onClickDota2()
        }

        DenunciaWeb().list({
            denuncias.addAll(it)
        }, {
            Toast.makeText(this, "Falha ao buscar denunciados", Toast.LENGTH_LONG).show()
        })
    }


    private fun onClickValorant() {
        textView7.setText("Valorant")
        top1.setText("Vazio")
        top2.setText("Vazio")
        top3.setText("Vazio")
        for (i in denuncias.indices) {
            if (denuncias[i].nome_jogo.trim().toLowerCase().equals("valorant")) {
                if (top1.text.toString().equals("Vazio")) {
                    top1.setText(denuncias[i].nick_denunciado)
                } else if (top2.text.toString().equals("Vazio")) {
                    top2.setText(denuncias[i].nick_denunciado)

                } else if (top3.text.equals("Vazio")) {

                    top3.setText(denuncias[i].nick_denunciado)
                }
            }
        }
    }

    private fun onClickCs() {
        textView7.setText("CS:GO")
        top1.setText("Vazio")
        top2.setText("Vazio")
        top3.setText("Vazio")
        for (i in denuncias.indices) {
            if (denuncias[i].nome_jogo.trim().toLowerCase().equals("cs") ||
                denuncias[i].nome_jogo.trim().toLowerCase().equals("cs:go") ||
                denuncias[i].nome_jogo.trim().toLowerCase().equals("counter strike") ||
                denuncias[i].nome_jogo.trim().toLowerCase().equals("counter-strike")
            ) {

                if (top1.text.toString().equals("Vazio")) {
                    top1.setText(denuncias[i].nick_denunciado)
                } else if (top2.text.toString().equals("Vazio")) {
                    top2.setText(denuncias[i].nick_denunciado)

                } else if (top3.text.equals("Vazio")) {

                    top3.setText(denuncias[i].nick_denunciado)
                }
            }
        }
    }


    private fun onClickLol() {
        textView7.setText("LOL")
        top1.setText("Vazio")
        top2.setText("Vazio")
        top3.setText("Vazio")
        for (i in denuncias.indices) {

            if (denuncias[i].nome_jogo.trim().toLowerCase().equals("lol") ||
                denuncias[i].nome_jogo.trim().toLowerCase().equals("league of legends")
            ) {
                if (top1.text.toString().equals("Vazio")) {
                    top1.setText(denuncias[i].nick_denunciado)
                } else if (top2.text.toString().equals("Vazio")) {
                    top2.setText(denuncias[i].nick_denunciado)

                } else if (top3.text.equals("Vazio")) {
                    top3.setText(denuncias[i].nick_denunciado)
                }
            }
        }
    }

    private fun onClickDota2() {
        textView7.setText("Dota 2")
        top1.setText("Vazio")
        top2.setText("Vazio")
        top3.setText("Vazio")
        for (i in denuncias.indices) {

            if (denuncias[i].nome_jogo.trim().toLowerCase().equals("dota 2" ) ||
                denuncias[i].nome_jogo.trim().toLowerCase().equals("dota2")
            ) {
                if (top1.text.toString().equals("Vazio")) {
                    top1.setText(denuncias[i].nick_denunciado)
                } else if (top2.text.toString().equals("Vazio")) {
                    top2.setText(denuncias[i].nick_denunciado)

                } else if (top3.text.equals("Vazio")) {
                    top3.setText(denuncias[i].nick_denunciado)
                }
            }
        }
    }



    private fun passEmail() {

        var intent1 = Intent(getIntent())
        var parametros1 = Bundle(intent1.getExtras())

        val intent = Intent(applicationContext, activity_perfil::class.java)
        val parametros = Bundle()

        parametros.putString("email", parametros1.getString("email").toString())
        intent.putExtras(parametros1)
        startActivity(intent)
    }

    private fun passEmailDenuncia() {

        var intent1 = Intent(getIntent())
        var parametros1 = Bundle(intent1.getExtras())

        val intent = Intent(applicationContext, activity_denunciar::class.java)
        val parametros = Bundle()

        parametros.putString("email", parametros1.getString("email").toString())
        intent.putExtras(parametros1)
        startActivity(intent)
    }

}
