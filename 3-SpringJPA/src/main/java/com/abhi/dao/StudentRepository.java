package com.abhi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.abhi.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{
	
	//custom finder method
	public List<Student> findStudentByName(String name);
	
	//JPQL technique
	@Query("Select s from Student s where s.id =:i")
	public Student findUserById(@Param("i") int id);

	//native query
	@Query(value = "Select * from Student", nativeQuery = true)
	public List<Student> findAllStudent();
}
