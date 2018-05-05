package com.example.logonpf.meusjogosfavoritos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import android.widget.Toast
import com.example.logonpf.meusjogosfavoritos.adapter.JogoAdapter
import com.example.logonpf.meusjogosfavoritos.model.Jogo
import kotlinx.android.synthetic.main.activity_lista.*

class ListaActivity : AppCompatActivity() {

    private var adapter: JogoAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        adapter = JogoAdapter(this, getJogos(), {
            val intentDetalhe = Intent(this,
                    DetalheActivity::class.java)

            intentDetalhe.putExtra("jogo", it)

            startActivity(intentDetalhe)
        }, {
            Toast.makeText(this, "Delete ${it.titulo}",
                    Toast.LENGTH_LONG).show()

        })
        rvJogos.adapter = adapter
        rvJogos.layoutManager = LinearLayoutManager(this)
    }

    fun getJogos(): List<Jogo> {
        return listOf(
                Jogo(getString(R.string.titulo_god_of_war),
                        getString(R.string.descricao_god_of_war),
                        2018,
                        R.drawable.godofwar,
                        R.drawable.godofwarbanner)
        )
    }
}
