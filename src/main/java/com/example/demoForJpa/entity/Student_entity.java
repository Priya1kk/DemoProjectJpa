package com.example.demoForJpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student_entity {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	private String StudentName;
	private String StudentEmail;
	private String StudentAddress;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		this.StudentName = studentName;
	}
	public String getStudentEmail() {
		return StudentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.StudentEmail = studentEmail;
	}
	public String getStudentAddress() {
		return StudentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.StudentAddress = studentAddress;
	}
	public Student_entity(long id, String studentName, String studentEmail, String studentAddress) {
		super();
		this.id = id;
		StudentName = studentName;
		StudentEmail = studentEmail;
		StudentAddress = studentAddress;
	}
	public Student_entity() {
		super();
		
	}
	@Override
	public String toString() {
		return "Student_entity [id=" + id + ", StudentName=" + StudentName + ", StudentEmail=" + StudentEmail
				+ ", StudentAddress=" + StudentAddress + "]";
	}
	
	}
	