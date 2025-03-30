package Hooks;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.pages.ConfigManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import test.Base_Driver;

public class Application_hooks {

	Base_Driver basedriver;
	WebDriver driver;
	Properties props = ConfigManager.getProperties();

//	Properties prop;

	public Properties getBrowserName() {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/driver_confi/confii.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	@Before(order = 0)
	public void launch_browser() {

		String browserName = props.getProperty("browsername");
		basedriver = new Base_Driver();

	//	if(browserName.equalsIgnoreCase("mobileweb")) {
//			driver = basedriver.initializedDriver(browserName);
//		} else {
//
//			String resolution = props.getProperty("Base_Resolution");
//
//
//			if (resolution.equalsIgnoreCase(props.getProperty("Mobile_resolution"))) {
//				basedriver.driver.manage().window().setSize(new org.openqa.selenium.Dimension(400, 750));
//			} else {
//				basedriver.driver.manage().window().maximize();
//			}
//
//			basedriver.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
//		}

		driver = basedriver.initializedDriver(browserName);

		if (!browserName.equalsIgnoreCase("mobileweb")) {

		    String resolution = props.getProperty("Base_Resolution");

		    if (resolution.equalsIgnoreCase(props.getProperty("Mobile_resolution"))) {
		        driver.manage().window().setSize(new org.openqa.selenium.Dimension(400, 750));
		    } else {
		        driver.manage().window().maximize();
		    }

		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}

		Base_Driver.driver.get(props.getProperty("WebUrl"));
	}

	@After
	public void quitebrowser() {
		Base_Driver.driver.close();
	}

}
