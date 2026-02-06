package com.akshay.service;

import com.akshay.dao.StudentRepo;
import com.akshay.rest.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImple  implements IStudentService {

    @Autowired
 private StudentRepo repo;
    @Override
    public Student saveStudent(Student student) {
        //invock logic to store data in database

        repo.save(student); // store the data in the database
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        //invock logic to retrive all the student records from database
        return repo.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }


    @Override
    public void deleteStudentById(Long id) {
        repo.deleteById(id);
    }
}
