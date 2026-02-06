package com.akshay.rest;

import com.akshay.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Provider;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentRestController {
    @Autowired
    private IStudentService service;
    @PostMapping("/Student") // create new request
    public Student registerStudent(@RequestBody Student student)  // convert json data to java format
    {
        System.out.println("Student Data :"+student);
        Student st=service.saveStudent(student);

        return st;

    }

    @GetMapping("/Students")
    public List<Student> getAllStudents()
    {
        //invock service method resposible to retrive all records of students
        List<Student> list= service.getAllStudents();
        return list;

    }

    @GetMapping("/Student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        //invock service method resposible to retrive student data based on id
        Student stu=service.getStudentById(id);
//        return stu;
//        return new ResponseEntity<Student>(stu , HttpStatus.OK).getBody();

        return ResponseEntity.ok(stu);


    }
  @DeleteMapping("/Student/{id}")
    public ResponseEntity<Student>  deleteStudentById(@PathVariable Long id){
      //invock service method resposible to retrive student data based on id
//      return new ResponseEntity<>(new Student , HttpStatus.OK);
      service.deleteStudentById(id);
      return ResponseEntity.noContent().build();

  }
}
