package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class FlightSearchResultsPage extends TestBase {
	
	@FindBy(css="*[class*='banner-body']")
	private WebElement banner;
	
	public FlightSearchResultsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getBannerText() {
		
		System.out.println(banner.getText().trim());
		return banner.getText().trim();
	}

}
