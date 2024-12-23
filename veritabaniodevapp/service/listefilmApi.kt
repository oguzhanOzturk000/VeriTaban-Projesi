package com.example.veritabaniodevapp.service

import com.example.veritabaniodevapp.model.listefilm
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST
import retrofit2.http.Path

interface listefilmApi {
    @DELETE("{id]")
    suspend fun listedenSilByid(
        @Path("id") id: Int
    )
    @POST("")
    suspend fun listeyeEkle(
        @Body listefilm: listefilm
    )
}