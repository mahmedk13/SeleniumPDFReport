package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import extentlisteners.ExtentListeners;
import io.github.bonigarcia.wdm.WebDriverManager;
import testcases.TestBase;
import utilities.DriverManager;

public class BasePage {
	
	
	
	public WebDriver driver;
	public static Properties config = new Properties();
	public static FileInputStream fis = null;
	
	public BasePage() {
		this.driver = DriverManager.getDriver();
	}

	
	public static void setUp() {
		try {
			
			fis = new FileInputStream("./src/test/resources/ConfigFiles/config.properties");
			config.load(fis);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void click(WebElement ele, String elementName) {
		ele.click();
		ExtentListeners.testReport.get().info("Clicking on "+elementName);
		
	}
	
	public void type(WebElement ele, String value, String elementName) {
		ele.sendKeys(value);
		ExtentListeners.testReport.get().info("Entering " +value+ " in "+elementName);
	}
	
	public void typeWithEnter(WebElement ele, String value, String elementName) {
		ele.sendKeys(value, Keys.ENTER);
		ExtentListeners.testReport.get().info("Entering " +value+ " in "+elementName);
	}
	
	
	
	
	
}
