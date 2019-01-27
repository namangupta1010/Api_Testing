package api_package;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Testing_data {
	
	
	@Test
	public void dataTesting()
	{
		given().header("Content-Type","application/json")
		.header("api-key", "ElJkhJuQIRoFq/kDEblco4LpZqRCdYNIoAVG7SywSXw")
		.when()
		.get("https://api.shipengine.com/v1/shipments/se-33127839")
		.then()
		.statusCode(200)
		.body("ship_to.name", equalTo("Dade Murphy"))
		.log().all();
	}

}
