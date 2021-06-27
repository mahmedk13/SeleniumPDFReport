package extentlisteners;

import java.io.IOException;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import utilities.Utilities;


public class ExtentListeners implements ITestListener {
	
	
	Date d = new Date();
	String reportName = "Extent_"+d.toString().replace(":", "_").replace(" ", "")+".html";
	
	ExtentReports extent = ExtentManager.createInstance("./src/test/resources/reports/"+reportName);
	
	public static ExtentTest test;

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		
			
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String text = "<b>"+"Test Case: "+methodName.toUpperCase()+" PASSED"+"</b>";
		Markup m = MarkupHelper.createLabel(text, ExtentColor.GREEN);
		test.pass(m);
		
		
		
	}

	public void onTestFailure(ITestResult result) {
		
		try {
			Utilities.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			test.fail("<b>"+"<font color="+"red>" +"screenshot of failure"+"</font>"+"</b>", MediaEntityBuilder.createScreenCaptureFromPath(Utilities.screenshotName).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String methodName = result.getMethod().getMethodName();
		String text = "<b>"+"Test Case: "+methodName.toUpperCase()+" FAILED"+"</b>";
		Markup m = MarkupHelper.createLabel(text, ExtentColor.RED);
		test.fail(m);

		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
