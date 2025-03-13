package file;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured .*;
public class DynamicJson {

	@Test(dataProvider="Books")
	public void Addbook(String isbn,String aisle) {
		RestAssured.baseURI="http://216.10.245.166";
		String Response = given().log().all().header("Content-Type","application/json")
		.body(payload.Addbooks(isbn,aisle))
		.when().post("/Library/Addbook.php")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
		
		JsonPath js=new JsonPath(Response);
		String id=js.get("ID");
		System.out.println(id);
	}
	
	@DataProvider(name="Books")
	public Object[][] getData() {
		return new Object[][] {{"abc","123"},{"def","456"}};
		
	}
	
}
