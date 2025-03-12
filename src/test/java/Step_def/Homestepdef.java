package Step_def;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import com.pages.ConfigManager;
import com.pages.HomePage;
import com.pages.page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import test.Base_Driver;

public class Homestepdef {

	Base_Driver basedriver = new Base_Driver();
	WebDriver driver;
	Properties props = ConfigManager.getProperties();
	page loginpage = new page(Base_Driver.getDriver());
	HomePage home = new HomePage(Base_Driver.getDriver());
	
	
	
	
	
	@Given("user on Home page")
	public void user_on_home_page() {
		loginpage.user_provide_and(props.getProperty("login_id"), props.getProperty("Password"));
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			 
			e.printStackTrace();
		}
	}

	@When("verify red line")
	public void verify_red_line() { 
		home.verify_red_line();
	}
	 
	@When("drag and drop functionality")
	public void drag_and_drop_functionality() throws InterruptedException {
	    home.drag_and_drop_functionality();
	    Thread.sleep(8000);
	}
	
	
	
}
