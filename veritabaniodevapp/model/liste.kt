package com.example.veritabaniodevapp.model


data class liste(
    var isim : String ,
    var film_sayisi : Int,
    var aciklama : String ,
    var ortalama_puan : Float ,
    val sahipid : Integer ,
    val olusturulma_tarihi : String,
    val id : Int
)