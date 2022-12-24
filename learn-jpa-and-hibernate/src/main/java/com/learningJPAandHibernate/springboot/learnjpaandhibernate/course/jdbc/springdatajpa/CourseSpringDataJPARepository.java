package com.learningJPAandHibernate.springboot.learnjpaandhibernate.course.jdbc.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learningJPAandHibernate.springboot.learnjpaandhibernate.course.jdbc.Course;

public interface CourseSpringDataJPARepository extends JpaRepository<Course, Long>{

	
}
