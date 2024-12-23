package com.example.veritabaniodevapp.service

import com.example.veritabaniodevapp.model.film
import com.example.veritabaniodevapp.model.film_tur
import com.example.veritabaniodevapp.model.filmsanatci
import com.example.veritabaniodevapp.model.kullanici
import com.example.veritabaniodevapp.model.liste
import com.example.veritabaniodevapp.model.listefilm
import com.example.veritabaniodevapp.model.puanlama
import com.example.veritabaniodevapp.model.sanatci
import com.example.veritabaniodevapp.model.yorum
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface filmApi {

    @GET("all")
    suspend fun getAllFilms() : List<film>

    @GET("isim/{isim}")
    suspend fun getFilmsByisim(
        @Path("isim") isim : String
    ) : List<film>

    @GET("id/{id}")
    suspend fun getFilmById(
        @Path("id") id:Int
    ) : film

    @PUT("{id}")
    suspend fun updateFilm(
        @Path("id") id :Int,
        @Body film: film
    ): film

}