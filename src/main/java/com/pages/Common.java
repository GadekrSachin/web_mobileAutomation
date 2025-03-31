package com.pages;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import test.Base_Driver;


public class Common {

	Base_Driver basedriver = new Base_Driver();
	  WebDriver driver;
	Properties props = ConfigManager.getProperties();
	page loginpage = new page(Base_Driver.getDriver());



	// Moduleelement
	private By Sale_Module = By.xpath("//i[@class=\"ri-price-tag-3-fill\"]");
	private By Appointment_Module = By.xpath("//i[@class=\"ri-calendar-fill\"]");
	private By Client_Module = By.xpath("//i[@class=\"ri-user-fill\"]");
	private By Catalog_Module = By.xpath("//i[@class=\"ri-book-open-fill\"]");
	private By Catalog_Module_mobile = By.xpath("(//i[@class=\"ri-book-open-fill\"])[2]");
	private By Marketing_Module = By.xpath("//i[@class=\"ri-focus-fill\"]");
	private By Team_Module = By.xpath("//i[@class=\"ri-team-fill\"]");
	private By Report_Module = By.xpath("//i[@class=\"ri-line-chart-line\"]");
	private By Notification_Module = By.xpath("//i[@class=\"ri-notification-fill\"]");
	private By Setting_Module = By.xpath("//i[@class=\"ri-settings-2-fill\"]");
	private By Logout_Module = By.xpath("//i[@class=\"ri-logout-box-r-line\"]");
	private By Profile_Module = By.xpath("(//div[@class=\"MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault user-avatar css-el22pw\"])[1]");

//	catalog module
	private By Service_Menu = By.xpath("//button[@id=\"simple-tab-0\"]");
	private By Product = By.xpath("//button[@id=\"simple-tab-1\"]");
	private By Consulting_Module = By.xpath("//button[@id=\"simple-tab-2\"]");
	private By Gift_Menu = By.xpath("//button[@id=\"simple-tab-3\"]");






	@Given("user on Home page")
	public void user_on_home_page() {
	    loginpage.user_provide_and(props.getProperty("login_id"), props.getProperty("Password"));
	    System.out.println("data");
	}


