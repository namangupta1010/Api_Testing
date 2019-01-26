package postRequest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Post_data {

	
	public void testResponse()
	{
		Response resp =RestAssured.get("");
		int code =resp.getStatusCode();
		System.out.println(code);
         //RestAssured.ge
	}
}
