package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HotelSearchPage;
import pages.HotelSearchResultsPage;

public class HotelSearchTest {
	
	@BeforeTest
	public void init() {
		TestBase.setUp();
		TestBase.launchBrowser();
	}
	
	@Test
	public void searchHotelTest() {
		HotelSearchPage hsp = new HotelSearchPage();
		HotelSearchResultsPage hsrp = hsp.searchHotel("Delhi", "Jul 21, 2021", "Jul 26, 2021");
		String title = hsrp.fetchTitle();
		System.out.println(title);
		Assert.assertTrue(title.contains("Hyderabad"));
	}
	
	@AfterTest
	public void tearDown() {
		TestBase.closeBrowser();
	}

}
