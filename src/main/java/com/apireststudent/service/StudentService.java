package com.apireststudent.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.apireststudent.entity.Student;
import com.github.javafaker.Faker;

@Service
public class StudentService {

	@Autowired
	private Faker faker;
	
	List<Student> student = new ArrayList<>();
	
	@PostConstruct
	public void init() {	
		for(int i=0; i<10; i++) {
					student.add((new Student(faker.idNumber().invalid(), 
					faker.name().firstName(),
					faker.name().lastName(), 
					faker.demographic().sex(),
					faker.number().digit(), 
					faker.demographic().maritalStatus(),
					faker.internet().safeEmailAddress())));
			
		}
	}
	//Mostrar todos los Estudiantes creados 
	public List<Student> getStudent(){
		return student;
	}
	
	
	/* Busca Por UserName
		public Student getStudentByUserName(String username){
			return student.stream()
					.filter(u -> u.getUserName().equals(username)).findAny()
					.orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,
							String.format("User %s not found",username)));
	}*/
	
		// Busca Por ID
		public Student getStudentById(String id) {
			return student.stream()
					.filter(u -> u.getId().equals(id)).findAny()
					.orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,
							String.format("User %s not found",id)));
		}
		
		public Student createStudent(Student newStudent) {
			if(student.stream()
					.anyMatch(u -> u.getUserName().equals(newStudent.getUserName()))) {
					throw new ResponseStatusException(HttpStatus.CONFLICT,
						String.format("User %s Already Exists", newStudent.getUserName()));
			}
			student.add(newStudent);
			return newStudent;
		}
		
		
		public Student updateStudent(Student student, String id) {
			 
			Student studentTobeUpdate = getStudentById(id);
			 
			 studentTobeUpdate.setUserName(student.getUserName());
			 studentTobeUpdate.setLastName(student.getLastName());
			 studentTobeUpdate.setSex(student.getSex());
			 studentTobeUpdate.setAge(student.getLastName());
			 studentTobeUpdate.setStatus(student.getStatus());
			 studentTobeUpdate.setEmail(student.getStatus());
						
			return studentTobeUpdate;
		}
		
		///elimina
		public void deleteStudent(String id) {
			Student studentTobeUpdate = getStudentById(id);
			student.remove(studentTobeUpdate);
		}


}
		
	

	/*	
	public List<Student> getStudentById(String id){
		return (List<Student>) student.get(id);
	
	    int posicion = student.indexOf(id);	    
	     return  (List<Student>) student.get(posicion);
	}
public void getStudentById(String id) {
	
	for (Student st : student) {
		if(st.getId().equals(id));
		return st;*/
