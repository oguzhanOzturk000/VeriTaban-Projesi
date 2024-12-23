package com.example.veritabaniodevapp.service

import com.example.veritabaniodevapp.model.sanatci
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface sanatciApi {
    @GET("all")
    suspend fun tumSanatcilariAl(): List<sanatci>

    @GET("id/{id}")
    suspend fun sanatciBulId(
        @Path("id") id :Int
    ): sanatci

    @GET("isim/{isim}")
    suspend fun isimdenSanatciBul(
        @Path("isim") isim: String
    ): List<sanatci>

    @GET("meslek/{meslek}")
    suspend fun meslektenSanatciBul(
        @Path("meslek") meslek : String
    ): List<sanatci>
}