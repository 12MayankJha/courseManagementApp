package com.springRest.springRest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springRest.springRest.entities.Courses;

@Service
public class CourseServiceImpl implements CourseService {

	List<Courses> list;
	
	public CourseServiceImpl() {
		
		list = new ArrayList<>();
		
		list.add(new Courses(101, "English", "This course contains english"));
		list.add(new Courses(102, "Maths", "This course contains Maths"));
		list.add(new Courses(103, "Hindi", "This course contains Hindi"));
	}
	
	@Override
	public List<Courses> getCourses() {
		return list;
	}


	@Override
	public Courses getCourse(Long courseId) {	
		Courses selectedCourse = null;
		
		for(Courses course: list) {
			if (course.getId() == courseId) {
				selectedCourse = course;
				break;
			}
		}
		
		return selectedCourse;
	}

	@Override
	public ResponseEntity<HttpStatus> addCourse(Courses course) {
		list.add(course);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<HttpStatus> updateCourse(Courses updateCourse) {
		for(Courses course: list) {
			if (course.getId() == updateCourse.getId()) {
				course.setName(updateCourse.getName());
				course.setDescription(updateCourse.getDescription());
				return new ResponseEntity<>(HttpStatus.OK);
			}
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<HttpStatus> deleteCourse(Long courseId) {	
		for(Courses course: list) {
			if (course.getId() == courseId) {
				list.remove(course);
				return new ResponseEntity<>(HttpStatus.OK);
			}
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
	}





}
