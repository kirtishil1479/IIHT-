package com.student.service;

import java.util.List;
import java.util.Optional;

import com.student.entity.Student;

public interface StudentServiceI {
	
	Integer saveStudent( Student student);
	Optional<Student>  getStudentById(Integer id);
	List<Student> getAllStudent();

}
