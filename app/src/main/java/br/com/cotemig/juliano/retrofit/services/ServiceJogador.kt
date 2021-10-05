package br.com.cotemig.juliano.retrofit.services

import br.com.cotemig.juliano.retrofit.models.Jogador
import br.com.cotemig.juliano.retrofit.models.ListaJogador
import retrofit2.Call
import retrofit2.http.GET

interface ServiceJogador {

    @GET("jogador")
    fun obterJogador() : Call<ListaJogador>

    }