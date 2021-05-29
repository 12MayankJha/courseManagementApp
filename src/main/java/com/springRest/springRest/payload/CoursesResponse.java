package com.springRest.springRest.payload;

import java.util.List;
import org.springframework.http.HttpStatus;
import com.springRest.springRest.entities.Courses;

public class CoursesResponse {
	
	private HttpStatus status;
	private Courses course;
	private List<Courses> courseList;
	
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public Courses getCourse() {
		return course;
	}
	public void setCourse(Courses course) {
		this.course = course;
	}
	public List<Courses> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Courses> courseList) {
		this.courseList = courseList;
	}
	

}
