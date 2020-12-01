package com.example.xposedtelas

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.Model.Cliente
import com.example.Model.Denuncia
import com.example.Retrofit.Function.DenunciaWeb
import com.example.xposedtelas.Retrofit.Client.ClienteWeb
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_cadastro.view.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_perfil.*
import kotlinx.android.synthetic.main.activity_rank.*
import java.util.*
import com.example.xposedtelas.MainActivity as MainActivity

class activity_perfil : AppCompatActivity() {
    private val denuncias: MutableList<Denuncia> = mutableListOf()
    private val usuario: MutableList<Cliente> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        floatingActionButton2.setOnClickListener {
            passEmail()
            textView10.clearComposingText()
        }

        button4.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Desconectado!", Toast.LENGTH_LONG).show()
        }


        DenunciaWeb().list({
            denuncias.addAll(it)
            onClick()
        }, {
            Toast.makeText(this, "Falha ao buscar denunciados", Toast.LENGTH_LONG).show()
        })


        ClienteWeb().list({
            usuario.addAll(it)
            checkEmail()
        }, {
            Toast.makeText(this, "Falha ao buscar nome do usuario", Toast.LENGTH_LONG).show()
        })

    }

    private fun checkEmail() {

        var intent = Intent(getIntent())
        var parametros = Bundle(intent.getExtras())

        for (i in usuario.indices) {
            if (usuario[i].email.equals(parametros.getString("email").toString())) {
                textView6.setText("Olá, " + usuario[i].nome)
            }
        }
    }

    private fun passEmail() {

        var intent1 = Intent(getIntent())
        var parametros1 = Bundle(intent1.getExtras())

        val intent = Intent(applicationContext, activity_rank::class.java)
        val parametros = Bundle()

        parametros.putString("email", parametros1.getString("email").toString())
        intent.putExtras(parametros1)
        startActivity(intent)
    }

    private fun onClick() {

        var intent = Intent(getIntent())
        var parametros = Bundle(intent.getExtras())



        for (i in denuncias.indices) {
            if (parametros.getString("email").toString().equals(denuncias[i].nome_denunciante)) {
                textView10.setText(denuncias[i].nick_denunciado + ", " + textView10.text.toString())
            }
        }
        if (textView10.text.toString().equals(" ")) {
            textView10.setText("Sem Denúncias")
        }

    }

}
