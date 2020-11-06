package com.example.xposedtelas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.Model.Client
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
            this.validarCampos()
        }
    }

    fun insert(created: (createdClient: Client) -> Unit) {
        val nome: String = nome.text.toString();
        val email: String = email.text.toString();
        val senha: String = senha.text.toString();
        val telefone: String = telefone.text.toString();
        val cpf: String = cpf.text.toString();
        val client = Client(nome = nome,telefone = telefone, email = email, senha = senha, cpf = cpf)

        ClientWeb().insert(client, {
            created(it)
            Toast.makeText(this, "Falha a realizar cadastro", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }, {
            Toast.makeText(this, "Cadastro realizado com sucesso", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
    }

    private fun validarCampos() {
        val campNome: String = nome.text.toString();
        val campEmail: String = email.text.toString();
        val campSenha: String = senha.text.toString();
        val campTelefone: String = telefone.text.toString();
        val campCpf: String = cpf.text.toString();


        if(TextUtils.isEmpty(campNome)){
             nome.error = "Preencha o campo de Nome";
        }else if(campNome.trim().length < 5 ){
            nome.error = "O Nome não pode ter menos de 5 Letras";
        };

        if(TextUtils.isEmpty(campEmail)){
            email.error = "Preencha o campo de Email";
        }else if(campEmail.trim().length < 10 ){
            email.error = "O Email não pode ter menos de 10 Caracteres";
        };

        if(TextUtils.isEmpty(campSenha)){
            senha.error = "Preencha o campo de Senha";
        }else if(campSenha.trim().length < 8 ){
            senha.error = "A Senha não pode ter menos de 8 Letras ";
        };

        if(TextUtils.isEmpty(campCpf)){
            cpf.error = "Preencha o campo de CPF";
        }else if(campCpf.trim().length > 11){
           cpf.error = "O CPF não pode ter mais de 11 Digitos!"
        } else if(campCpf.trim().length < 11){
            cpf.error = "O CPF não pode ter menos de 11 Digitos!";
        };

        if(TextUtils.isEmpty(campTelefone)){
            telefone.error = "Preencha o campo de Telefone";
        }else if(campTelefone.trim().length < 9){
            telefone.error = "O Telefone não pode ter menos de 9 Caracteres ";
        }

        else  {
            this.insert {  };
        }
    }
}