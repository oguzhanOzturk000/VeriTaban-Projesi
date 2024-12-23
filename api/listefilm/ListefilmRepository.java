package com.oguzhan.api.listefilm;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ListefilmRepository extends ListCrudRepository<listefilm, Integer> {
    List<listefilm> findAllByListeid(Integer listeid);
}
