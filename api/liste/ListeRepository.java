package com.oguzhan.api.liste;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ListeRepository extends ListCrudRepository<liste , Integer> {
    List<liste> findAllBySahipid(Integer id);
    List<liste> findAllByIsim(String isimi);
}
