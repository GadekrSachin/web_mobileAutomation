package com.pages;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import test.Base_Driver;

public class HomePage {

	WebDriver driver;

	Properties props = ConfigManager.getProperties();
	Common common= new Common();

	// HomePage elements
	private By red_line = By.xpath("//span[@class=\"MuiTypography-root MuiTypography-body1 css-1w22uhs\"]");
	private By ele = By.xpath("\r\n"
			+ " //android.widget.FrameLayout[@content-desc=\"Web View\"]");
	
	
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void verify_red_line() {
		Base_Driver.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String red_text = Base_Driver.driver.findElement(red_line).getText().trim();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
		String currentTime = LocalTime.now().format(formatter);
		Assert.assertEquals(red_text, currentTime);
		System.out.println(" time mmatched Test Pass");

	}

	public void drag_and_drop_functionality() {  
		common.scrollUsingUiScrollable(  driver , ele);		
	}

}
