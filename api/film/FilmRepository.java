package com.oguzhan.api.film;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface FilmRepository extends ListCrudRepository<film , Integer> {
    List<film> findAllByIsimContains(String isim);
}
