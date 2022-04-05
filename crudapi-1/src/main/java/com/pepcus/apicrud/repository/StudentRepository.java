package com.pepcus.apicrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pepcus.apicrud.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
