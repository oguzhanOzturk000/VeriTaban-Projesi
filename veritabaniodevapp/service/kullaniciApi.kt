package com.example.veritabaniodevapp.service

import com.example.veritabaniodevapp.model.kullanici
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface kullaniciApi {
    @GET("id/{id}")
    suspend fun kullaniciAlId(
        @Path("id") id : Int
    )

    @PUT("")
    suspend fun updateKullanici(
        @Body kullanici: kullanici
    )

    @POST("")
    suspend fun kullaniciYarat(
        @Body kullanici: kullanici?
    )
}