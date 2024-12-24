package com.example.odevproje.model

import com.google.gson.annotations.SerializedName

data class liste(
    val id: Int?,
    val isim: String,
    val film_sayisi: Int,
    val aciklama: String,
    val ortalama_puan: Double,
    val sahipid: Int,
    val olusturulma_tarihi: String
)