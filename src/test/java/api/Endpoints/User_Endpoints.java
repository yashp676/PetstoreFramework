package api.Endpoints;

import static io.restassured.RestAssured.*;
import api.Payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//Having CRUD Operations
public class User_Endpoints {

	public static Response CreateUser(User payload) 
	{
		
		Response response = given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		
		.when()
		  .post(Routes.post_url);
		
		  return response;
	}
	
	public static Response ReadUser(String username) 
	{
		
		Response response = given()
		   .pathParam("username", username)
		   
		
		.when()
		  .get(Routes.get_url);
		
		  return response;
	}
	
	public static Response UpdateUser(String username,User payload) 
	{
		
		Response response = given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .pathParam("username",username)
		   .body(payload)
		   
		
		.when()
		  .put(Routes.update_url);
		
		  return response;
	}
	
	public static Response DeleteUser(String username) 
	{
		
		Response response = given()
		   .pathParam("username", username)
		   
		
		.when()
		  .delete(Routes.delete_url);
		
		  return response;
	}
}
