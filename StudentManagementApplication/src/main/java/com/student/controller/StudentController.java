package com.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.service.StudentServiceI;

@RestController
public class StudentController {
	
	@Autowired
	private StudentServiceI service;
	
	@PostMapping("/addStudent")
	public Integer createStudent(@RequestBody Student student) {
		Integer saveStudent = this.service.saveStudent(student);
		System.out.println(saveStudent);
		return saveStudent;
		
	}
	
	
	@GetMapping("/getStudentById/{id}")
	public Optional<Student> FindById(@PathVariable Integer id){
		Optional<Student> studentById = this.service.getStudentById(id);
		return studentById;
	}
	
	@GetMapping("/getAllStudent")
	public List<Student> getAllStudenData(){
		return this.service.getAllStudent();
	}
	
	

}
