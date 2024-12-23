package com.oguzhan.api.koltuk;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/koltuklar")
public class KoltukController {

    public final KoltukRepository koltukRepository;

    public KoltukController(KoltukRepository koltukRepository) {
        this.koltukRepository = koltukRepository;
    }

    @GetMapping("/salon/{salonid}")
    List<koltuk> salondanBul (@PathVariable int salonid) {
        return koltukRepository.findAllBySalonid(salonid);
    }


}
