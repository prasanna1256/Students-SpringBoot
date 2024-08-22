package net.prasanna.spring.services;

import java.util.List;



import net.prasanna.spring.entity.Student;


public interface StudentService {
	
	
	public List<Student> getAllStudents();
	public Student saveStudent(Student student);
	public Student getStudentById(Long id);
	public Student updateStudent(Student student);
}