	public void Upto_AllModule(String moduleName) throws InterruptedException  {

		Base_Driver.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8000));

		if (moduleName.equalsIgnoreCase("appointment")) {
			Base_Driver.driver.findElement(Appointment_Module).click();
		} else if (moduleName.equalsIgnoreCase("sales")) {
			Base_Driver.driver.findElement(Sale_Module).click();
		} else if (moduleName.equalsIgnoreCase("client")) {
			Base_Driver.driver.findElement(Client_Module).click();
		} else if (moduleName.equalsIgnoreCase("catalog")) {

			if(props.getProperty("Base_Resolution").equals(props.getProperty("Mobile_resolution")  )  ) {
				Base_Driver.driver.findElement(Catalog_Module_mobile).click();
			}else {
				Thread.sleep(3000);
				Base_Driver.driver.findElement(Catalog_Module).click();
			}

		} else if (moduleName.equalsIgnoreCase("marketing")) {
			Base_Driver.driver.findElement(Marketing_Module).click();
		} else if (moduleName.equalsIgnoreCase("team")) {
			Base_Driver.driver.findElement(Team_Module).click();
		} else if (moduleName.equalsIgnoreCase("reports")) {
			Base_Driver.driver.findElement(Report_Module).click();
		} else if (moduleName.equalsIgnoreCase("notification")) {
			Base_Driver.driver.findElement(Notification_Module).click();
		} else if (moduleName.equalsIgnoreCase("setting")) {
			Base_Driver.driver.findElement(Setting_Module).click();
		} else if (moduleName.equalsIgnoreCase("logout")) {
			Base_Driver.driver.findElement(Logout_Module).click();
		} else if (moduleName.equalsIgnoreCase("profile")) {
			Base_Driver.driver.findElement(Profile_Module).click();
		} else {
			System.out.println("Invalid module name: " + moduleName);
		}
	}


		public void Catalog_submodule(String Submodule)  {

			Base_Driver.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

			if (Submodule.equalsIgnoreCase("service menu")) {
				Base_Driver.driver.findElement(Service_Menu).click();
			} else if (Submodule.equalsIgnoreCase("product")) {
				Base_Driver.driver.findElement(Product).click();
			}else if (Submodule.equalsIgnoreCase("consulting form")) {
				Base_Driver.driver.findElement(Consulting_Module).click();
			}else if (Submodule.equalsIgnoreCase("giftmenu")) {
				Base_Driver.driver.findElement(Gift_Menu).click();
			}


			else {
				System.out.println("Invalid module name: " + Submodule);
			}
			}



		public void scrollUsingUiScrollable(WebDriver driver2, By elementLocator) {
		    try {
		        WebElement element = driver2.findElement(elementLocator);
		        driver2.findElement(AppiumBy.androidUIAutomator(
		            "new UiScrollable(new UiSelector().scrollable(true))" +
		            ".scrollIntoView(new UiSelector().description(\"" + element.getAttribute("content-desc") + "\"))"
		        ));
		    } catch (Exception e) {
		        System.out.println(" Element not found: " + e.getMessage());
		    }
		}

		public static void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
	        if (driver instanceof AndroidDriver) {
	            performMobileDragAndDrop((AndroidDriver) driver, source, target);
	        } else {
	            performWebDragAndDrop(driver, source, target);
	        }
	    }

	    public static void performWebDragAndDrop(WebDriver driver, WebElement source, WebElement target) {
	        Actions actions = new Actions(driver);
	        int xOffset = target.getLocation().getX() - source.getLocation().getX();
	        int yOffset = target.getLocation().getY() - source.getLocation().getY();

	        // Perform drag and drop using offset
	        actions.clickAndHold(source)
	               .pause(Duration.ofSeconds(1))  // Small delay for stability
	               .moveByOffset(xOffset, yOffset)  // Move to the exact position
	               .pause(Duration.ofSeconds(1))
	               .release()
	               .perform();
	        System.out.println("Drag and drop performed for Web");
	    }


	    public static void performMobileDragAndDrop(AndroidDriver driver, WebElement source, WebElement target) {
	    	System.out.println("mobile auto");
	    	int startX = source.getLocation().getX() + (source.getSize().getWidth() / 2);
	        int startY = source.getLocation().getY() + (source.getSize().getHeight() / 2);
	        int endX = target.getLocation().getX() + (target.getSize().getWidth() / 2);
	        int endY = target.getLocation().getY() + (target.getSize().getHeight() / 2);


	        System.out.println("startX"+ startX);
	        System.out.println("starty"+ startY);
	        System.out.println("endX"+ endX);
	        System.out.println("endy"+ endY);




	        // Create PointerInput for touch actions
	        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	        Sequence sequence = new Sequence(finger, 0);

	        // Press (Touch)
	        sequence.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
	        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	        sequence.addAction(new Pause(finger, Duration.ofMillis(2000)));
	        // Move
	        sequence.addAction(finger.createPointerMove(Duration.ofMillis(2000), PointerInput.Origin.viewport(), endX, endY));

	        // Release (Lift finger)
	        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	        // Perform the action
	        driver.perform(Collections.singletonList(sequence));



	    }

	    private  static void performMobileTouchDragAndDrop(AndroidDriver driver, WebElement source, WebElement target) {
	    	System.out.println("mobile auto2");
	    	int startX = source.getLocation().getX() + (source.getSize().getWidth() / 2);
	        int startY = source.getLocation().getY() + (source.getSize().getHeight() / 2);
	        int endX = target.getLocation().getX() + (target.getSize().getWidth() / 2);
	        int endY = target.getLocation().getY() + (target.getSize().getHeight() / 2);

	        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	        Sequence sequence = new Sequence(finger, 0);

	        sequence.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
	        sequence.addAction(finger.createPointerDown(0));
	        sequence.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY));
	        sequence.addAction(finger.createPointerUp(0));

	        driver.perform(Arrays.asList(sequence));
	        System.out.println("✅ Drag and drop performed using Touch Gestures for Mobile Web");
	    }
}



