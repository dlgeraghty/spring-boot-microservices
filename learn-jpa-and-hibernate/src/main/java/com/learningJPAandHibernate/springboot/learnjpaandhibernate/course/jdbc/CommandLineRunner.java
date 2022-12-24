package com.learningJPAandHibernate.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner{

	@Autowired
	private CourseJdbcRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.insert(new Course(1, "Learn AWS Now!", "david"));
		repository.insert(new Course(2, "Learn Azure Now!", "david"));
		repository.insert(new Course(3, "Learn DevOps Now!", "david"));
		
		repository.delete(1);
	}

}
