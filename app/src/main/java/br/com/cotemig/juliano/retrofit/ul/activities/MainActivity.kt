package br.com.cotemig.juliano.retrofit.ul.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import br.com.cotemig.juliano.retrofit.R
import br.com.cotemig.juliano.retrofit.models.Jogador
import br.com.cotemig.juliano.retrofit.models.ListaJogador
import br.com.cotemig.juliano.retrofit.services.RetrofitInitializer
import br.com.cotemig.juliano.retrofit.ul.Adapter.AdapterJogador
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        obterJogador()
    }
    fun obterJogador(){
        val s = RetrofitInitializer().serviceJogador()
        val call =  s.obterJogador()

        call.enqueue(object : retrofit2.Callback<ListaJogador>{
            override fun onResponse(call: Call<ListaJogador>, response: Response<ListaJogador>) {

                if(response.code() == 200) {

                if (response.code()!=null) {
                     mostrarjogador(response.body()!!.lista)
                    }
            }
        }
            override fun onFailure(call: Call<ListaJogador>, t: Throwable) {

                Toast.makeText(this@MainActivity, "DEU MUITO RUIM!!!", Toast.LENGTH_SHORT).show()
            }
        })
    }
    fun mostrarjogador(list: List<Jogador>){
        var listJogador = findViewById<ListView>(R.id.listJogador)
        listJogador.adapter = AdapterJogador(this, list)
    }

}