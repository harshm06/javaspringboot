package com.example.test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import com.example.test.model.AuthInput;
import com.example.test.repo.AuthRepo;

@Service
public class MyUserService implements UserDetailsService
{
    @Autowired
    AuthRepo authrepo;

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException
    {
        AuthInput user= authrepo.findAllByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("Username does not exits");
        return new User (user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}