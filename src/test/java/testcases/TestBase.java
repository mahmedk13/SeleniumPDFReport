package testcases;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	
	public static WebDriver driver;

	
	public void launchBrowser(String browser, String url) {
		
		
		
			
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
			
			driver.get(url);
			driver.manage().window().maximize();
			
		
		
		
	}
	
	
	public static void closeBrowser() {
		driver.quit();
		
	}

}
