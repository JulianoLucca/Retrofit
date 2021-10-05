package br.com.cotemig.juliano.retrofit.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val URL = "https://mockup .fluo.app/v1/"


    private val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun serviceJogador(): ServiceJogador {
        return retrofit.create(ServiceJogador::class.java)
    }

}