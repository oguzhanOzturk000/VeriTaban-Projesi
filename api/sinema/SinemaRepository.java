package com.oguzhan.api.sinema;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface SinemaRepository extends ListCrudRepository<sinema , Integer> {
    List<sinema> findAllBySehirid(Integer sehirid);
}
