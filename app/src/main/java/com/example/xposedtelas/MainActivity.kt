package com.example.xposedtelas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
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
            this.validarCampos()
        }
    }

    private fun check() {
        val email: String = editTextTextEmailAddress.text.toString();
        val senha: String = editTextTextPassword.text.toString();
        val nome: String = " ";
        val telefone: String = " ";
        val cpf: String = " ";
        val client = Client(nome = nome, telefone = telefone, email = email, senha = senha, cpf = cpf);

        ClientWeb().select(client, {

            Toast.makeText(this, "Entrou", Toast.LENGTH_LONG).show()
            val intent = Intent(this,activity_rank ::class.java)
            startActivity(intent)

        }, {
            Toast.makeText(this, "Email ou Senha incorreto", Toast.LENGTH_LONG).show()
        })

    }

    private fun validarCampos() {
        val email: String = editTextTextEmailAddress.text.toString();
        val senha: String = editTextTextPassword.text.toString();

        if (TextUtils.isEmpty(email)) {
            editTextTextEmailAddress.error = "Preencha o campo de Email";
        } else if (email.trim().length < 10) {
            editTextTextEmailAddress.error = "O Email não pode ter menos de 10 Caracteres";
        };

        if (TextUtils.isEmpty(senha)) {
            editTextTextPassword.error = "Preencha o campo de Senha";
        } else if (senha.trim().length < 8) {
            editTextTextPassword.error = "A Senha não pode ter menos de 8 Letras ";
        };
        else {
            this.check();
        }


    }

}
