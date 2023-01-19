package requests;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Tests_DELETE {

	@Test
	public void test_01_delete()
	{
	

				given().
				
				    delete("https://reqres.in/api/users/2").
				    
				then().
				
				    statusCode(204)
				    .log().all();
		
	}

}
