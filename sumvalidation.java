import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;



public class sumvalidation {

	@Test
	public void sumofcourse() {
	 
		int sum=0;
		JsonPath js=new JsonPath(Courice.Addplace());
		int count=js.getInt("courses.size()");
		for(int i=0;i<count;i++) {
			int price=js.getInt("courses["+i+"].price");
			int copies=js.getInt("courses["+i+"].copies");
			int amount=price*copies;
			System.out.println(amount);
			 sum=sum+amount;
			
		}
		 System.out.println(sum);
	}
}
