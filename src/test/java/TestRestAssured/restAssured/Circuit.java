package TestRestAssured.restAssured;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import java.io.File;



import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class Circuit {
	
	@BeforeTest
	public void setup() {
		System.out.println("beforetest");
	}
	@DataProvider(name="seasonAndNoofRaces")
	public Object[][] createTestData(){
		return new Object[][] {
			{"2017",20},

			{"2024",24},
		};
	}
	@DataProvider(name="testData")
	public Object[][] createTestData1(){
		return new Object[][] {
			{"Anne",20},

			{"Cedric",22},
		};
	}
@Test(dataProvider="seasonAndNoofRaces")
public void Test1 (String season,int noofRaces){
	given().pathParam("raceseason1", season)
	.when().get("https://ergast.com/api/f1/{raceseason1}/circuits.json")
				.then().assertThat()
				.body("MRData.CircuitTable.Circuits",hasSize(noofRaces));
	
	
}
@AfterTest
public void close() {
	System.out.println("aftertest");
}
}
