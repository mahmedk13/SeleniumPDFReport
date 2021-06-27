package extentlisteners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

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
	
	

}
