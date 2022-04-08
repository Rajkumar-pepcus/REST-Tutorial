package com.pepcus.apicrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pepcus.apicrud.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
