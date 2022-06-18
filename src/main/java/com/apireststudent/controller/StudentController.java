package com.apireststudent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apireststudent.entity.Student;
import com.apireststudent.service.StudentService;

@RestController
@RequestMapping("/student" )
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public ResponseEntity<List<Student>> getStudentAll(){
			return new ResponseEntity<List<Student>>(studentService.getStudent(), HttpStatus.OK);
		
 //Adrian Velez 
	
	}
	
}
