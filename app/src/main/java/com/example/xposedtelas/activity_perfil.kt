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
            guardaEmail()
            val intent = Intent(this, activity_rank::class.java)
            startActivity(intent)
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
            if ( usuario[i].email.equals(parametros.getString("email").toString())) {
                textView6.setText(usuario[i].nome)
                return
            }else if(i == usuario.size){
                textView6.setText("Vazio")
            }

        }
    }

    private fun guardaEmail() {

        var intent2 = Intent(getIntent())
        var parametros2 = Bundle(intent2.getExtras())

        val intent = Intent(applicationContext, activity_perfil::class.java)
        val parametros = Bundle()

        parametros.putString("email", parametros2.getString("email").toString())
        intent.putExtras(parametros2)
        startActivity(intent)
    }


    private fun onClick() {

        var denunciado: String = ""
        var denunciado3: String

        for (i in denuncias.indices) {
            var denunciado2: String = denuncias[i].nick_denunciado
            denunciado3 = denunciado2;
            textView10.setText(denunciado)
            denunciado = denunciado3 + ", " + textView10.text.toString()
        }
    }
}
