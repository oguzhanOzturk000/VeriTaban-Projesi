package com.oguzhan.api.listefilm;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listefilm")
public class ListefilmControlller {

    public final ListefilmRepository listefilmRepository;

    public ListefilmControlller(ListefilmRepository listefilmRepository) {
        this.listefilmRepository = listefilmRepository;
    }

    @GetMapping("/all")
    List<listefilm> findAll() {
        return listefilmRepository.findAll();
    }

    @GetMapping("/{listeid}")
    List<listefilm> findByListeid(@PathVariable Integer listeid) {
        return listefilmRepository.findAllByListeid(listeid);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        listefilmRepository.deleteById(id);
    }

    @PostMapping("")
    void create(@RequestBody listefilm listefilm) {
        listefilmRepository.save(listefilm);
    }

}
