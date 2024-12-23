package com.oguzhan.api.puanlama;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/puanlama")
public class PuanlamaController {

    public final PuanlamaRepository puanlamaRepository;

    public PuanlamaController(PuanlamaRepository puanlamaRepository) {
        this.puanlamaRepository = puanlamaRepository;
    }

    @GetMapping("")
    List<puanlama> getPuanlama() {
        return puanlamaRepository.findAll();
    }

    @GetMapping("/kullanici/{kullaniciid}")
    List<puanlama> kullaniciPuanlama(@PathVariable Integer kullaniciid) {
        return puanlamaRepository.findAllByKullaniciid(kullaniciid);
    }

    @GetMapping("/film/{filmid}")
    List<puanlama> puanlamaByfilmid(@PathVariable Integer filmid) {
        return puanlamaRepository.findAllByFilmid(filmid);
    }

    @PostMapping("")
    void save(@RequestBody puanlama puanlama) {
        puanlamaRepository.save(puanlama);
    }
    @PutMapping("")
    void update(@RequestBody puanlama puanlama) {
        puanlamaRepository.save(puanlama);
    }
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        puanlamaRepository.deleteById(id);
    }
}
