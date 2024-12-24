package com.example.odevproje.service

import com.example.odevproje.model.film
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

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