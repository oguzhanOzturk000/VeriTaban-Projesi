package com.oguzhan.api.seans;

import org.springframework.data.annotation.Id;

public record seans(
        @Id
        Integer id,
        Integer salonid,
        Integer filmid,
        String saat,
        String tarih
){}
