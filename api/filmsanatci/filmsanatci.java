package com.oguzhan.api.filmsanatci;

import org.springframework.data.annotation.Id;

public record filmsanatci(
        @Id
        Integer id,
        Integer filmid,
        Integer sanatciid,
        String meslek
) {}