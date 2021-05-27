package com.springRest.springRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springRest.springRest.services.CourseService;

@RestController
public class DeleteTable {
	
	@Autowired
	private CourseService service;
	
	@DeleteMapping("/courses")
	public ResponseEntity<HttpStatus> deleteAllCourses() {
		return service.deleteAllCourses();
	}
}
