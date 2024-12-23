package com.oguzhan.api.filmsanatci;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/filmsanatci")
public class FilmsanatciController {

    private final FilmsanatciRepository filmsanatciRepository;

    public FilmsanatciController(FilmsanatciRepository filmsanatciRepository) {
        this.filmsanatciRepository = filmsanatciRepository;
    }

    @GetMapping("/all")
    List<filmsanatci> findAll() {
        return filmsanatciRepository.findAll();
    }

    @GetMapping("/sanatciid/{sanatciid}")
    List<filmsanatci> findAllBySanatciid(@PathVariable Integer sanatciid) {
        return filmsanatciRepository.findAllBySanatciid(sanatciid);
    }

    @GetMapping("/filmid/{filmid}")
    List<filmsanatci> findAllByFilmid(@PathVariable Integer filmid) {
        return filmsanatciRepository.findAllByFilmid(filmid);
    }


}
