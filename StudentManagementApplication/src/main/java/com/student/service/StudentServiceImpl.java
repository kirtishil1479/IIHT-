package com.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.respository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentServiceI{
	
	@Autowired
	public StudentRepository repo;

	@Override
	public Integer saveStudent(Student student) {
		Student save = this.repo.save(student);
		return save.getId();
	}

}
