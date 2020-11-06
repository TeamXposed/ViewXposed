package com.example.xposedtelas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.Model.Client
import com.example.xposedtelas.Retrofit.Client.ClientWeb
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_cadastro.email
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.Cadastrar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Cadastrar.setOnClickListener {
            val intent = Intent(this, ActivityCadastro::class.java)
            startActivity(intent)
        }

        buttonLogar.setOnClickListener{
            this.check()
        }
    }

    public fun check(){
        val email: String = editTextTextEmailAddress.text.toString();
        val senha: String = editTextTextPassword.text.toString();
        val nome: String = ""
        val telefone : String = ""
        val cpf : String = ""
        val client = Client(nome = nome,telefone = telefone, email = email, senha = senha, cpf = cpf)

        ClientWeb().select(client, {

            if (email.equals("")  && senha.equals("")){
                Toast.makeText(this, "Por favor informe seu email e senha", Toast.LENGTH_LONG).show()
            }

            if(email.equals(it.email) && senha.equals(it.senha)){
                val intent = Intent(this, activity_rank::class.java)
                startActivity(intent)
            }
        }, {
            Toast.makeText(this, "Usuário não encontrado", Toast.LENGTH_LONG).show()
        })
    }
}
