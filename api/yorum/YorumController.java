package com.oguzhan.api.yorum;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/yorumlar")
public class YorumController {

    private final YorumRepository yorumRepository;

    public YorumController(YorumRepository yorumRepository) {
        this.yorumRepository = yorumRepository;
    }

    @GetMapping("/all")
    List<yorum> findAll() {
        return yorumRepository.findAll();
    }

    @GetMapping("/{filmid}")
    List<yorum> findByFilmid(@PathVariable("filmid") Integer filmid) {
        return yorumRepository.findAllByFilmid(filmid);
    }

    //create
    @PostMapping("")
    void save(@RequestBody yorum yorum) {
        yorumRepository.save(yorum);
    }

}
