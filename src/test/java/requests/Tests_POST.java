package requests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Tests_POST {

	@Test
	public void test_01_post()
	{
		JSONObject request = new JSONObject();
		
		request.put("name", "Ricky");
		request.put("job", "Accountant");
		
		System.out.println(request);
		
		System.out.println(request.toJSONString());
		

				given().
				
				    header("Content-Type","application/json"). 
				    
				    contentType(ContentType.JSON).
				    
				    accept(ContentType.JSON). 
				    
				    body(request.toJSONString()).
				    
		        when().
		        
				    post("https://reqres.in/api/users").
				    
				then().
				
				statusCode(201);
				    
		
	}
}
