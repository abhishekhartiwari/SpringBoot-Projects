package com.abhi;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.abhi.dao.StudentRepository;
import com.abhi.entities.Student;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(SpringJpaApplication.class, args);
		StudentRepository repo = context.getBean(StudentRepository.class);
		Student user = new Student();
		
		//user.setId(1);
//		user.setName("Prashant");
//		user.setAddress("Goa");
//		//predefined method
//		Student user1 = repo.save(user);	
//		System.out.println("user1 "+user1);
		
		System.out.println("======================================");
		//derived method/custom finder method.....find student by name
		List<Student> student = repo.findStudentByName("Pinky");
		student.forEach(e-> System.out.println(e));
		
		System.out.println("======================================");
		
		//using Java Persistent Query Language
		Student stu = (Student) repo.findUserById(3);
		System.out.println("student---"+ stu);
		
		System.out.println("======================================");
		
		//Using native query
		List<Student> list = repo.findAllStudent();
		student.forEach(e -> System.out.println("\n"+list));
		
		
	}

}
