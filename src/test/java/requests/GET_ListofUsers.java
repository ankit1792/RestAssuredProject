package requests;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.io.IOException;

import org.testng.annotations.Test;

import com.utilities.Utils;

public class GET_ListofUsers {

Utils utils;
	
	@Test
	public void get_List_Of_User_Details() throws IOException
	{
		
		Utils.requestSpecification();
		
		Utils.noPayload();
		
		Utils.responseBody("GET_LIST_OF_USERS_ENDPOINT_URL")
				.then()
				.statusCode(200)
				.and()
				.body("data.id[1]", equalTo(8))
				.body("data.first_name", hasItems("Michael","Lindsay"));
;		 				
	}

}
