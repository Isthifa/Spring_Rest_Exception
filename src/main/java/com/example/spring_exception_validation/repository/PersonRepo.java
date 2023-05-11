package com.example.spring_exception_validation.repository;

import com.example.spring_exception_validation.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Long> {
}
