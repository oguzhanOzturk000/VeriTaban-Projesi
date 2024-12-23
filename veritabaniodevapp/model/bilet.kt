package com.example.veritabaniodevapp.model

import java.io.Serial

data class bilet(
    var id : Int,
    var sahipid: Int,
    var seansid : Int,
    var koltukid : Int,
    var alinma_saati : String,
    var bilettur : String
){
}