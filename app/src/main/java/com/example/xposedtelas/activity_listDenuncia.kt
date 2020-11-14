package com.example.xposedtelas

import android.content.Context
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.Model.Denuncia
import com.example.Retrofit.Function.DenunciaWeb
import kotlinx.android.synthetic.main.activity_list.*

class activity_listDenuncia : AppCompatActivity() {
    private val denuncias: MutableList<Denuncia> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        DenunciaWeb().list({
            denuncias.addAll(it)
            configureList()
            Toast.makeText(this, "Trouxe", Toast.LENGTH_LONG).show()
        }, {
            Toast.makeText(this, "Falha ao buscar clientes", Toast.LENGTH_LONG).show()
        })
    }

    class NoteDialog(
        private val viewGroup: ViewGroup,
        private val context: Context
    )

    private fun configureList() {
        val recyclerView = recyclerview
        recyclerView.adapter = ListAdapter(denuncias, this) { note, position ->
        }
        val layoutManager = StaggeredGridLayoutManager(
            2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
    }
}