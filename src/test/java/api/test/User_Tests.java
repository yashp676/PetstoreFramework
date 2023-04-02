package api.test;



import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.Endpoints.User_Endpoints;
import api.Payload.User;
import io.restassured.response.Response;

public class User_Tests {
    Faker faker;
	User userPayload;
	public Logger logger;
	
	@BeforeClass
	public void setupData() {
		
		faker=new Faker();
		userPayload=new User();
		
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		// logs
		
		logger=LogManager.getLogger(this.getClass());
        		
	
	}
	@Test(priority = 1)
	public void testPostUser() {
	   logger.info("**********user created*********"); 
		Response response = User_Endpoints.CreateUser(userPayload);
		response.then().log().all();
	Assert.assertEquals(response.getStatusCode(),200);
	
	}
	

         @Test(priority =2)
         public void testGetUserByName() 
         {
	          Response response = User_Endpoints.ReadUser(this.userPayload.getUsername());
	          response.then().log().all();
	          Assert.assertEquals(response.getStatusCode(),200);
	          
         }
         
         @Test(priority = 3)
         public void updateUser() {
        	 
        	 //update data using payload
        		userPayload.setFirstname(faker.name().firstName());
        		userPayload.setLastname(faker.name().lastName());
        		userPayload.setEmail(faker.internet().safeEmailAddress());	 
        		Response response = User_Endpoints.UpdateUser(this.userPayload.getUsername(),userPayload);
        		response.then().log().all();
        	Assert.assertEquals(response.getStatusCode(),200);    	 
        
         //read user 
        	Response responseAfterUpdate = User_Endpoints.CreateUser(userPayload);
    		response.then().log().all();
    	Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);
         
         }
        @Test(priority = 4)
        public void TestdeleteUser() {
        	logger.info("******user deleted******");
        	Response response = User_Endpoints.DeleteUser(this.userPayload.getUsername());
        Assert.assertEquals(response.getStatusCode(),200);
        }



}