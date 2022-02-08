package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class WikipediaSearchPage extends BasePage {
	
	
	
	@FindBy(id="searchInput")
	private WebElement searchBx;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement searchBtn;
	
	public WikipediaSearchPage() 
	{
		PageFactory.initElements(driver, this);

	}
	
	public WikipediaSearchResultPage searchContent(String text) {

		
	
		typeWithEnter(searchBx, text, " search Input field");
		
		return new WikipediaSearchResultPage();
		
		
	}
	
	

}
