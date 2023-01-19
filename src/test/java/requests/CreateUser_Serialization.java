package requests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.CreateUser_POJO;
import com.utilities.Utils;

public class CreateUser_Serialization {

	@Test
	public void CreateUserJSON_From_CreateUserPOJOClass() throws IOException
	{
		Utils utils = new Utils();
		
		ObjectMapper mapper = new ObjectMapper();
		
		CreateUser_POJO createUser = new CreateUser_POJO();

		createUser.setName("Jose Butler");

		createUser.setJob("Cricketer");
		
		Utils.requestSpecification();
		
		Utils.inputPOJO_To_StringJSONPayload(createUser);
		
		Utils.payload(Utils.convert_ObjectMapperString_To_JSON_For_POST());
		
		
		Utils.responseBody("POST_ENDPOINT_URL")
		.then()
		.statusCode(201);
			
		
	  CreateUser_POJO createUser1 = mapper.readValue(Utils.inputPOJO_To_StringJSONPayload(createUser), CreateUser_POJO.class);
		
	  Assert.assertEquals(createUser1.getName(),"Jose Butler","The name does not matches with the expected name value");
		
	}

}
