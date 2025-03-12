package Step_def;
 
 	
import com.pages.page;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import test.Base_Driver;

public class loginstepdef {
	Base_Driver basedriver = new Base_Driver();
	
	page loginuser = new page(Base_Driver.getDriver());
	
	
	
	
	@Given("user on login page")
	public void user_on_login_page() { 
		System.out.println("all set ...");
	}	
	
	@When("user provide {string} and {string}")
	public void user_provide_and(String username, String password) throws InterruptedException {
	    loginuser.user_provide_and(username, password);
	    Thread.sleep(5000);
	}	
	
	@When("user provide invalid {string} and {string}")
	public void user_provide_invalid_and(String username, String password) {
	     loginuser.user_provide_invalid_and(username, password);
	     
	    
	}
	
}
