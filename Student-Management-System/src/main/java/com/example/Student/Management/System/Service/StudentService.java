package com.example.Student.Management.System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Student.Management.System.Entity.Student;
import com.example.Student.Management.System.Repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository repository;

	public Student createStudent(Student student) {
		return repository.save(student);
	}

	public Student gerstudentById(Long id) {
		return repository.findById(id).get();
	}

	public List<Student> getAllStudents() {
		return repository.findAll();
	}

public void deleteStudent(Long id) {
	repository.deleteById(id);
}


public Student updateStudent(Student correctStudent,Long id) {
	Student student=repository.findById(id).get();

	if(student.getName() !=null) {
		student.setName(correctStudent.getName());
	}
	if(student.getAddress()!=null) {
		student.setAddress(correctStudent.getAddress());
	}
	return repository.save(student);
	}
}
