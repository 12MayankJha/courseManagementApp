package com.springRest.springRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springRest.springRest.entities.Courses;

public interface CourseDao extends JpaRepository<Courses, Long> {
	

}
