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
import org.testng.annotations.Test;

import base.TestBase;
import pages.FlightSearchPage;
import pages.FlightSearchResultsPage;
import pages.HomePage;
import utilities.DataUtils;

public class FlightSearchTest {
	

	
	@BeforeClass
	public void init() {
		TestBase.setUp();
		TestBase.launchBrowser();
	}
	
	@Test(dataProvider="getData", dataProviderClass=DataUtils.class)
	public void searchFlight(String origin, String destination, String checkinDate, String CheckoutDate) {

		HomePage hp = new HomePage();
		FlightSearchPage fsp = hp.navigateToFlightSearchPage();
		FlightSearchResultsPage fsrp = fsp.searchFlight(origin, destination, checkinDate, CheckoutDate);
		String text = fsrp.getBannerText();
		Assert.assertTrue(text.contains("COVID-19 alert: Travel requirements are changing rapidly"));	
	}
	
	
	
	@AfterClass
	public void tearDown() {
		TestBase.closeBrowser();
	}
	
	
	

}
