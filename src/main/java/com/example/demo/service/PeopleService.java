package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.People;

public interface PeopleService {
    List<People> getAllPeople();

    void createPeople(People people);
}
