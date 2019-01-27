package api_package;


import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_data {
	
	@Test
	public void get_response()
	{
		RequestSpecification request= RestAssured.given();
		request.header("Content-Type","application/json");
		request.header("api-key", "ElJkhJuQIRoFq/kDEblco4LpZqRCdYNIoAVG7SywSXw");
		System.out.println("test");
		request.header("Cache-Control","no-cache"); 
				
		Response response =request.get("https://api.shipengine.com/v1/shipments/se-33127839");
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		Assert.assertEquals( response.getStatusCode(),200);
		
		//Assert.assertEquals(response.getBody().asString().contains("Shippy"), true);
		
		
		/*JsonPath jsonPathEvaluator = response.jsonPath();
		//List<Object> names=new ArrayList<Object>();
		List<String>  names =jsonPathEvaluator.getList("name");*/
		
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		System.out.println(jsonPathEvaluator.get("carrier_id"));
		List <Object> names =jsonPathEvaluator.getList("name");
		for(Object nameJson : names)
			System.out.println(nameJson);
		
		System.out.println(response.getBody().asString());
	}

}
