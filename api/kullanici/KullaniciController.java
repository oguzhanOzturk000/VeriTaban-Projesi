package com.oguzhan.api.kullanici;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kullanici")
public class KullaniciController {

    public final KullaniciRepository kullaniciRepository;

    public KullaniciController(KullaniciRepository kullaniciRepository) {
        this.kullaniciRepository = kullaniciRepository;
    }

    @GetMapping("")
    List<kullanici> getKullanici() {
        return kullaniciRepository.findAll();
    }

    @GetMapping("/id/{id}")
    kullanici getKullanici(@PathVariable int id) {
        return kullaniciRepository.findById(id).get();
    }

    @GetMapping("/mail/{mail}")
    kullanici maildenBul(@PathVariable String mail) {
        return kullaniciRepository.findBymail(mail);
    }

    @PostMapping("")
    void create (@RequestBody kullanici Kullanici) {
        kullaniciRepository.save(Kullanici);
    }

    @PutMapping("")
    void update (@RequestBody kullanici Kullanici) {
        kullaniciRepository.save(Kullanici);
    }
}
