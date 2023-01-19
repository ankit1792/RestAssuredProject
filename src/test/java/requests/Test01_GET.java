package requests;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;


public class Test01_GET {

	@Test
	public void test_01()
	{
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);

	}
	
	@Test
	public void test_SingleUser()
	{
		Response response = RestAssured.given().get("https://reqres.in/api/users/2");
		
		 response
		.then()
		.statusCode(200)
		.body("data.email",equalTo("janet.weaver@reqres.in"))
		.log().all();
	}
}
