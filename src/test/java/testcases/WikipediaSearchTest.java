package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import extentlisteners.JyperionListener;
import pages.WikipediaSearchPage;
import pages.WikipediaSearchResultPage;

@Listeners(JyperionListener.class)

public class WikipediaSearchTest extends TestBase{
	

	@Parameters({"browser", "url"})
	@BeforeTest
	public void init(String browser, String url) {
		//TestBase.setUp();
		launchBrowser(browser, url);
	}
	
	@Test
	public void searchText() {
		
		WikipediaSearchPage page = new WikipediaSearchPage();
		WikipediaSearchResultPage wsrp = page.searchContent("India");
		String heading = wsrp.getHeading();
		System.out.println(heading);
		AssertJUnit.assertEquals(heading, "India");
	}
	
	
	
	@AfterMethod
	@AfterTest
	public void tearDown() {
		closeBrowser();
	}
	
	
	

}
