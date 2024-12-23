package com.oguzhan.api.liste;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class listeNotFoundException extends RuntimeException{
    public listeNotFoundException(){
        super("List not found!");
    }
}
