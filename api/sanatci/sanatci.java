package com.oguzhan.api.sanatci;

import org.springframework.data.annotation.Id;

public record sanatci(
        @Id
        Integer id,
        String sanatciad,
        Integer filmsayisi,
        String meslek,
        String hakkinda
) {}
