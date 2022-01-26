package com.example.test.repo;

import com.example.test.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>
{
    public Iterable<Student> findAllByAddressAndName(String city, String name);
}
