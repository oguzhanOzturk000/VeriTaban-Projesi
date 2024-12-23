package com.example.veritabaniodevapp.service

import com.example.veritabaniodevapp.model.puanlama
import com.google.common.base.Objects
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface puanlamaApi {
    @GET("kullanici/{kullaniciid}")
    suspend fun kullanicIdilepuanlamaAl(
        @Path("kullaniciid") kullaniciid: Int
    ): List<puanlama>

    @GET("film/{filmid}")
    suspend fun filmIdilepuanlamaAl(
        @Path("filmid") filmid: Int
    ): List<puanlama>

    @DELETE("{id}")
    suspend fun puanlamayiSil(
        @Path("id") id :Int
    )

    @PUT("")
    suspend fun puaniDegistir(
        @Body puanlama: Any
    )

    @POST("")
    suspend fun yeniPuanlama(
        @Body puanlama : Any
    )

}