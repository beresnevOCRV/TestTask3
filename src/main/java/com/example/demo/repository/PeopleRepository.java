package com.example.demo.repository;

import java.util.UUID;

import com.example.demo.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, UUID> {

}
