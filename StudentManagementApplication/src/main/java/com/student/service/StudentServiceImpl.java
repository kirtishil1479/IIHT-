package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.Exception.ResourceNotFoundexception;
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

	@Override
	public Optional<Student> getStudentById(Integer id) {
		Optional<Student> findById = this.repo.findById(id);
		
		return findById;
	}

	@Override
	public List<Student> getAllStudent() {
		 List<Student> findAll = this.repo.findAll();
		 return findAll;
	}

	@Override
	public void deleteStudentById(Integer id) {
		this.repo.deleteById(id);
		
	}

	@Override
	public Student updateStudent(Student student, Integer id) {
		Student existingStudent = this.repo.findById(id).orElseThrow(()-> new ResourceNotFoundexception("Student", "Id", id));
		existingStudent.setName(student.getName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setStd(student.getStd());
		
		this.repo.save(existingStudent);
		
		return existingStudent;
	}

	

}
