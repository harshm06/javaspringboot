package com.example.test.repo;

import com.example.test.model.Student;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student, Integer>
{
    
}
