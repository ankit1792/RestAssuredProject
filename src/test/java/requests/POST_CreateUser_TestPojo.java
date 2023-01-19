package requests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.utilities.Utils;

public class POST_CreateUser_TestPojo {

	@Test
	public void createUser_POST() throws IOException
	{
	//	CreateUser_POJO user = new CreateUser_POJO();
		
		Utils utils = new Utils();
		
		Utils.requestSpecification();
		
		Utils.payload_from_POJO_Using_Serialization(utils.inputJsonFile_For_POST_Using_POJO_Class());
		
		Utils.responseBody("POST_ENDPOINT_URL")
	   .then()
	   .statusCode(201);		
	  
	}
}
