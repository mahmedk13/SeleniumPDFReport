package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.TestBase;

public class Utilities extends TestBase {
	
	public static String screenshotName;
	
	public static void captureScreenshot() throws IOException {
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		Date d = new Date();
		System.out.println(d);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyyhh:mm:ss");
		String time = sdf.format(d).replace(":", "_");
		screenshotName = "screenshot_"+time+".jpg";
		
		FileUtils.copyFile(scrFile, new File("./src/test/resources/reports/"+screenshotName));
		
		
		
		
	}

}
