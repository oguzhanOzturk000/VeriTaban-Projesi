package com.oguzhan.api.seans;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface SeansRepository extends ListCrudRepository<seans, Integer> {
    List<seans> findAllBySalonid(int salonid);
}
