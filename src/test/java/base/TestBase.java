package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

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
	}
	
	public static void closeBrowser() {
		driver.close();
	}

}
