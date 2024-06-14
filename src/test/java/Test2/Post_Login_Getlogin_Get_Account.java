package Test2;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Post_Login_Getlogin_Get_Account {
	@Test
	public void login() {
		
		
			
			baseURI= "https://demo.testfire.net/api";
			//baseURI = "https://petstore.swagger.io/v2";
			File jsonDataFile = new File("src/test/resources/data1.json");
			String Authorization=
					given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(jsonDataFile)			
			.when()
				.post("/login")
				.then()
				.extract()
				.path("Authorization");
			System.out.println(Authorization);
			
			given()
			.auth().oauth2(Authorization)
			.get("/login")
			
		.then()
		.log().all();	
			
			String Name=given()
			.auth().oauth2(Authorization)
			.get("https://demo.testfire.net/api/account")
			
		.then()
		.extract()
		.path("Accounts[0].Name");
			System.out.println(Name);
	}

}
