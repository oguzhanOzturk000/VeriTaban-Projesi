package com.oguzhan.api.sanatci;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface SanatciRepository extends ListCrudRepository<sanatci, Integer> {
    List<sanatci> findAllBySanatciadContaining(String isim);
    List<sanatci> findAllByMeslek(String meslek);
}
