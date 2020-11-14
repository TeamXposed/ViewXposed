package com.example.xposedtelas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_rank.*

class activity_rank : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rank)

        butt_denuncia.setOnClickListener {
            val intent = Intent(this, activity_denunciar::class.java)
            startActivity(intent)
        }

        butt_perfil.setOnClickListener {
            val intent = Intent(this, activity_perfil::class.java)
            startActivity(intent)
        }

    }

}