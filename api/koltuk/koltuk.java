package com.oguzhan.api.koltuk;

import org.springframework.data.annotation.Id;


public record koltuk(
        @Id
        Integer id,
        Integer salonid,
        String koltukno
){}
