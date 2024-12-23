package com.oguzhan.api.listefilm;

import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

public record listefilm(
        @Id
        Integer id,
        Integer listeid,
        Integer filmid,
        String eklenme_tarihi
) {}
