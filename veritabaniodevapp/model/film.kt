package com.example.veritabaniodevapp.model

import com.google.gson.annotations.SerializedName


data class film (
    val id: Int,
    val isim: String,
    val uzunluk: Int,
    val konu: String,
    val degerlendirme_sayisi: Int,
    val ortalama_puan: Double,
    val poster_uri: String
)