package requests;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.employee.Employee_POJO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.CreateUser_POJO;
import com.user.Data;
import com.user.Root;
import com.user.Support;
import com.utilities.Utils;

import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.response.Response;

public class Get_SingleUser_Serialization {

	@Test
	public void getSingleUserJSON_From_CreateUserPOJOClass() throws IOException
	{
		//	utils = new Utils();

		ObjectMapper mapper = new ObjectMapper();

		Data d1 = new Data();

		Support support = new Support();

		Root root = new Root();

		Utils.requestSpecification();

		Utils.noPayload();
		/*	
		Utils.responseBody("GET_USER_ENDPOINT_URL")
		.then().statusCode(200)
		.and()
		.body("data.email",equalTo("janet.weaver@reqres.in"));	
		 */


		String jsonString = Utils.responseBody("GET_USER_ENDPOINT_URL").getBody().asString();

	//	String userDir = System.getProperty("user.dir");


	//	File outputJsonFile = new File(userDir+ "\\src\\test\\resources\\GET_UserResponse.json");

		root = mapper.readValue(jsonString, Root.class);
     
        Assert.assertEquals(root.getData().getAvatar(),"https://reqres.in/img/faces/2-image.jpg");

	}

}
