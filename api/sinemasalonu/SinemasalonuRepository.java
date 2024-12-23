package com.oguzhan.api.sinemasalonu;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface SinemasalonuRepository extends ListCrudRepository<sinemasalonu , Integer> {
    List<sinemasalonu> findAllBySinemaid(Integer sinemaid);

    List<sinemasalonu> findAllByIsim(String isim);

}
