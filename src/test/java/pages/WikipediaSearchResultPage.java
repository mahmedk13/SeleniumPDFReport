package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaSearchResultPage extends BasePage {

	@FindBy(id="firstHeading")
	private WebElement heading;
	
	public WikipediaSearchResultPage() 
	{
		PageFactory.initElements(driver, this);

	}
	
	public String getHeading() {
		return heading.getText().trim();
	}

}
