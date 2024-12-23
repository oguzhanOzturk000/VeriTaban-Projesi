package com.example.veritabaniodevapp.model

import java.sql.Timestamp

data class yorum(
    var id : Int,
    var filmid: Int,
    var sahipid: Int,
    var yorum : String,
    var tarih : String
){
}