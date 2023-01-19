package requests;

import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.testng.annotations.Test;

import com.utilities.Utils;

public class DELETE_SingleUser {

Utils utils;
	
	@Test
	public void get_User_Detail() throws IOException
	{
	//	utils = new Utils();
		
		Utils.requestSpecification();
		
		Utils.noPayload();
		
		Utils.responseBody("DELETE_USER_ENDPOINT_URL")
				.then().statusCode(204);		 
		
		
	}
}
