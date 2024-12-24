package com.example.odevproje.service

import com.example.odevproje.model.gonderilecekListe
import com.example.odevproje.model.liste
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface listeApi {

    @GET("all")
    suspend fun tumListeleriAl(): Response<List<liste>>

    @GET("id/{id}")
    suspend fun findListById(
        @Path("id") id : Int
    ): liste


    @GET("ara/{isim}")
    suspend fun isimdenListeAra(
        @Path("isim") isim : String
    ): List<liste>


    @DELETE("{id}")
    suspend fun listeyiSil(
        @Path("id") id : Int
    )

    @PUT("{id}")
    suspend fun editList(
        @Body liste: liste,
        @Path("id") id : Int
    )

    @POST("olustur")
    suspend fun makeList(
        @Body liste: gonderilecekListe,
    )

}