package com.example.veritabaniodevapp.service

import com.example.veritabaniodevapp.model.liste
import com.example.veritabaniodevapp.model.listefilm
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface listeApi {

    @GET("all")
    suspend fun tumListeleriAl(): Response<List<liste>>


    @GET("sahip/{sahipid}")
    suspend fun listeleriAlSahip(
        @Path("sahipid") sahipid : Int
    ): Response<List<liste>>


}