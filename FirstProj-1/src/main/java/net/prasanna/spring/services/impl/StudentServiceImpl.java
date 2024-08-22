package net.prasanna.spring.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.prasanna.spring.entity.Student;
import net.prasanna.spring.repository.StudentRepository;
import net.prasanna.spring.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentRepository;
	

	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


	@Override
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
		
	}


	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}


	@Override
	public Student getStudentById(Long id) {
		
		return studentRepository.findById(id).get();
	}


	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}
}
