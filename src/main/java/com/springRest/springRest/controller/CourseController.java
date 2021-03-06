package com.springRest.springRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springRest.springRest.entities.Courses;
import com.springRest.springRest.payload.CoursesResponse;
import com.springRest.springRest.services.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService service;

	@GetMapping("/home")
	public String getHome() {
		return "welcome to Courses home";
	}
	
	
	//GetList
	@GetMapping("/courses")
	public CoursesResponse getCourses() {
		CoursesResponse outputResponse = new CoursesResponse();
		try {
			List<Courses> courses = service.getCourses();
			outputResponse.setStatus(HttpStatus.OK);
			outputResponse.setCourseList(courses);

		} catch (Exception e) {
			outputResponse.setStatus(HttpStatus.SERVICE_UNAVAILABLE);
		}

		return outputResponse;
	}
	
	@GetMapping("/courses/{courseId}")
	public Courses getCourse(@PathVariable Long courseId) {
		return service.getCourse(courseId);
	}
	
	@PostMapping("/courses")
	public ResponseEntity<HttpStatus> addCourse(@RequestBody Courses course) {	
		return service.addCourse(course);
	}
	
	@PutMapping("/courses")
	public ResponseEntity<HttpStatus> updateCourse(@RequestBody Courses course) {	
		return service.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long courseId) {
		return service.deleteCourse(courseId);
	}
	
	
}
