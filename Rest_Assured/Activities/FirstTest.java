package examples;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstTest {
	// GET https://petstore.swagger.io/v2/pet/findByStatus?status=sold
	@Test
	
	public void getRequestWithQueryParam() {
		//send request, savr request
		Response response =
				RestAssured.given().
				    baseUri("https://petstore.swagger.io/v2/pet").
				    header("Content-Type", "application/json"). //Define Request Type 
				    queryParam("status","sold").
				when().
				    get("/findByStatus");
		//Print the response body
		System.out.println(response.getBody().asString());
		System.out.println("===============================");
		System.out.println(response.getBody().asPrettyString());
		//Print the response headers
		System.out.println(response.getHeaders().asList());
		//Extract properties from the response body
		String petStatus = response.then().extract().path("[0].status");
		System.out.println(petStatus);
	
	
	//Assertions
	
	Assert.assertEquals(petStatus, "sold");
	
	//RestAssured assertions
	response.then().
	    statusCode(200).
	    body("[0].status", Matchers.equalTo("sold"));
	
}
	// GET https://petstore.swagger.io/v2/pet/{petId}
	@Test
	public void getRequestWithPathParam() {
		// Send request, receive response, assert
		RestAssured.given().
			baseUri("https://petstore.swagger.io/v2/pet").
			header("Content-Type", "application/json"). // Define request type
			pathParam("petId", 12).
		when().
			get("/{petId}"). // get("/12")
		then().
			statusCode(200).
			body("status", Matchers.equalTo("available")).
			body("name", Matchers.equalTo("doggie"));
	}
}
	
	

