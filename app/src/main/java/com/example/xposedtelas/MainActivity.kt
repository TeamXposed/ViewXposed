package com.example.xposedtelas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.Model.Client
import com.example.xposedtelas.Retrofit.Client.ClientWeb
import kotlinx.android.synthetic.main.activity_cadastro.*
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

        buttonLogar.setOnClickListener {
            this.Check()
        }
    }

    private fun Check() {
        val nome: String = nome.text.toString();
        val email: String = email.text.toString();
        val senha: String = senha.text.toString();
        val telefone: String = telefone.text.toString();
        val cpf: String = cpf.text.toString();
        val client = Client(nome = nome,telefone = telefone, email = email, senha = senha, cpf = cpf)


        ClientWeb().select(client, {

            if(email == "" && senha == ""){
                Toast.makeText(this, "Email ou senha errado", Toast.LENGTH_LONG).show()
            }
            
            if(email == it.email && senha == it.senha){
                val intent = Intent(this, activity_rank::class.java)
                startActivity(intent)
            }

        }, {
            Toast.makeText(this, "Usuário não encontrado", Toast.LENGTH_LONG).show()
        })
    }
}
