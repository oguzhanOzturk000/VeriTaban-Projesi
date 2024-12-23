package com.oguzhan.api.sinemasalonu;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/salonlar")
public class SinemasalonuController {

    public final SinemasalonuRepository sinemasalonuRepository;

    public SinemasalonuController(SinemasalonuRepository sinemasalonuRepository) {
        this.sinemasalonuRepository = sinemasalonuRepository;
    }

    @GetMapping("/all")
    List<sinemasalonu> findAll() {
        return sinemasalonuRepository.findAll();
    }

    @GetMapping("/sinema/{sinemaid}")
    List<sinemasalonu> findbysinema(@PathVariable int sinemaid) {
        return sinemasalonuRepository.findAllBySinemaid(sinemaid);
    }

    @GetMapping("/{isim}")
    List<sinemasalonu> findbyisim(@PathVariable String isim) {
        return sinemasalonuRepository.findAllByIsim(isim);
    }

}
