package com.oguzhan.api.yorum;

import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

public record yorum(
   @Id
   Integer id,
   Integer filmid,
   Integer sahipid,
   String yorum,
   String tarih
) {}
