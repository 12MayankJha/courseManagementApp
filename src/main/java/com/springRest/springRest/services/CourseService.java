package com.springRest.springRest.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.springRest.springRest.entities.Courses;

public interface CourseService {

	public List<Courses> getCourses();

	public Courses getCourse(Long courseId);

	public ResponseEntity<HttpStatus> addCourse(Courses course);

	public ResponseEntity<HttpStatus> updateCourse(Courses course);

	public ResponseEntity<HttpStatus> deleteCourse(Long courseId);

	

}
