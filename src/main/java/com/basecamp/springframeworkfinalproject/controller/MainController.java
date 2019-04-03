package com.basecamp.springframeworkfinalproject.controller;

import com.basecamp.springframeworkfinalproject.domain.Person;
import com.basecamp.springframeworkfinalproject.service.PersonService;
import com.basecamp.springframeworkfinalproject.wire.ResultResponse;
import com.basecamp.springframeworkfinalproject.wire.SaveResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@RequiredArgsConstructor
public class MainController {

    private final PersonService personService;

    @PostMapping("/{kindOfMachine}/{state}/{personName}")
    public ResponseEntity<SaveResponse> saveMachinelResult(@PathVariable String kindOfMachine ,
                                                           @PathVariable String state ,
                                                           @PathVariable String personName){

        Person person = personService.saveMachineResult( kindOfMachine  , state , personName);

        SaveResponse response = new SaveResponse();
        response.setId(person.getUuid());
        response.setResponse("GET this uuid to see result !");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping("/{uuid}")
    public ResponseEntity<ResultResponse> getResult(@PathVariable UUID uuid){
        ResultResponse response = new ResultResponse();
        response.setUuid(uuid);
        response.setResult(personService.calculateResponse(uuid));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
