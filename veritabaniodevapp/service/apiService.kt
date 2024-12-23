package com.example.veritabaniodevapp.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object apiService {



    val filmsApi : filmApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.1.2:8080/api/films/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(filmApi::class.java)
    }
    val kullanicilarApi : kullaniciApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://192.168.1.2:8080/api/kullanici/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(kullaniciApi::class.java)
    }
    val puanlamalarApi : puanlamaApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.1.2:8080/api/puanlama/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(puanlamaApi::class.java)
    }

    val filmsanatcilarApi : filmsanatciApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.1.2:8080/api/filmsanatci/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(filmsanatciApi::class.java)
    }
    val listelerApi : listeApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.1.2:8080/api/lists/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(listeApi::class.java)
    }
    val listefilmsApi : listefilmApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.1.2:8080/api/listefilm/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(listefilmApi::class.java)
    }
    val filmturuApi : filmturApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.1.2:8080/api/film-tur/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(filmturApi::class.java)
    }
    val yorumlarApi : yorumApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.1.2:8080/api/yorumlar/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(yorumApi::class.java)
    }
    val sanatcilarApi : sanatciApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.1.2:8080/api/artist/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(sanatciApi::class.java)
    }
    val seanslarApi : seansApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.1.2:8080/api/seanslar/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(seansApi::class.java)
    }
    val sehirlerApi : sehirApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.1.2:8080/api/sehirler/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(sehirApi::class.java)
    }
    val sinemalarApi : sinemaApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.1.2:8080/api/sinemalar/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(sinemaApi::class.java)
    }
    val sinemasalonlariApi : sinemasalonuApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.1.2:8080/api/salonlar/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(sinemasalonuApi::class.java)
    }
    val biletlerApi : biletApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.1.2:8080/api/biletler/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(biletApi::class.java)
    }
    val koltuklarApi : koltukApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.1.2:8080/api/koltuklar/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(koltukApi::class.java)
    }
}