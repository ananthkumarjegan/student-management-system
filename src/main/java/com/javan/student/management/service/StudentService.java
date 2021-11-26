package com.javan.student.management.service;

import java.util.List;

import com.javan.student.management.entity.Student;

public interface StudentService {

	List<Student> getAllStudents();

	void saveStudent(Student student);

	Student getStudentById(Long id);

	void deleteById(Long id);
	
	

}
