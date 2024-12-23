package com.example.veritabaniodevapp.service

import com.example.veritabaniodevapp.model.filmsanatci
import com.example.veritabaniodevapp.model.sanatci
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface filmsanatciApi {

    @GET("filmid/{filmid}")
    suspend fun filmdekiSanatcileriAl(
        @Path("filmid") filmid: Int
    ): List<filmsanatci>

    @GET("sanatciid/{sanatciid}")
    suspend fun filmlerSanatciId(
        @Path("sanatciid") sanatciid : Int
    ):List<filmsanatci>
}