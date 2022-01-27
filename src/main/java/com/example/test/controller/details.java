package com.example.test.controller;
import com.example.test.services.MyUserService;
import com.example.test.services.StudentService;
 import com.example.test.util.JwtUtil;

import java.util.Optional;
import java.util.List;

import com.example.test.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
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
    StudentService stuService;

    @Autowired
    MyUserService userDetailsService;

     @Autowired
     JwtUtil jwtutil;

    @Autowired
	private AuthenticationManager authenticationManager;

    @GetMapping("/getdata")
    public Iterable<Student> getdata()
    {
        return stuService.getAllStudents();
    }

    @GetMapping("/findbyid")
    public Optional<Student> getstu(@RequestParam int id)
    {
        return stuService.findById(id);

    }

    @PostMapping("/addstudent")
    public String addStudent(@RequestBody Student stu)
    {
        return stuService.addStudent(stu);
    }

    @PutMapping("/updatestudent")
    public String updateStudent(@RequestBody Student stu)
    {
        return stuService.updateStudent(stu);
        
    }

    @DeleteMapping("/deletestudent")
    public String deleteStudent(@RequestBody int sid)
    {
        return stuService.deleteStudent(sid);
    }

    @GetMapping("/getstubyaddress")
    public List<Student> getstubyaddress(@RequestParam String city, String name)
    {
        return stuService.findDesired(city, name);
    }

    @PostMapping("/authenticate")
    public String createAuthenticationToken(@RequestBody AuthInput authenticationRequest) throws Exception 
    {
        try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			 throw new Exception("Incorrect username or password", e);
//            return "Wrong Credentials";
		}

         final UserDetails userDetails = userDetailsService
		 		.loadUserByUsername(authenticationRequest.getUsername());

		 final String jwt = jwtutil.generateToken(userDetails);
		 return "JWT Token: " + jwt;

//        return "Successfully logged in";

    }
}


