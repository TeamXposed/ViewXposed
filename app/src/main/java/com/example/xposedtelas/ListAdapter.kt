package com.example.xposedtelas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.Model.Denuncia
import kotlinx.android.synthetic.main.activity_list.view.*
import kotlinx.android.synthetic.main.activity_main.view.*

class ListAdapter(
    private val denuncias: MutableList<Denuncia>,
    private val context: Context,
    private var onItemClickListener: (client: Denuncia, position: Int) -> Unit) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val denuncia = denuncias[position]
        holder?.let {
            it.bindView(denuncia)
            it.itemView.setOnClickListener {
                onItemClickListener(denuncia, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return denuncias.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(denuncia: Denuncia) {
            val nome_jogo = itemView.nome_jogo
            val nick_denunciado = itemView.nick_denunciado

            nome_jogo.text = denuncia.nome_jogo
            nick_denunciado.text = denuncia.nick_denunciado
        }
    }
}