package com.example.xposedtelas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.xposedtelas.Model.Client
import com.example.xposedtelas.Retrofit.Client.ClientWeb
import kotlinx.android.synthetic.main.activity_cadastro.*

class ActivityCadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        BtnVoltar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        Cadastrar.setOnClickListener(){
            this.insert { }
        }
    }

    fun insert(created: (createdClient: Client) -> Unit) {
        val nome: String = nome.text.toString();
        val email: String = email.text.toString();
        val senha: String = senha.text.toString();
        val telefone: String = telefone.text.toString();
        val cpf: String = cpf.text.toString();
        val client = Client(nome = nome, email = email, senha = senha, telefone = telefone, cpf = cpf)

        ClientWeb().insert(client, {
            created(it)
            Toast.makeText(this, "Cadastro realizado com sucesso", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }, {
            Toast.makeText(this, "Falha ao realizar cadastro", Toast.LENGTH_LONG).show()
        })
    }





}