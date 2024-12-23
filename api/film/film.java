package com.oguzhan.api.film;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public record film (
    @Id
    Integer id,
    String isim,
    Integer uzunluk,
    String konu,
    Integer degerlendirme_sayisi,
    Float ortalama_puan,
    String poster_uri
){}