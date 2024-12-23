package com.oguzhan.api.bilet;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface BiletRepository extends ListCrudRepository<bilet , Integer> {
    List<bilet> findAllBySahipid(Integer sahipid);

    List<bilet> findAllBySeansid(Integer seansid);
}
