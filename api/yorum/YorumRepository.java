package com.oguzhan.api.yorum;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface YorumRepository extends ListCrudRepository<yorum , Integer> {
    List<yorum> findAllByFilmid(Integer filmid);
}
