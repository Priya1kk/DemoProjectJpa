package com.example.demoForJpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoForJpa.entity.Student_entity;

public interface Student_repo  extends JpaRepository<Student_entity,Long>{
	

}
