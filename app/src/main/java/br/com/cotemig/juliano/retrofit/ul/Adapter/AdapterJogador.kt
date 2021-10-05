package br.com.cotemig.juliano.retrofit.ul.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.cotemig.juliano.retrofit.R
import br.com.cotemig.juliano.retrofit.models.Jogador
import coil.load
import coil.transform.RoundedCornersTransformation

class AdapterJogador (var context: Context, var list: List<Jogador>) : BaseAdapter() {

    override fun getCount(): Int {
        return list.size
    }
    override fun getItem(p0: Int): Any {
        return ""
    }
    override fun getItemId(p0: Int): Long {
        return 0
    }
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var view = LayoutInflater.from(context).inflate(R.layout.item_jogador, null)

      var foto = view.findViewById<ImageView>(R.id.foto)
        foto.load(list[p0].foto) {
        transformations(RoundedCornersTransformation(100f))
     }

        var nome = view.findViewById<TextView>(R.id.nome)
        nome.text = list[p0].nome

        var time = view.findViewById<TextView>(R.id.time)
        time.text = list[p0].time

        return view

    }
}