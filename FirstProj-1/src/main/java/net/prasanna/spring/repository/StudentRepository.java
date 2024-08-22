package net.prasanna.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.prasanna.spring.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
