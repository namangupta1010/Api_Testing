package postRequest;

import java.io.File;

import java.io.FileNotFoundException;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_data {

	@Test
	public void testResponse() throws FileNotFoundException
	{
		RequestSpecification request =RestAssured.given();
		request.header("Content-Type","application/json");
		request.header("api-key", "ElJkhJuQIRoFq/kDEblco4LpZqRCdYNIoAVG7SywSXw");
		File file =new File("C:\\Users\\HP\\Desktop\\jsonshipengine.json");
		request.body(file);
		
		Response response =request.post("https://api.shipengine.com/v1/rates");
		System.out.println(response.getStatusCode());
		System.out.println(response.asString());
		/*JSONObject json = new JSONObject();
		json.*/
	}
}
