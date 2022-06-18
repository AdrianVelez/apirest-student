package com.apireststudent.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public List<Student> getStudent(){
		return student;
	}
	
	
	
	
}
