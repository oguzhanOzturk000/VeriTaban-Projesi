package com.oguzhan.api.film_tur;

import org.springframework.data.repository.ListCrudRepository;
import java.util.List;

public interface Film_turRepository extends ListCrudRepository<film_tur , Integer> {
    List<film_tur> findAllByTur(String tur);

    List<film_tur> findAllByFilmid(Integer filmid);
}
