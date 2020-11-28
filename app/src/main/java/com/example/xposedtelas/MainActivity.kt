package com.example.xposedtelas

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.Model.Cliente
import com.example.xposedtelas.Retrofit.Client.ClienteWeb
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.Cadastrar
import kotlinx.android.synthetic.main.activity_perfil.*
import kotlinx.android.synthetic.main.activity_rank.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Cadastrar.setOnClickListener {
            val intent = Intent(this, ActivityCadastro::class.java)
            startActivity(intent)
        }
        buttonLogar.setOnClickListener {
            this.validarCampos()

        }
    }

    private fun check() {
        val email: String = editTextTextEmailAddress.text.toString();
        val senha: String = editTextTextPassword.text.toString();
        val nome: String = " ";
        val telefone: String = " ";
        val cpf: String = " ";
        val client =
            Cliente(nome = nome, telefone = telefone, email = email, senha = senha, cpf = cpf);

        ClienteWeb().select(client, {
            Toast.makeText(this, "Bem Vindo!", Toast.LENGTH_LONG).show()
            guardaEmail()
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

    fun guardaEmail() {
        var emailCampo: String = editTextTextEmailAddress.text.toString()
        var email: String = emailCampo

        val intent = Intent(applicationContext, activity_rank::class.java)
        val parametros = Bundle()
        parametros.putString("email", email)
        intent.putExtras(parametros)
        startActivity(intent)

    }
}