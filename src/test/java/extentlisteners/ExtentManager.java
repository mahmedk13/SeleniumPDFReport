package extentlisteners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utilities.DriverManager;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports createInstance(String fileName) {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("My project execution report");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Regression Suite");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Windows", "version 10");
		extent.setSystemInfo("Automation Team", "My Team");
		
		
		
		return extent;		
		
	}
	
	public static String screenshotName;
	
	public static void captureScreenshot() {
		
		TakesScreenshot scrShot =((TakesScreenshot)DriverManager.getDriver());

		File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
		
		Date d = new Date();
		screenshotName= "screenshot"+d.toString().replace(":", "_").replace(" " , "_")+".jpg";
		
		try {
			FileUtils.copyFile(scrFile, new File("./src/test/resources/reports/"+screenshotName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
