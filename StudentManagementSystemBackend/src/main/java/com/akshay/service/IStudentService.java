package com.akshay.service;

import com.akshay.rest.Student;

import java.util.List;

public interface IStudentService {

    public  Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public Student getStudentById(Long id);

    public void deleteStudentById(Long id);

}
