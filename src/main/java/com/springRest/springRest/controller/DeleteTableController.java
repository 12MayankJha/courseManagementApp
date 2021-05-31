package com.springRest.springRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springRest.springRest.services.CourseService;

@RestController
public class DeleteTableController {
	
	@Autowired
	private CourseService service;
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<HttpStatus> deleteAll() {
		return service.deleteAll();
	}
}
