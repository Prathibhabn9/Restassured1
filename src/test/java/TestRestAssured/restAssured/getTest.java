package TestRestAssured.restAssured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getTest {
	@Test
	public void getreq() {
		Response res=RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println(res.statusCode());
		System.out.println(res.asPrettyString());
		String s=res.asPrettyString();
		
	}
	@Test
	public void responsevalidtaion() {
		given().get("https://reqres.in/api/users?page=2")
		.then()
		.body("data[0].email",equalTo("michael.lawson@reqres.in"))
		.body("data.first_name",hasItems("Michael","Byron"));
	}
	

		
}
