package com.example.odevproje.service

import com.example.odevproje.model.listefilm
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
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
    @GET("{listeid}")
    suspend fun listedeiFilmleriBul(
        @Path("listeid") listeid : Int
    ): List<listefilm>
}