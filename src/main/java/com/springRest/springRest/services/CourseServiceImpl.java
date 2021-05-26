package com.springRest.springRest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springRest.springRest.dao.CourseDao;
import com.springRest.springRest.entities.Courses;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;

	//List<Courses> list;
	
	public CourseServiceImpl() {
//		
//		list = new ArrayList<>();
//		
//		list.add(new Courses(101, "English", "This course contains english"));
//		list.add(new Courses(102, "Maths", "This course contains Maths"));
//		list.add(new Courses(103, "Hindi", "This course contains Hindi"));
	}
	
	@Override
	public List<Courses> getCourses() {
		//return list;
		
		return courseDao.findAll();
	}


	@Override
	public Courses getCourse(Long courseId) {	
//		Courses selectedCourse = null;
//		
//		for(Courses course: list) {
//			if (course.getId() == courseId) {
//				selectedCourse = course;
//				break;
//			}
//		}
//		
//		return selectedCourse;
		
		return courseDao.getById(courseId);
	}

	@Override
	public ResponseEntity<HttpStatus> addCourse(Courses course) {
		//list.add(course);
		
		courseDao.save(course);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<HttpStatus> updateCourse(Courses updateCourse) {
//		for(Courses course: list) {
//			if (course.getId() == updateCourse.getId()) {
//				course.setName(updateCourse.getName());
//				course.setDescription(updateCourse.getDescription());
//				return new ResponseEntity<>(HttpStatus.OK);
//			}
//		}
//		return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		courseDao.save(updateCourse);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<HttpStatus> deleteCourse(Long courseId) {	
//		for(Courses course: list) {
//			if (course.getId() == courseId) {
//				list.remove(course);
//				return new ResponseEntity<>(HttpStatus.OK);
//			}
//		}
//		return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		Courses course = courseDao.getById(courseId);
		courseDao.delete(course);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}





}
