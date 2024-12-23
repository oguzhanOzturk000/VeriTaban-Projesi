package com.oguzhan.api.kullanici;

import org.springframework.data.annotation.Id;

public record kullanici(
        @Id
        Integer id,
        String kullaniciad,
        String mail,
        Integer izlenenfilmsayi,
        Integer listesayi
){}
