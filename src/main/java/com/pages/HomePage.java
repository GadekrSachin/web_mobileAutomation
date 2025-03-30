package com.pages;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
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




	public HomePage(WebDriver webDriver) {
		this.driver = (RemoteWebDriver) webDriver;
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

		System.out.println("data 1");
		 WebElement source = Base_Driver.driver.findElement(By.xpath("//i[@class=\"ri-newspaper-line\"]"));
	     WebElement target = Base_Driver.driver.findElement(By.xpath("(//tr[@class=\"MuiTableRow-root time-slot-wrapper css-hnhery\"])[57]"));
			System.out.println("data 2");

	     Common.dragAndDrop(Base_Driver.driver, source, target);
	}

}
