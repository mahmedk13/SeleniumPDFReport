package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HotelSearchPage;
import pages.HotelSearchResultsPage;
import utilities.DataUtils;
import utilities.DriverManager;

public class HotelSearchTest extends TestBase {
	
	@Parameters({"grid", "browser", "url"})
	@BeforeClass
	public void init(String grid, String browser, String url) {
		//TestBase.setUp();
		launchBrowser(grid, browser, url);
	}
	
	@Test(dataProvider="getData", dataProviderClass=DataUtils.class)
	public void searchHotel(String origin, String checkinDate, String CheckoutDate) {
		HotelSearchPage hsp = new HotelSearchPage();
		HotelSearchResultsPage hsrp = hsp.searchHotel(origin, checkinDate, CheckoutDate);
		String title = DriverManager.getDriver().getTitle();
		System.out.println(title);
		Assert.assertTrue(title.contains("Hyderabad"));
	}
	
	
	@AfterClass
	public void tearDown() {
		closeBrowser();
	}

}
