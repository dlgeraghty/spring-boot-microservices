package com.learningJPAandHibernate.springboot.learnjpaandhibernate.course.jdbc.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learningJPAandHibernate.springboot.learnjpaandhibernate.course.jdbc.Course;

public interface CourseSpringDataJPARepository extends JpaRepository<Course, Long>{

	List<Course> findByAuthor(String author);
}
