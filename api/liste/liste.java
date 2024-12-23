package com.oguzhan.api.liste;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.data.annotation.Id;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public record liste(
        @Id
        Integer id,
        String isim,
        Integer film_sayisi,
        String aciklama,
        Float ortalama_puan,
        Integer sahipid,
        String olusturulma_tarihi

) {}
