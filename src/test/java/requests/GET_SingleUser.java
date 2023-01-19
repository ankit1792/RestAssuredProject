package requests;

import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.testng.annotations.Test;

import com.utilities.Utils;


public class GET_SingleUser {

//Utils utils;

Utils utils;
	
	@Test
	public void get_User_Detail() throws IOException
	{
	//	utils = new Utils();
		
		Utils.requestSpecification();
		
		Utils.noPayload();
		
		Utils.responseBody("GET_USER_ENDPOINT_URL")
				.then().statusCode(200)
				.and()
			    .body("data.email",equalTo("janet.weaver@reqres.in"));		 
		
		
	}
}
