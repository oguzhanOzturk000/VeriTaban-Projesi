package com.oguzhan.api.sinemasalonu;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.sql.In;

public record sinemasalonu(
    @Id
    Integer id,
    Integer sinemaid,
    String isim,
    Integer ogrencifiyat,
    Integer tamfiyat
){
}
