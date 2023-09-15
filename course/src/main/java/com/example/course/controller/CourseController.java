package com.example.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.entity.Course;
import com.example.course.repo.CourseRepo;

@CrossOrigin("*")
@RestController
public class CourseController {

	@Autowired
	CourseRepo courseRepo;

	@PostMapping("/saveCourse")
	public Course saveCourse(@RequestBody Course course) {
		return courseRepo.save(course);
	}

	@GetMapping("/getAllCourses")
	public List<Course> findAllCourse() {
		return courseRepo.findAll();
	}

//	@GetMapping("/getCourseById/{id}")
//	public Course findCourseById(@PathVariable Integer id) {
//		return courseRepo.findById(id).get();

//	}
	@DeleteMapping("/deleteCourse")
	public String deleteCourse(@PathVariable Integer id) {
		courseRepo.deleteById(id);
		return "Successfully Deleted" + id;
	}

	@PutMapping("/updateCourse")
	public Course saveCourse(@RequestBody Course course, @PathVariable Integer id) {
		Course course1 = courseRepo.findById(id).get();
		course1.setCoursename(course.getCoursename());
		course1.setPrice(course.getPrice());
		course1.setDiscription(course.getDiscription());
		course1.setUrl(course.getUrl());
		return courseRepo.save(course1);
	}
}