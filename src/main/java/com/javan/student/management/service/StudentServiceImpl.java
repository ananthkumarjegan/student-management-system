package com.javan.student.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javan.student.management.entity.Student;
import com.javan.student.management.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

	@Autowired
	private final StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public void saveStudent(Student student) {
		studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.getById(id);
	}

	@Override
	public void deleteById(Long id) {
		studentRepository.deleteById(id);
	}

}
