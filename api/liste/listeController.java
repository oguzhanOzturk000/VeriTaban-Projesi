package com.oguzhan.api.liste;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lists")
public class listeController {

    private final ListeRepository listeRepository ;

    public listeController(ListeRepository listeRepository) {
        this.listeRepository = listeRepository;
    }

    @GetMapping("/all")
    List<liste> findAll(){
        return listeRepository.findAll();
    }

    @GetMapping("/ara/{isim}")
    List<liste> findAllByisim(
        @PathVariable String isim
    ){
        return listeRepository.findAllByIsim(isim);
    }


    @GetMapping("/{id}")
    liste findById(@PathVariable Integer id){
        Optional<liste> Liste = listeRepository.findById(id);
        if(Liste.isEmpty()){
            throw new listeNotFoundException();
        }
        return Liste.get();
    }

    @GetMapping("/sahip/{sahipid}")
    List<liste> findBySahipId(@PathVariable Integer sahipid){
        return listeRepository.findAllBySahipid(sahipid);
    }

    // Post
    @PostMapping("")
    void save(@RequestBody liste Liste){
        listeRepository.save(Liste);
    }
    // Put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody liste Liste, @PathVariable Integer id){
        listeRepository.save(Liste);
    }

    // Delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        listeRepository.deleteById(id);
    }



}
