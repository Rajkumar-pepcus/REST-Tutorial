package com.pepcus.apicrud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pepcus.apicrud.exception.ResourceNoteFoundException;
import com.pepcus.apicrud.model.Student;
import com.pepcus.apicrud.repository.StudentRepository;
import com.pepcus.apicrud.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
    private StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	
	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}
	
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}
	
	@Override
	public Student getStudentById(long id) {
		Optional<Student> student=studentRepository.findById(id);
		if(student.isPresent()) {
		return student.get();
	}
		else {
			throw new ResourceNoteFoundException("student","id",id);
		}
		
	}
	
	@Override
	public Student updateStudent(Student student, long id) {
		Student existingStudent= studentRepository.findById(id).orElseThrow(
				()-> new ResourceNoteFoundException("Student","Id",id));
		existingStudent.setName(student.getName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setPhoneno(student.getPhoneno());
		existingStudent.setAddress(student.getAddress());
		studentRepository.save(existingStudent);
		return existingStudent;
	}
	
	@Override
	public void deleteStudent(long id) {
		studentRepository.findById(id).orElseThrow(()->
				new ResourceNoteFoundException("Student","Id",id));
		studentRepository.deleteById(id);
	}
	
}
