package com.example.test.controller;
import com.example.test.repo.StudentRepo;

import java.util.Optional;

import com.example.test.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class details {
    
    @Autowired
    StudentRepo sturepo; 

    @GetMapping("/getdata")
    public Iterable<Student> getdata()
    {
        return sturepo.findAll();
    }

    @GetMapping("/findbyid")
    public Optional<Student> getstu(@RequestParam int id)
    {
        return sturepo.findById(id);

    }

    @PostMapping("/addstudent")
    public Student addStudent(@RequestBody Student stu)
    {
        return sturepo.save(stu);
    }

    @PutMapping("/updatestudent")
    public String updateStudent(@RequestBody Student stu)
    {
        // sturepo.findById(stu.getSid());
        sturepo.deleteById(stu.getSid());
        sturepo.save(stu);
        return "UPDATED";
        
    }

    @DeleteMapping("/deletestudent")
    public String deleteStudent(@RequestBody int sid)
    {
        sturepo.deleteById(sid);
        return "RECORD DELETED";
    }
}


