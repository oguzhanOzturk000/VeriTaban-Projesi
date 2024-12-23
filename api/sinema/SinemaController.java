package com.oguzhan.api.sinema;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sinemalar")
public class SinemaController {

    public final SinemaRepository sinemaRepository;

    public SinemaController(SinemaRepository sinemaRepository) {
        this.sinemaRepository = sinemaRepository;
    }

    @GetMapping("/all")
    List<sinema> findAll() {
        return sinemaRepository.findAll();
    }

    @GetMapping("/id/{id}")
    sinema findById(@PathVariable int id) {
        return sinemaRepository.findById(id).get();
    }

    @GetMapping("/{sehirid}")
    List<sinema> findBySehir(@PathVariable Integer sehirid) {
        return sinemaRepository.findAllBySehirid(sehirid);
    }

}
