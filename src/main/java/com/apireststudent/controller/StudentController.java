package com.apireststudent.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




import com.apireststudent.entity.Student;
//import com.apireststudent.service.PutMapping;
//import com.apireststudent.service.RequestBody;
import com.apireststudent.service.StudentService;


@RestController
@RequestMapping("/student" )
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public ResponseEntity<List<Student>> getStudentAll(){
			return new ResponseEntity<List<Student>>(studentService.getStudent(), HttpStatus.OK);
	}
	
	/* Mostrar Por UserName
		@GetMapping(value = "/{username}")
		public ResponseEntity<Student> getStudentByUserName(@PathVariable("username") String username){
			return new ResponseEntity<Student>(studentService.getStudentByUserName(username), HttpStatus.OK);
		}
     */
	
		@GetMapping(value = "/{id}")
		public ResponseEntity<Student> getStudentById(@PathVariable("id") String id){
			return new ResponseEntity<Student>(studentService.getStudentById(id), HttpStatus.OK);
		
		
	}
		@PostMapping
		public ResponseEntity<Student>CreateStudent(@RequestBody Student newStudent){
			return new ResponseEntity<Student>(studentService.createStudent(newStudent), HttpStatus.CREATED);
		}
		
		@PutMapping( value = "/student/{id}")
		public ResponseEntity<Student>UpdateStudent(@PathVariable("id") String id,
				@RequestBody Student student) {
			
			return new ResponseEntity<Student>( studentService.updateStudent(student, id), HttpStatus.OK);			

		}
	
		
		@DeleteMapping(value = "/{id}")
		public ResponseEntity<Void> deleteStudent(@PathVariable("id")String id){
			studentService.deleteStudent(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	
}
	
 //Adrian Velez 
	
	
	
