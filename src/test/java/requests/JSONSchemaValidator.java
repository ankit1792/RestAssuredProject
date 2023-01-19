package requests;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;


import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JSONSchemaValidator {


	@Test
	public void validateJSONAgainstSchema()
	{

		Response response = RestAssured.given().get("https://reqres.in/api/users?page=2");

		response

		.then()

		.assertThat().body(matchesJsonSchemaInClasspath("schema.json"))

		.statusCode(200);

	}
}
