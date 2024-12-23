package com.oguzhan.api.film_tur;

import org.springframework.data.annotation.Id;

public record film_tur(
        @Id
        Integer id,
        String tur,
        Integer filmid
) {
}
