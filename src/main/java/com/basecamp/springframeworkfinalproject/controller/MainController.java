package com.basecamp.springframeworkfinalproject.controller;

import com.basecamp.springframeworkfinalproject.domain.Person;
import com.basecamp.springframeworkfinalproject.service.PersonService;
import com.basecamp.springframeworkfinalproject.wire.ResultResponse;
import com.basecamp.springframeworkfinalproject.wire.SaveResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
public class MainController {

    private final PersonService personService;

    @PostMapping("/{kindOfMachine}/{state}/{personName}")
    public ResponseEntity<SaveResponse> saveMachineResult(@PathVariable String kindOfMachine ,
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

    @GetMapping("/fastest/result")
    public ResponseEntity<List<Person>> getAllFastestResult(){
        return ResponseEntity.ok(personService.getAllUuidByStateResult("fastest"));
    }


    @GetMapping("/expensive/result")
    public ResponseEntity<List<Person>> getAllExpensiveResult(){
        return ResponseEntity.ok(personService.getAllUuidByStateResult("expensive"));
    }

    @GetMapping(params = { "page", "size" })
    public ResponseEntity<List<Person>> findPaginated(@RequestParam(value = "page" ,defaultValue = "0") int page,
                                   @RequestParam(value = "size" , defaultValue = "5") int size) {

         List<Person> personList = personService.findAllPagination(page , size);

        return ResponseEntity.ok().body(personList);
    }




}
