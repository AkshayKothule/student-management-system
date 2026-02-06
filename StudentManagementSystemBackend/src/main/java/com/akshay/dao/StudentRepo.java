package com.akshay.dao;


import com.akshay.rest.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student , Long> {


}

