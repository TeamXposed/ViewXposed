package com.example.xposedtelas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.Model.Cliente
import com.example.Model.Denuncia
import com.example.Retrofit.Function.DenunciaWeb
import com.example.xposedtelas.Retrofit.Client.ClienteWeb
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_denunciar.*

class activity_denunciar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_denunciar)

        floatingActionButton3.setOnClickListener {
            passEmail()
        }

        button5.setOnClickListener {
            this.validarCampos()
        }
    }

    fun insert(created: (createdDenuncia: Denuncia) -> Unit) {
        val nome_jogo: String = editTextTextPersonName5.text.toString();
        val assunto: String = editTextTextPersonName.text.toString();
        val nome_denunciante: String = editTextTextPersonName2.text.toString();
        val nick_denunciado: String = editTextTextPersonName3.text.toString();
        val descricao: String = editTextTextPersonName4.text.toString();
        val denun = Denuncia(
            nome_jogo = nome_jogo, assunto = assunto, nome_denunciante = nome_denunciante,
            nick_denunciado = nick_denunciado, descricao = descricao
        )

        DenunciaWeb().insert(denun, {
            Toast.makeText(this, "Falha ao realizar denúncia", Toast.LENGTH_LONG).show()
        }, {
            Toast.makeText(this, "Denúncia realizada com sucesso", Toast.LENGTH_LONG).show()

        })
    }

    private fun validarCampos() {
        val campNome: String = editTextTextPersonName5.text.toString();
        val campAssunto: String = editTextTextPersonName.text.toString();
        val campNomeUser: String = editTextTextPersonName2.text.toString();
        val campNick: String = editTextTextPersonName3.text.toString();
        val campSituação: String = editTextTextPersonName4.text.toString();

        if (TextUtils.isEmpty(campNome)) {
            editTextTextPersonName5.error = "Preencha o campo de Nome";
            return
        } else if (campNome.trim().length < 2) {
            editTextTextPersonName5.error = "O Nome não pode ter menos de 2 Letras";
            return
        };

        if (TextUtils.isEmpty(campAssunto)) {
            editTextTextPersonName.error = "Preencha o campo de Assunto";
            return
        } else if (campAssunto.trim().length < 4) {
            editTextTextPersonName.error = "O Assunto não pode ter menos de 4 Caracteres";
            return
        };

        if (TextUtils.isEmpty(campNomeUser)) {
            editTextTextPersonName2.error = "Preencha o campo de Nome";
            return
        } else if (campNomeUser.trim().length < 4) {
            editTextTextPersonName2.error = "O Nome não pode ter menos de 4 Letras";
            return
        };

        if (TextUtils.isEmpty(campNick)) {
            editTextTextPersonName3.error = "Preencha o campo de Nick";
            return
        } else if (campNick.trim().length < 4) {
            editTextTextPersonName3.error = "O Nick não pode ter menos de 4 Letras";
            return
        };

        if (TextUtils.isEmpty(campSituação)) {
            editTextTextPersonName4.error = "Preencha o campo de Situação";
            return
        } else if (campSituação.trim().length < 4) {
            editTextTextPersonName4.error = "A Situação não pode ter menos de 4 Letras"
            return
        } else {
            this.insert { }

            var intent1 = Intent(getIntent())
            var parametros1 = Bundle(intent1.getExtras())

            val intent = Intent(applicationContext, activity_rank::class.java)
            val parametros = Bundle()

            parametros.putString("email", parametros1.getString("email").toString())
            intent.putExtras(parametros1)
            startActivity(intent)
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
}