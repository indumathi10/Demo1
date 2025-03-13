import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured .*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import file.payload;

public class Post {
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
        //post place
       System.out.println(payload.Addplace());
      
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		String response=given().log().all()
				.queryParam("Key", "qaclick123")
				.header("Content-Type","application/json")
		        .body(new String(Files.readAllBytes(Paths.get("C:\\Users\\Janum\\eclipse-workspace\\addplace.json"))))
		        .when().post("/maps/api/place/add/json/")
		        .then().assertThat().statusCode(200)
		        .body("scope",equalTo("APP")).extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js=new JsonPath(response);
		String place_id =js.getString("place_id");
		String id=js.getString("id");
		
		System.out.println(place_id );
		System.out.println(id);
		
		//update place
		
		String newAddress = "70 winter walk, USA";
        String updateResponse =given().log().all()
        		          .queryParam("Key", "qaclick123")
        		          .header("Content-Type","application/json")
		                   .body("{\r\n"
		                   		+ "\"place_id\":\""+place_id+"\",\r\n"
		                   		+ "\"address\":\""+newAddress+"\",\r\n"
		                   		+ "\"key\":\"qaclick123\"\r\n"
		                   		+ "}\r\n"
		                   		+ "").when().put("/maps/api/place/update/json").
		                   then().assertThat().statusCode(200).
		                   body("msg",equalTo("Address successfully updated")).extract().
		                   response().asString();
        
        System.out.println(updateResponse );

        //Get place
        
     
       String getResponse = given().log().all()
                .queryParam("key", "qaclick123")
                .queryParam("place_id", place_id)
                .when().get("/maps/api/place/get/json")
                .then().assertThat().statusCode(200)
                .body("address", equalTo(newAddress))
                .extract().response().asString();
        
       System.out.println("Get Response: " + getResponse);
	
	}
}











