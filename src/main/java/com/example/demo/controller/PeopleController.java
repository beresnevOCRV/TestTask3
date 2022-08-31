package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.People;
import com.example.demo.repository.PeopleRepository;
import com.example.demo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleController(PeopleService peopleService,
                            PeopleRepository peopleRepository) {
        this.peopleService = peopleService;
        this.peopleRepository = peopleRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<People>> getAllPeople() {
        return new ResponseEntity<>(peopleService.getAllPeople(), HttpStatus.OK);
    }

    @GetMapping("/create")
    public ResponseEntity<People> createPeople(@RequestParam String name) {
        People people = new People();
        people.setName(name);
        peopleRepository.save(people);
        return new ResponseEntity<>(people, HttpStatus.OK);

    }
}
