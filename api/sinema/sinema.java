package com.oguzhan.api.sinema;

import org.springframework.data.annotation.Id;

public record sinema(
        @Id
        Integer id,
        String isim,
        Integer sehirid,
        Integer salonsayisi,
        String adres
) {}