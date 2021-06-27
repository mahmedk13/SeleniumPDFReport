package base;

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

public class TestBase {
	
	
	public static WebDriver driver=null;
	public static Properties config = new Properties();
	public static FileInputStream fis = null;

	
	public static void setUp() {
		try {
			
			fis = new FileInputStream("./src/test/resources/ConfigFiles/config.properties");
			config.load(fis);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void launchBrowser() {
			
		if(config.getProperty("browser").equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		}else if(config.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		driver.get(config.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	
	public void click(WebElement ele, String elementName) {
		ele.click();
		ExtentListeners.test.info("Clicking on "+elementName);
		
	}
	
	public void type(WebElement ele, String value, String elementName) {
		ele.sendKeys(value);
		ExtentListeners.test.info("Entering " +value+ " in "+elementName);
	}
	
	public void typeWithEnter(WebElement ele, String value, String elementName) {
		ele.sendKeys(value, Keys.ENTER);
		ExtentListeners.test.info("Entering " +value+ " in "+elementName);
	}
	
	public String fetchTitle() {
		String title = driver.getTitle();
		ExtentListeners.test.info("Title of the webpage is "+title);
		return title;

		
	}
	
	
	public static void closeBrowser() {
		driver.close();
	}

}
