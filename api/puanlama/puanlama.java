package com.oguzhan.api.puanlama;

import org.springframework.data.annotation.Id;
import java.sql.Timestamp;

public record puanlama(
        @Id
        Integer id,
        Integer filmid,
        Integer kullaniciid,
        Integer puan,
        String puanlamatarih
) {}
