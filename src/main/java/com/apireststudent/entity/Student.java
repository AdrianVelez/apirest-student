package com.apireststudent.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor


public class Student {
	
	private String id;
	private String name;
	private String lastName;
	private String sex;
	private String age;
	private String status;
	private String email;
	

}
