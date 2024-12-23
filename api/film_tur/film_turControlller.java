package com.oguzhan.api.film_tur;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/film-tur")
public class film_turControlller {

    private final Film_turRepository film_turRepository;

    public film_turControlller(Film_turRepository filmTurRepository) {
        film_turRepository = filmTurRepository;
    }

    @GetMapping("/all")
    List<film_tur> findAll() {
        return film_turRepository.findAll();
    }

    @GetMapping("/{tur}")
    List<film_tur> findByTur(@PathVariable("tur") String tur) {
        return film_turRepository.findAllByTur(tur);
    }
    @GetMapping("/film/{filmid}")
    List<film_tur> findByFilm(@PathVariable("filmid") Integer filmid) {
        return film_turRepository.findAllByFilmid(filmid);
    }



}
