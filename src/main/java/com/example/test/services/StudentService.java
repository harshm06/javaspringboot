package com.example.test.services;

import com.example.test.repo.StudentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.model.*;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService 
{
    @Autowired
    StudentRepo sturepo;

    public List<Student> getAllStudents()
    {
        List<Student> allstu = sturepo.findAll();
        return allstu;
    }

    public Optional<Student> findById(int id)
    {
        return sturepo.findById(id);
    }

    public String addStudent(Student st)
    {
        if (sturepo.existsById(st.getSid()))
            return "Record not Inserted as record already exists";
        else    
            sturepo.save(st);
            return "Record inserted successfully";
    }

    public String updateStudent(Student student)
    {
        if (sturepo.existsById(student.getSid()))
        {
            sturepo.deleteById(student.getSid());
            sturepo.save(student);
            return "Record Updated Successfully";
        }

        else    
            return "Record not updated as record does not exists";
    }

    public String deleteStudent(int id)
    {
        if (sturepo.existsById(id))
        {
            // Student st=sturepo.getById(id);
            sturepo.deleteById(id);
            return "Record Deleted successfully";
        }
        else
            return "Record not deleted as record does not exits";

    }
    public List<Student> findDesired(String address, String name)
    {
        return (List<Student>) sturepo.findAllByAddressAndName(address, name);
    }
}
