package com.oguzhan.api.film;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class filmNotFoundException extends RuntimeException{
    public filmNotFoundException(){
        super("Film not found!");
    }
}
