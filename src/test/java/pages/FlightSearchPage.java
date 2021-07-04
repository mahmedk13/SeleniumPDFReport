package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FlightSearchPage extends BasePage {
	
	//shortcut for multiple import is ctrl+shift+O
	@FindBy(css="button[data-stid=location-field-leg1-origin-menu-trigger]")
	private WebElement originField;
	
	@FindBy(id="location-field-leg1-origin")
	private WebElement originTxtbx;
	
	@FindBy(css="button[data-stid=location-field-leg1-destination-menu-trigger]")
	private WebElement destinationField;
	
	@FindBy(id="location-field-leg1-destination")
	private WebElement destinationTxtbx;
	
	@FindBy(id="d1-btn")
	private WebElement checkinBtn;
	
	@FindBy(id="d2-btn")
	private WebElement checkoutBtn;
	
	@FindBy(css="button[data-stid=apply-date-picker]")
	private WebElement doneBtn;
	
	@FindBy(css="button[data-testid=submit-button]")
	private WebElement submitBtn;
	
	public FlightSearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	public FlightSearchResultsPage searchFlight(String origin, String destination, String checkinDate, String checkoutDate ) {
		
		WebDriverWait wait = new WebDriverWait(driver, 5);

		
		//originField.click();
		click(originField, "Origin Field Button");
		
		
		//originTxtbx.sendKeys(origin, Keys.ENTER);
		typeWithEnter(originTxtbx, origin, " Origin Input field");
		
		//destinationField.click();
		click(destinationField, "Destination Field Button");
		
		//destinationTxtbx.sendKeys(destination, Keys.ENTER);
		typeWithEnter(destinationTxtbx, destination, " Destination Input field");
		
		//checkinBtn.click();
		click(checkinBtn, "Checkin Calendar Button");
		
		
		//driver.findElement(By.xpath("//button[@aria-label='"+checkinDate+"']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='"+checkinDate+"']")));
		click(driver.findElement(By.xpath("//button[@aria-label='"+checkinDate+"']")), "Checkin Date: "+checkinDate);
		
		
		//doneBtn.click();
		click(doneBtn, "Done Button of Checkin Calendar");
		
		//checkoutBtn.click();
		click(checkoutBtn, "Checkout Calendar Button");
		
		//driver.findElement(By.xpath("//button[@aria-label='"+checkoutDate+"']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='"+checkoutDate+"']")));
		click(driver.findElement(By.xpath("//button[@aria-label='"+checkoutDate+"']")), "Checkin Date: "+checkoutDate);

		
		//doneBtn.click();
		click(doneBtn, "Done Button of Checkin Calendar");

		
		//submitBtn.click();
		click(submitBtn, "Submit Button");
		
		return new FlightSearchResultsPage();
		
		
	}
	
	

}
