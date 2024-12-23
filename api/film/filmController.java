package com.oguzhan.api.film;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/films")
public class filmController {


    private final FilmRepository filmRepository ;

    public filmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GetMapping("/all")
    List<film> findAll(){
        return filmRepository.findAll();
    }

    @GetMapping("/isim/{isim}")
    List<film> findFilmByIsim(@PathVariable String isim){
        return filmRepository.findAllByIsimContains(isim);
    }


    @GetMapping("/id/{id}")
    film findById(@PathVariable Integer id){
        Optional<film> Film = filmRepository.findById(id);
        if(Film.isEmpty()){
            throw new filmNotFoundException();
        }
        return Film.get();
    }

    //create

    @PostMapping("")
    void save(@RequestBody film Film){
        filmRepository.save(Film);
    }

    // Put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@RequestBody film Film, @PathVariable Integer id){
        filmRepository.save(Film);
    }


    // delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        filmRepository.deleteById(id);
    }

}
