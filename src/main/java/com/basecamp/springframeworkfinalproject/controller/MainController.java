package com.basecamp.springframeworkfinalproject.controller;

import com.basecamp.springframeworkfinalproject.domain.Person;
import com.basecamp.springframeworkfinalproject.service.PersonService;
import com.basecamp.springframeworkfinalproject.wire.ResultResponse;
import com.basecamp.springframeworkfinalproject.wire.SaveResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;


@RestController
@Validated
@RequiredArgsConstructor
@Api(value = "main Controller" , description = "Basic API Opertaion")
public class MainController {

    private final PersonService personService;

    @ApiOperation(value = "Controller post request to api and save calculate result in db , return uuid")
    @PostMapping("/save/{kindOfMachine}/{state}/{personName}")
    public ResponseEntity<SaveResponse> saveMachineResult(@PathVariable @NotNull String kindOfMachine ,
                                                          @PathVariable @NotNull String state ,
                                                          @PathVariable @NotNull String personName){

        Person person = personService.saveMachineResult( kindOfMachine  , state , personName);

        SaveResponse response = new SaveResponse();
        response.setId(person.getUuid());
        response.setResponse("GET this uuid to see result !");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @ApiOperation(value = "Put UUID from saveMachineResult POST Method in this Get method to see result")
    @GetMapping("/result/{uuid}")
    public ResponseEntity<ResultResponse> getResult(@PathVariable UUID uuid){
        ResultResponse response = new ResultResponse();
        response.setUuid(uuid);
        response.setResult(personService.calculateResponse(uuid));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @ApiOperation(value = "View UUID and Person Name all fastest result")
    @GetMapping("/fastest/result")
    public ResponseEntity<List<Person>> getAllFastestResult(){
        return ResponseEntity.ok(personService.getAllUuidByStateResult("fastest"));
    }

    @ApiOperation(value = "View UUID and Person Name all expensive result")
    @GetMapping("/expensive/result")
    public ResponseEntity<List<Person>> getAllExpensiveResult(){
        return ResponseEntity.ok(personService.getAllUuidByStateResult("expensive"));
    }


    @ApiOperation(value = "Get All person and machine with pagination")
    @GetMapping(value = "/persons",params = { "page", "size" })
    public ResponseEntity<List<Person>> findPaginated(@RequestParam(value = "page" ,defaultValue = "0") @Min(0) int page,
                                   @RequestParam(value = "size" , defaultValue = "5") @Min(5) int size) {

         List<Person> personList = personService.findAllPagination(page , size);
        return ResponseEntity.ok().body(personList);
    }




}
