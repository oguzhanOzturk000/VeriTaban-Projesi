package com.example.odevproje.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object apiServis {

    val okHttpClient = OkHttpClient.Builder().build()

    val listelerApi : listeApi by lazy{
        Retrofit.Builder()
            .baseUrl("http://192.168.1.2:8080/api/lists/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(listeApi::class.java)
    }

    val listefilmsApi : listefilmApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.1.2:8080/api/listefilm/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(listefilmApi::class.java)
    }

    val filmsApi : filmApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.1.2:8080/api/films/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(filmApi::class.java)
    }

}