package api_package;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
		//System.out.println(response.getHeaders());
		System.out.println(response.getBody().asString());

		
		JsonPath jsonPathEvaluator = response.jsonPath();
		System.out.println("Shp To "+jsonPathEvaluator.get("ship_to").toString());
		System.out.println("List "+jsonPathEvaluator.getMap("$"));
		Map map=jsonPathEvaluator.getMap("$");
		for(Object key:map.keySet()) {

			if(map.get(key) instanceof Map) {
				Map innermap=(Map) map.get(key);
				//		for(Object innerKey:innermap.keySet()) {
				//		System.out.println("value "+innermap.get(innerKey));
				//		}
				System.out.println(key+" name "+innermap.get("name"));
			}

		}

		
		
		System.out.println(jsonPathEvaluator.get("carrier_id"));
		System.out.println(jsonPathEvaluator.getList("name"));
		//System.out.println(jsonPathEvaluator.get("ship_to.address_line"));
		
		
		
//		hm = jsonPathEvaluator.getMap("carrier_id");
		
//		for(Entry m :jsonObject.)
//		{
//			System.out.println(m.getKey() + "=" + m.getValue());
//		}
		
		
	}

}
