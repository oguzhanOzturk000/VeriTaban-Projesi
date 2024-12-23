package com.oguzhan.api.puanlama;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface PuanlamaRepository extends ListCrudRepository<puanlama , Integer> {
    List<puanlama> findAllByKullaniciid(Integer kullaniciid);
    List<puanlama> findAllByFilmid(Integer filmid);
}
