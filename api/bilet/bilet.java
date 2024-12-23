package com.oguzhan.api.bilet;

import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

public record bilet(
        @Id
        Integer id,
        Integer sahipid,
        Integer seansid,
        Integer koltukid,
        String alinma_saati,
        String bilettur
) {}
