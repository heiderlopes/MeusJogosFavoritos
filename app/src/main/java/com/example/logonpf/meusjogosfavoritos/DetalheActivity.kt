package com.example.logonpf.meusjogosfavoritos

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.example.logonpf.meusjogosfavoritos.model.Jogo
import kotlinx.android.synthetic.main.activity_detalhe.*
import kotlinx.android.synthetic.main.content_detalhe.*

class DetalheActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val jogo = intent.getParcelableExtra<Jogo>("jogo")
        toolbar_layout.title = jogo.titulo
        ivBanner.setImageDrawable(ContextCompat.getDrawable(this,
                jogo.bannerId))

        tvDescricao.text = jogo.descricao

        fab.setOnClickListener { view ->
            val whatsAppMessage = "Olá meu jogo preferido é ${jogo.titulo}"

            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT, whatsAppMessage)
            sendIntent.type = "text/plain"

            // Do not forget to add this to open whatsApp App specifically
            sendIntent.`package` = "com.whatsapp"

            startActivity(sendIntent)

           /* try {
                val text = "Olá meu jogo preferido é ${jogo.titulo}"// Replace with your message.
                val toNumber = "XXXXXX"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("http://api.whatsapp.com/send?phone=$toNumber&text=$text")
                startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
            }*/

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
