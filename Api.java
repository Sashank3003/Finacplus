package Api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Api {
@Test
public void main() {

	given()
	
	.when()
	.get("https://reqres.in/api/users?page=2")
	
	
	.then()
	    .statusCode(200);
	  
	    
	

}

}
