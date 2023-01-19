package com.employee;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeSerializationUsingObjectMapper {

	/*
	public static Object setEmployeeDetails()
	{
		Employee_POJO employee = new Employee_POJO();
		
		employee.setFirstName("Peter");
		employee.setLastName("Parker");
		employee.setAge(28);
		employee.setSalary(60000);
		employee.setGender("M");

		return employee;
	}
	*/
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Employee_POJO employee = new Employee_POJO();
		
		employee.setFirstName("Peter");
		employee.setLastName("Parker");
		employee.setAge(28);
		employee.setSalary(60000);
		employee.setGender("M");
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		String convertedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
		
		System.out.println(convertedJson);
		
		String userDir = System.getProperty("user.dir");
		
		File outputJsonFile = new File(userDir+ "\\src\\main\\resources\\EmployeePayload.json");
		
		objectMapper.writerWithDefaultPrettyPrinter().writeValue(outputJsonFile, employee);
		
	 
	}

}
