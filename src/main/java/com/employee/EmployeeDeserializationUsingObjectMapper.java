package com.employee;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeDeserializationUsingObjectMapper {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		// TODO Auto-generated method stub

		String jsonString = "{\r\n" + 
				"  \"firstName\" : \"Peter\",\r\n" + 
				"  \"lastName\" : \"Parker\",\r\n" + 
				"  \"gender\" : \"M\",\r\n" + 
				"  \"age\" : 28,\r\n" + 
				"  \"salary\" : 60000 \r\n" + 
				"}";
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		
		Employee_POJO employeeObject = objectMapper.readValue(jsonString, Employee_POJO.class);
		
		String firsName = employeeObject.getFirstName();
		
		String lastName = employeeObject.getLastName();
		
		String gender = employeeObject.getGender();
		
		int age = employeeObject.getAge();
		
		double salary = employeeObject.getSalary();
		
		System.out.println("Details of Employee is as below:-");
		
		System.out.println();
		
		System.out.println("First Name : "+firsName);
		
		System.out.println("Last Name : "+lastName); 
		
		System.out.println("Gender : "+gender);
		
		System.out.println("Age : "+age);
		
		System.out.println("Salary : "+salary);
		
		
	}

}
