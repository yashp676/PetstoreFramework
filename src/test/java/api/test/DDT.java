package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.Endpoints.User_Endpoints;
import api.Payload.User;
import api.Utilities.DataProviders;
import io.restassured.response.Response;

public class DDT {

	
	@Test(priority = 1,dataProvider = "Data",dataProviderClass =DataProviders.class )
	public void testpostUser(String userID, String userName, String fname, String lname, String useremail, String pwd, String ph) {
          	
		User userPayload= new User();
		  userPayload.setId(Integer.parseInt(userID));
		  userPayload.setUsername(userName);
		  userPayload.setFirstname(fname);
		  userPayload.setLastname(lname);
		  userPayload.setEmail(useremail);
		  userPayload.setPassword(pwd);
		  userPayload.setPhone(ph);
		  
			Response response = User_Endpoints.CreateUser(userPayload);
		Assert.assertEquals(response.getStatusCode(),200);
		
		}
        
	      @Test(priority = 2,dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	     public void testDeleteUserByName(String userName) {
            
	    	  Response response = User_Endpoints.DeleteUser(userName);
	    	  Assert.assertEquals(response.getStatusCode(),200);
	     }
	}

