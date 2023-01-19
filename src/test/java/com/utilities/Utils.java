package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import org.json.JSONObject;

import com.employee.Employee_POJO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.CreateUser_POJO;

import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Utils {

	public static RequestSpecification req;

	public static RequestSpecification req1;

	public static Response res;

	public static JSONObject jObject;

	public static ObjectMapper mapper;

	public static CreateUser_POJO user;
	
	public static String jSONStringPayload;
	
	public static String jSONStringPayload1;

	public static final String CREATE_USER_DATA_JSONFILEPATH = "C:/Users/ankittolambiya/eclipse-workspace"
			+ "/RestAssuredProject/src/test"
			+ "/resources/testData/CreateUserData.json";

	public static final String CREATE_REGISTER_DATA_JSONFILEPATH = "C:/Users/ankittolambiya/eclipse-workspace"
			+ "/RestAssuredProject/src/test/"
			+ "resources\\testData\\RegisterUserData.json";
	
	public static final String UPDATE_USER_DATA_JSONFILEPATH = "C:/Users/ankittolambiya/eclipse-workspace"
			+ "/RestAssuredProject/src/test"
			+ "/resources/testData/UpdateUserData.json";

	public static final String PARTIAL_UPDATE_USER_DATA_JSONFILEPATH = "C:/Users/ankittolambiya/eclipse-workspace"
			+ "/RestAssuredProject/src/test"
			+ "/resources/testData/PartialUpdateUserData.json";
	

	public static String getProperty(String key) throws IOException {
		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");

		prop.load(fis);

		return prop.getProperty(key);

	}

	public static String getBaseURL(String key) throws IOException {
		String url = getProperty(key);
		return url;
	}

	public static RequestSpecification requestSpecification() throws IOException
	{

		req = new RequestSpecBuilder().setBaseUri(getBaseURL("baseUrl")).build();

		return req;
	}

	public static RequestSpecification payload(JSONObject data) 
	{

		req1 = given().spec(req).body(data);

		return req1 ;
	}

	public static RequestSpecification payload(String payload) 
	{

		req1 = given().spec(req).body(payload);

		return req1 ;
	}
	
	public static RequestSpecification payload_from_POJO_Using_Serialization(CreateUser_POJO data) throws IOException 
	{
		//   user = new CreateUser_POJO();

	//	mapper = new ObjectMapper();

//		user = mapper.readValue(Paths.get("C:\\Users\\ankittolambiya\\eclipse-workspace\\RestAssuredProject\\src\\test\\resources\\testData\\CreateUserData.json").toFile(), CreateUser_POJO.class);

		//	System.out.println(user);

		//	String convertedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);

		//	return convertedJson;
		
		req1 = given().spec(req).body(data);

		return req1 ;
	}


	public static RequestSpecification noPayload() 
	{
		req1 = given().spec(req);

		return req1 ;
	}



	public static Response responseBody(String url) throws IOException 
	{
		if(url.equalsIgnoreCase("POST_ENDPOINT_URL") || url.equalsIgnoreCase("POST_ENDPOINT_URL1"))
		{
			res = req1.when().post(getProperty(url)).then().extract().response().prettyPeek();
		}

		else if((url.equalsIgnoreCase("GET_USER_ENDPOINT_URL") || url.equalsIgnoreCase("GET_LIST_OF_USERS_ENDPOINT_URL")))
		{
			res = req1.when().get(getProperty(url)).then().extract().response().prettyPeek();
		}

		else if((url.equalsIgnoreCase("PUT_USER_ENDPOINT_URL")))
		{
			res = req1.when().put(getProperty(url)).then().extract().response().prettyPeek();
		}

		else if((url.equalsIgnoreCase("PATCH_USER_ENDPOINT_URL")))
		{
			res = req1.when().patch(getProperty(url)).then().extract().response().prettyPeek();
		}

		else
		{
			res = req1.when().delete(getProperty(url)).then().extract().response().prettyPeek();
		}

		return res;

	}

	
	public static JSONObject inputJsonFile_For_POST() throws IOException 
	{		
		String content = new String(Files.readAllBytes(Paths.get(CREATE_USER_DATA_JSONFILEPATH)));

		jObject = new JSONObject(content);
		
		System.out.println("Value of name is "+jObject.getString("name"));

		return jObject;

	//	return new JSONObject(content);
	}

	public static JSONObject inputJsonFile_For_PUT() throws IOException 
	{		
		String content = new String(Files.readAllBytes(Paths.get(UPDATE_USER_DATA_JSONFILEPATH)));

		jObject = new JSONObject(content);

		return jObject;

		//return new JSONObject(content);
	}

	public static JSONObject inputJsonFile_For_PATCH() throws IOException 
	{		
		String content = new String(Files.readAllBytes(Paths.get(PARTIAL_UPDATE_USER_DATA_JSONFILEPATH)));

		jObject = new JSONObject(content);

		return jObject;
	}

	public CreateUser_POJO inputJsonFile_For_POST_Using_POJO_Class() throws IOException 
	{	
		user = new CreateUser_POJO();
		
		String content = new String(Files.readAllBytes(Paths.get(CREATE_USER_DATA_JSONFILEPATH)));

		jObject = new JSONObject(content);
		
		user.setName(jObject.getString("name"));
		
		user.setJob(jObject.getString("job"));

		return user;
	}
	
	// ****** This method converts the POJO class object to a JSON payload as string using Object Mapper class******
	
	public static String inputPOJO_To_StringJSONPayload(CreateUser_POJO user) throws JsonProcessingException
	{
		mapper = new ObjectMapper();
		
		jSONStringPayload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
		
		return jSONStringPayload;
	}
	
	/*
	public static String inputPOJO_To_StringJSONPayloadRegisterUser(RegisterUser_POJO register) throws JsonProcessingException
	{
		mapper = new ObjectMapper();
		
		jSONStringPayload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(register);
		
		return jSONStringPayload;
	}

	*/
//	public CreateUser_POJO getResponseBody(String )
	
	// ****** This method converts the string payload to JSON object using JSONObject class ******
	
	public static JSONObject convert_ObjectMapperString_To_JSON_For_POST() throws IOException 
	{		
	  String content = jSONStringPayload;
		
		jObject = new JSONObject(content);
		
		return jObject;

	}


}
