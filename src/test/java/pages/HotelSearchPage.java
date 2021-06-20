package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HotelSearchPage extends TestBase {
		
		@FindBy(css="button[data-stid*='location-field-destination']")
		private WebElement destinationBtn;
		
		@FindBy(id="location-field-destination")
		private WebElement destinationInputField;
		
		@FindBy(id="d1-btn")
		private WebElement checkinBtn;
		
		@FindBy(id="d2-btn")
		private WebElement checkoutBtn;
		
		@FindBy(css="button[data-stid=apply-date-picker]")
		private WebElement doneBtn;
		
		@FindBy(css="button[data-testid=submit-button]")
		private WebElement submitBtn;
		
		
		public HotelSearchPage() {
			PageFactory.initElements(driver, this);
		}
		
		
		public HotelSearchResultsPage searchHotel(String destination, String checkinDate, String checkoutDate) {
			
			destinationBtn.click();
			destinationInputField.sendKeys(destination, Keys.ENTER);
			
			checkinBtn.click();
			driver.findElement(By.xpath("//button[@aria-label='"+checkinDate+"']")).click();
			doneBtn.click();
			
			checkoutBtn.click();
			driver.findElement(By.xpath("//button[@aria-label='"+checkoutDate+"']")).click();
			doneBtn.click();
			
			submitBtn.click();
			
			return new HotelSearchResultsPage();
			

			

		}
		
	
		
	}


