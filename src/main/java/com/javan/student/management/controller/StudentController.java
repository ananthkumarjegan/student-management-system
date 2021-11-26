package com.javan.student.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javan.student.management.entity.Student;
import com.javan.student.management.service.StudentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("student")
@RequiredArgsConstructor
public class StudentController {

	@Autowired
	private final StudentService studentService;

	@GetMapping
	public String getAllStudents(Model model) {
		model.addAttribute("studentList", studentService.getAllStudents());
		return "students";
	}

	@GetMapping("create")
	public String createStudentForm(Model model) {
		model.addAttribute("student", new Student());
		return "create-student";
	}

	@PostMapping("create-student")
	public String createStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/student";
	}

	@GetMapping("edit/{id}")
	public String editStudentForm(@PathVariable(name = "id") Long id, Model model) {
		Student existingStudent = studentService.getStudentById(id);
		model.addAttribute("student", existingStudent);
		model.addAttribute("isEdit", true);
		return "create-student";
	}
	
	@PostMapping("edit_student/{id}")
	public String editStudent(@PathVariable(name = "id") Long id,@ModelAttribute("student") Student student) {
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		studentService.saveStudent(existingStudent);
		return "redirect:/student";
	}

	@GetMapping("delete/{id}")
	public String deleteStudent(@PathVariable(name = "id") Long id) {
		studentService.deleteById(id);
		return "redirect:/student";
	}

}
