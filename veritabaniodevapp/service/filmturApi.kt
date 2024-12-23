package com.example.veritabaniodevapp.service

import com.example.veritabaniodevapp.model.film_tur
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface filmturApi {

    @GET("{tur}")
    suspend fun filmturCekTureGore(
        @Path("tur") tur : String
    ): List<film_tur>


    @GET("film/{filmid}")
    suspend fun filmTurBul(
        @Path("filmid") filmid: Int
    ): List<film_tur>
}