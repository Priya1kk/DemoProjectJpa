package com.example.demoForJpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoForJpa.Repository.Student_repo;
import com.example.demoForJpa.entity.Student_entity;

@RestController
 
public class Student_controller {
	
	@Autowired
	Student_repo studentrepo;
	
	@PostMapping("/api/students")
	
	public ResponseEntity<Student_entity>saveStudent(@RequestBody Student_entity student) {
		
		 return new ResponseEntity<>(studentrepo.save(student),HttpStatus.CREATED);
	
	}
@GetMapping("/api/students")
	public ResponseEntity<List<Student_entity>> getStudents() {
		return new ResponseEntity<>(studentrepo.findAll(),HttpStatus.OK);
		
	}
@GetMapping("/api/students/{id}")
public ResponseEntity<Student_entity> getStudent(@PathVariable long id) {
	Optional<Student_entity> student= studentrepo.findById(id);
	if(student.isPresent()) {
		return new ResponseEntity<>(student.get(),HttpStatus.OK);
	}
	else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
@PutMapping("/api/students/{id}")
public ResponseEntity<Student_entity> getStudent(@PathVariable long id,@RequestBody Student_entity stud) {
	Optional<Student_entity> student= studentrepo.findById(id);
	if(student.isPresent()) {
		student.get().setStudentName(stud.getStudentName());
		student.get().setStudentEmail(stud.getStudentEmail());
		student.get().setStudentAddress(stud.getStudentAddress());
		return new ResponseEntity<>(studentrepo.save(student.get()),HttpStatus.OK);
	}
	else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
@DeleteMapping("/api/students/{id}")
public ResponseEntity<Void>deleteStudent(@PathVariable long id) {
	Optional<Student_entity> student= studentrepo.findById(id);
	if(student.isPresent()) {
		studentrepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
}
