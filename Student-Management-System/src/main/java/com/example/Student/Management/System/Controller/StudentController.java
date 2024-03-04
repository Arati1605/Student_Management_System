package com.example.Student.Management.System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Student.Management.System.Entity.Student;
import com.example.Student.Management.System.Service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService service;

	@PostMapping("/save")
	private Student saveStudent(@RequestBody Student student) {
		return service.createStudent(student);

	}

	@GetMapping("/find/{id}")
	private Student findStudentById(@PathVariable Long id) {
		return service.gerstudentById(id);
	}

	@GetMapping("/findAll")
	private List<Student> findAllStudents() {
		return service.getAllStudents();
	}

	@DeleteMapping("/delete/{id}")
	private String deleteStudent(@PathVariable Long id) {
		service.deleteStudent(id);
		return "Student Deleted Successfully";
	}

	private Student updateStudent(@RequestBody Student student, @PathVariable Long id) {
		return service.updateStudent(student, id);
	}

}
