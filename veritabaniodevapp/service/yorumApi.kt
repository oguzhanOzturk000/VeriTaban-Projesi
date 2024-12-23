package com.example.veritabaniodevapp.service

import com.example.veritabaniodevapp.model.yorum
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface yorumApi {

    @GET("{filmid}")
    suspend fun yorumlarGetir(
        @Path("filmid") filmid: Int
    ): Response<List<yorum>>

    @POST("")
    suspend fun yorumYap(
        @Body yorum: yorum
    )
}