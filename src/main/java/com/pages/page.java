package com.pages;
 
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import test.Base_Driver;

public class page {

	WebDriver driver;
//	Base_Driver base = new Base_Driver();

	Properties props = ConfigManager.getProperties();
	
 	//loginPage elements 	
		private By loginbutton = By.xpath("//button[text()='Continue']");
		private By email_id = By.xpath("//input[@inputmode=\"email\"]");
		private By password_field = By.xpath("//input[@name=\"password\"]");
		private By invalid_text = By.xpath("//span[@id=\"error-element-password\"]");


	public page(WebDriver driver) {
		this.driver = driver;
	}

	
 	public void user_provide_and(String username, String password) {
 		Base_Driver.driver.findElement(email_id).sendKeys(username);
 		Base_Driver.driver.findElement(password_field).sendKeys(password);
 		Base_Driver.driver.findElement(loginbutton).click();
 				 
	}
 	
 	public void user_provide_invalid_and(String username, String password) {
 		Base_Driver.driver.findElement(email_id).sendKeys(username);
 		Base_Driver.driver.findElement(password_field).sendKeys(password);
 		Base_Driver.driver.findElement(loginbutton).click();
 	  	String Invalid_text = Base_Driver.driver.findElement(invalid_text).getText();
 		assertEquals(Invalid_text, props.getProperty("Invalid_error"));
 		
 		Base_Driver.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
 		
	}
 	
 	

}
