import io.restassured.path.json.JsonPath;

public class ComplexJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JsonPath js=new JsonPath(Courice.Addplace());
		//print no.of courses API
		int count=js.getInt("courses.size()");
		System.out.println(count);
		int total=js.getInt("dashboard.purchaseAmount");
		System.out.println(total);
		String Firsttitlecourses=js.get("courses[0].title");
		System.out.println(Firsttitlecourses);
		for(int i=0;i<count;i++) {
			String title=js.getString("courses["+i+"].title");
			int price=js.getInt("courses["+i+"].price");
			System.out.println(title);
			System.out.println(price);
		}
		//print no.of RPA
		for(int i=0;i<count;i++) {
		
		
			String title=js.getString("courses["+i+"].title");
			if(title.equalsIgnoreCase("RPA")) {
				System.out.println(js.getString("courses["+i+"].copies"));
			}
		}
	}

}
