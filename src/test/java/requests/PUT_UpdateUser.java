package requests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.utilities.Utils;

public class PUT_UpdateUser {

	@Test
	public void update_User_Details() throws IOException
	{
		
		Utils.requestSpecification();
		
		Utils.payload(Utils.inputJsonFile_For_PUT());
		
		Utils.responseBody("PUT_USER_ENDPOINT_URL")
	   .then()
	   .statusCode(200);		
	}
}
