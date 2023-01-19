package requests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.employee.EmployeeSerializationUsingObjectMapper;
import com.employee.Employee_POJO;
import com.user.CreateUser_POJO;
import com.utilities.Utils;

public class POST_CreateUser extends TestBase{

	
	@Test
	public void createUser_POST() throws IOException
	{
	//	CreateUser_POJO user = new CreateUser_POJO();
		
		Utils utils = new Utils();
		
		Utils.requestSpecification();
		
     	Utils.payload(Utils.inputJsonFile_For_POST());
		
		Utils.responseBody("POST_ENDPOINT_URL")
	   .then()
	   .statusCode(201);		
	  
	}
}
