package com.oguzhan.api.sanatci;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/artist")
public class sanatciController {

    public final SanatciRepository sanatciRepository;

    public sanatciController(SanatciRepository sanatciRepository) {
        this.sanatciRepository = sanatciRepository;
    }

    @GetMapping("id/{id}")
    sanatci findById(@PathVariable int id) {
        return sanatciRepository.findById(id).get();
    }

    @GetMapping("/all")
    List<sanatci> findAll() {
        return sanatciRepository.findAll();
    }

    @GetMapping("/isim/{isim}")
    List<sanatci> findByIsim(@PathVariable("isim") String isim) {
        return sanatciRepository.findAllBySanatciadContaining(isim);
    }

    @GetMapping("/meslek/{meslek}")
    List<sanatci> findByMeslek(@PathVariable("meslek") String meslek) {
        return sanatciRepository.findAllByMeslek(meslek);
    }



}
