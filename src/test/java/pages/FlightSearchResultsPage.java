package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FlightSearchResultsPage extends BasePage {
	
	@FindBy(css="*[class*='banner-body']")
	private WebElement banner;
	
	public FlightSearchResultsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getBannerText() {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(banner.getText().trim());
		return banner.getText().trim();
	}

}
