package com.oguzhan.api.seans;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/seanslar")
public class SeansController {

    public final SeansRepository seansRepository;

    public SeansController(SeansRepository seansRepository) {
        this.seansRepository = seansRepository;
    }

    @GetMapping("/salon/{salonid}")
    List<seans> findbysalon(@PathVariable int salonid) {
        return seansRepository.findAllBySalonid(salonid);
    }

}
