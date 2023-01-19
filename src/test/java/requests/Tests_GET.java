package requests;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class Tests_GET {

	
	@Test
	public void test_logResponse()
	{
		Response response = RestAssured.given().get("https://reqres.in/api/users?page=2");
		
		response
		.then()
		.statusCode(200)
		.body("data.id[1]", equalTo(8))
		.body("data.first_name", hasItems("Michael","Lindsay"));
		
	}
	
	public void getSingleUser() 
	{
Response response = RestAssured.given().get("https://reqres.in/api/users/2");
		
		response
		.then()
		.statusCode(200)
		.body("data.id[1]", equalTo(8))
		.body("data.first_name", hasItems("Michael","Lindsay"));

	}
}

// Framework Layer :- Utilities , Listeners

// Business layer /Page Object Layer :- Contains business logic request needs to be parameters

// Test Layer :- Inserts data to business layer and receives result from it and finally asserts it

//