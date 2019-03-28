package com.basecamp.springframeworkfinalproject.controller;

import com.basecamp.springframeworkfinalproject.domain.Person;
import com.basecamp.springframeworkfinalproject.service.SwapiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SwapiController {

    private final SwapiService swapiService;

    @PostMapping("/{person}")
    public ResponseEntity<?> postStarshiptoDB(@PathVariable String person){

        Person person1 = swapiService.getFromAPI(person);

        return ResponseEntity.ok().body(person1);
    }

}
