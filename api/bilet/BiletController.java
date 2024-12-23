package com.oguzhan.api.bilet;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/biletler")
public class BiletController {

    public final BiletRepository biletRepository;

    public BiletController(BiletRepository biletRepository) {
        this.biletRepository = biletRepository;
    }

    @GetMapping("/sahip/{sahipid}")
    List<bilet> findbysahipid(@PathVariable Integer sahipid) {
        return biletRepository.findAllBySahipid(sahipid);
    }

    @GetMapping("/seans/{seansid}")
    List<bilet> findbyseansid(@PathVariable Integer seansid) {
        return biletRepository.findAllBySeansid(seansid);
    }

    @PostMapping("")
    void save(@RequestBody bilet bilet) {
        biletRepository.save(bilet);
    }


}
