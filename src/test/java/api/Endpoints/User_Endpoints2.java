package api.Endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.Payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//Having CRUD Operations
public class User_Endpoints2 {

	static ResourceBundle getURL()
	{
	
	ResourceBundle routes=ResourceBundle.getBundle("routes");
	return routes;
	
	}
	
	public static Response CreateUser(User payload) 
	{
	  String post_url=getURL().getString("post_url");	
		Response response = given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		
		.when()
		  .post(post_url);
		
		  return response;
	}
	
	public static Response ReadUser(String username) 
	{
		String read_user = getURL().getString("get_url");
		Response response = given()
		   .pathParam("username", username)
		   
		
		.when()
		  .get(read_user);
		
		  return response;
	}
	
	public static Response UpdateUser(String username,User payload) 
	{
		String update_url = getURL().getString("update_url");
		Response response = given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .pathParam("username",username)
		   .body(payload)
		   
		
		.when()
		  .put(update_url);
		
		  return response;
	}
	
	public static Response DeleteUser(String username) 
	{
		String delete_url = getURL().getString("delete_url");
		Response response = given()
		   .pathParam("username", username)
		   
		
		.when()
		  .delete(delete_url);
		
		  return response;
	}
}
