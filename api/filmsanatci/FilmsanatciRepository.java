package com.oguzhan.api.filmsanatci;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface FilmsanatciRepository extends ListCrudRepository<filmsanatci , Integer> {
    List<filmsanatci> findAllBySanatciid(int sanatciid);
    List<filmsanatci> findAllByFilmid(int filmid);
}
