package com.employeeapi.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_Get_All_Employees extends TestBase{

	
	@BeforeClass
	public void getAllEmployees() throws InterruptedException
	{
		logger.info("*******Started TC001_Get_All_Employees*******");
		
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		
		httpRequest = RestAssured.given();
		
//    	response = httpRequest.request(Method.GET,"/employees");
		
		response = httpRequest.request(Method.POST,"/employees");
		
//		response = httpRequest.request(Method.PATCH,"/employees");
		
//		response = httpRequest.request(Method.PUT,"/employees");
		
//		response = httpRequest.request(Method.DELETE,"/employees");
		
		Thread.sleep(3);
	}
	
	
	@Test
	public void checkResponseBody()
	{
		logger.info("*******  Checking Response Body *******");
		
		String responseBody = response.getBody().asString();
		
		logger.info("Response Body ==>"+responseBody);
		
		Assert.assertTrue(responseBody!=null);
	} 
	
	
	@Test
	public void checkStatusCode()
	{
		logger.info("*******  Checking Status Code *******");
		
		int statusCode = response.getStatusCode();
		
		logger.info("Status Code is ==>"+ statusCode);
		
		Assert.assertEquals(statusCode, 200);

	}
	
	
	@Test
	public void checkResponseTIme()
	{
		logger.info("*******  Checking Response Time *******");
		
		long responseTime = response.getTime();
		
		logger.info("Response Time is ==>"+ responseTime);
		
		
		if(responseTime>2000)
		{
			logger.warn("Response Time is greater than 2000");
		}
		
		Assert.assertTrue(responseTime<2000);
	}
	
	public void checkContentType()
	{
		logger.info("*******  Checking Content Type *******");
		
		String contentType = response.header("Content-Type");
		
		logger.info("Content type is ==>"+ contentType);
		
	}
	
	
	@AfterClass
	public void tearDown()
	{
		logger.info("******** Finished TC001 _Get_ALL_Employees");
	}
}
