package com.ugurhmz.controller;


import com.ugurhmz.dto.PersonDTO;
import com.ugurhmz.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person/")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;


    // SAVE PERSON
    @PostMapping("/save")
    public ResponseEntity<PersonDTO> postSavePerson(@RequestBody PersonDTO personDTO) {
        return ResponseEntity.ok(personService.save(personDTO));
    }


    // GET ALL
    @GetMapping("/persons-list")
    public ResponseEntity<List<PersonDTO>> getPersonsList(){
        return ResponseEntity.ok(personService.findAll());
    }


}











