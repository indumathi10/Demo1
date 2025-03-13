package file;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
public class Users {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	/*RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://reqres.in/").build();
	ResponseSpecification resSpec=new ResponseSpecBuilder().expectStatusCode(201).build();
	
	RequestSpecification res= given().log().all().spec(req).body(Username.Addname());
	
	                 Response value= res.when().post("api/users").then().spec(resSpec).log().all().extract().response();
	                          String resString=value.asString();
	                          System.out.println(resString);*/
		
		RestAssured.baseURI="https://reqres.in/";
		String response=given().log().all().body(Username.Addname())
		.when().post("api/users").then().assertThat().log().all().statusCode(201).extract().response().asString();
		
		System.out.println(response);
		JsonPath js=new JsonPath(response);
		String ID=js.get("id");
		System.out.println(ID);

	                        

	}

}
