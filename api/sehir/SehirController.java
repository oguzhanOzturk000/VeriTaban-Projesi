package com.oguzhan.api.sehir;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sehirler")
public class SehirController {
    private final SehirRepository sehirRepository;

    public SehirController(SehirRepository sehirRepository) {
        this.sehirRepository = sehirRepository;
    }

    @GetMapping("")
    List<sehir> findAll() {
        return sehirRepository.findAll();
    }
}
