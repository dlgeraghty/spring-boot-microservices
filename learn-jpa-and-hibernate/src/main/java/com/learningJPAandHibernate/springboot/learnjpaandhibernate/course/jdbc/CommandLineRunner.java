package com.learningJPAandHibernate.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learningJPAandHibernate.springboot.learnjpaandhibernate.course.jdbc.springdatajpa.CourseSpringDataJPARepository;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner{

	//@Autowired
	//private CourseJdbcRepository repository;
	
	//@Autowired
	//private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJPARepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.save(new Course(1, "Learn AWS Now!", "david"));
		repository.save(new Course(2, "Learn Azure Now!", "david"));
		repository.save(new Course(3, "Learn DevOps Now!", "david"));
		
		repository.deleteById(1l);
		
		System.out.println(repository.findById(2l));
		System.out.println(repository.findById(3l));
		
		System.out.println(repository.findByAuthor("david"));
	}

}
