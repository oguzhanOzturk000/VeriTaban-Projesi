package com.oguzhan.api.sehir;

import org.springframework.data.annotation.Id;

public record sehir(
        @Id
        Integer id,
        String sehirisim,
        Integer sinemasayisi
) {
}
