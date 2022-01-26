package com.example.test.repo;

import com.example.test.model.AuthInput;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthRepo extends JpaRepository<AuthInput, Integer>
{
    public AuthInput findAllByUsername(String username);
}