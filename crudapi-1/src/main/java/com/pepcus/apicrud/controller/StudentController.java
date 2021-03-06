package com.pepcus.apicrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pepcus.apicrud.model.Student;
import com.pepcus.apicrud.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
	}

	@GetMapping()
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@GetMapping("{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") long studentId) {
		return new ResponseEntity<Student>(studentService.getStudentById(studentId), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") long id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("student deleted", HttpStatus.OK);
	}
	//
	@GetMapping("/sorts/{field}")
	public List<Student>sortStudent(@PathVariable String field) {
		List<Student> allStudent= studentService.sortStudent(field);
		
		return allStudent;
	}
	// pagination
	@GetMapping("/pagination/{offset}/{pageSize}")
	public Page<Student>sortStudent(@PathVariable Integer offset,Integer pageSize) {
		Page<Student> students= studentService.findStudentByPagination(offset,pageSize);
		
		return students;
	}

}
