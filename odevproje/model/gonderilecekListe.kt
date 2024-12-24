package com.example.odevproje.model

import com.google.gson.annotations.SerializedName

data class gonderilecekListe(
    @SerializedName("isim") val isim: String,
    @SerializedName("film_sayisi") val film_sayisi: Int,
    @SerializedName("aciklama") val aciklama: String,
    @SerializedName("ortalama_puan") val ortalama_puan: Double,
    @SerializedName("sahipid") val sahipid: Int,
    @SerializedName("olusturulma_tarihi") val olusturulma_tarihi: String
)