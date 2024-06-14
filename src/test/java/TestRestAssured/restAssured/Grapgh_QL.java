package TestRestAssured.restAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
public class Grapgh_QL {
	public static String grapghqltoJSON(String payload) {
		JSONObject json=new JSONObject();
		json.put("query", payload);
		return json.toString();
	}
	@Test
	public void testgraphql() {
		baseURI="https://www.predic8.de/fruit-shop-graphql";
		String query = "query{\r\n"
				+ " products(id: \"7\"){\r\n"
				+ "	name\r\n"
				+ "	price\r\n"
				+ "	category{\r\n"
				+ "	 name\r\n"
				+ "	 }\r\n"
				+ "	 vendor{\r\n"
				+ "	  name\r\n"
				+ "	  id\r\n"
				+ "	}\r\n"
				+ "  }\r\n"
				+ "}";
		
		String jsonString=grapghqltoJSON(query);
		
		given()
			.contentType(ContentType.JSON)
			.body(jsonString)
		.when()
			.post()
		.then()
			.assertThat()
			.statusLine("HTTP/1.1 200 OK")
			.log().all();
	}

}
