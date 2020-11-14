package com.example.xposedtelas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_denunciar.*

class activity_denunciar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_denunciar)

        floatingActionButton3.setOnClickListener {
            val intent = Intent(this, activity_rank::class.java)
            startActivity(intent)
        }
    }
}