package com.base;

import java.io.IOException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import com.utilities.Utils;

import groovy.util.logging.Log4j;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {

	public static RequestSpecification httpRequest;

	public static Response response;

	public String empID = "51838";

	public Logger logger;

	//	public Utils;

	@BeforeClass
	public void setup() throws IOException
	{

	//	RestAssured.baseURI = Utils.getBaseURL("baseUrl");

	//	httpRequest = RestAssured.given();

		PropertyConfigurator.configure("test-output/log4j.properties");

		logger = Logger.getLogger("*****  Logging started  *****");

		;

		logger.setLevel(Level.DEBUG);
	}

}
