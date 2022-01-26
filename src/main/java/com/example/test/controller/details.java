package com.example.test.controller;
import com.example.test.repo.StudentRepo;
import com.example.test.services.StudentService;

import java.util.Optional;
import java.util.List;
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
    StudentService stuservice; 

    @GetMapping("/getdata")
    public Iterable<Student> getdata()
    {
        return stuservice.getAllStudents();
    }

    @GetMapping("/findbyid")
    public Optional<Student> getstu(@RequestParam int id)
    {
        return stuservice.findById(id);

    }

    @PostMapping("/addstudent")
    public String addStudent(@RequestBody Student stu)
    {
        return stuservice.addStudent(stu);
    }

    @PutMapping("/updatestudent")
    public String updateStudent(@RequestBody Student stu)
    {
        return stuservice.updateStudent(stu);
        
    }

    @DeleteMapping("/deletestudent")
    public String deleteStudent(@RequestBody int sid)
    {
        return stuservice.deleteStudent(sid);
    }

    @GetMapping("/getstubyaddress")
    public List<Student> getstubyaddress(@RequestParam String city, String name)
    {
        return stuservice.findDesired(city, name);
    }
}


