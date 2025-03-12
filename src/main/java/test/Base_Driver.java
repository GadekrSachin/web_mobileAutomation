package test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Base_Driver {
	
	public static WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

	public WebDriver initializedDriver(String browser)  {

		if (browser.equalsIgnoreCase("chrome")) {
//            WebDriverManager.chromedriver().setup();

			System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver-124.exe");
			ChromeOptions options = new ChromeOptions();
			// Set binary if needed (optional)
			options.setBinary("C:\\Selenium WebDriver\\chrome-browser-124-win64\\chrome.exe");
			driver = new ChromeDriver(options);
			tdriver.set(driver);

		} else if (browser.equalsIgnoreCase("firefox")) {
//            WebDriverManager.firefoxdriver().setup();		
			WebDriver driver = new FirefoxDriver();
			tdriver.set(driver);

		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriver driver = new EdgeDriver();
			tdriver.set(driver);

		} else if (browser.equalsIgnoreCase("mobileweb")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("platformName", "Android");
			caps.setCapability("deviceName", "emulator-5554");
			caps.setCapability("browserName", "Chrome");
			caps.setCapability("automationName", "UiAutomator2"); 
			String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/Driver/chromedriver-124.exe";
			caps.setCapability("chromedriverExecutable", chromeDriverPath);
			System.out.println("Starting Mobile web Automation...");


			try {
				driver = new AndroidDriver(new URL("http://localhost:4723"), caps);
			} catch (MalformedURLException e) { 
				e.printStackTrace();
			}
			tdriver.set(driver);

		} else {
			throw new IllegalArgumentException(browser + " is an unsupported browser!");
		}
		return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}

	public static void main(String[] args)  {
	

	}
}
