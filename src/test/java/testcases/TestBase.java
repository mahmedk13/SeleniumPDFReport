package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import extentlisteners.ExtentListeners;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.DriverManager;

public class TestBase {
	
	
	public WebDriver driver;

	
	public void launchBrowser(String grid, String browser, String url) {
		
		
		if(grid.equalsIgnoreCase("true")) {
			
			DesiredCapabilities caps = null;
			if(browser.equalsIgnoreCase("chrome")) {
				caps = DesiredCapabilities.chrome();
				caps.setBrowserName("chrome");
				caps.setPlatform(Platform.ANY);
			}else if (browser.equalsIgnoreCase("firefox")) {
				caps = DesiredCapabilities.firefox();
				caps.setBrowserName("firefox");
				caps.setPlatform(Platform.ANY);
			}else {
				caps = DesiredCapabilities.internetExplorer();
				caps.setBrowserName("ie");
				caps.setPlatform(Platform.WIN10);
			}
			
			try {
				driver = new RemoteWebDriver(new URL("http://192.168.56.1:4444/wd/hub"), caps);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
				
			
		}else {
			
			if(browser.equalsIgnoreCase("chrome")){
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();	
			}else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}else {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}
			
		}
		
		DriverManager.setWebDriver(driver);
		DriverManager.getDriver().get(url);
		DriverManager.getDriver().manage().window().maximize();
	}
	
	
	public static void closeBrowser() {
		DriverManager.getDriver().quit();
	}

}
