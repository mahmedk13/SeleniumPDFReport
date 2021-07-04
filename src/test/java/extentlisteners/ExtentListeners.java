package extentlisteners;

import java.io.IOException;
import java.util.Arrays;
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



public class ExtentListeners implements ITestListener {
	
	
	Date d = new Date();
	String reportName = "Extent_"+d.toString().replace(":", "_").replace(" ", "")+".html";
	
	ExtentReports extent = ExtentManager.createInstance("./src/test/resources/reports/"+reportName);
	
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		testReport.set(test);
		
			
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String text = "<b>"+"Test Case: "+methodName.toUpperCase()+" PASSED"+"</b>";
		Markup m = MarkupHelper.createLabel(text, ExtentColor.GREEN);
		testReport.get().pass(m);
		
		
		
	}

	public void onTestFailure(ITestResult result) {
		
		
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		
		testReport.get().fail("<details>"+"<summary>"+"<b>"+"Exception occured: Click here to see"+"</b>"+"</summary>"
		+exceptionMessage.replace(",", "<br>")+"</details>"+"\n");
		
		ExtentManager.captureScreenshot();
		
		
		
		try {
			testReport.get().fail("<b>"+"<font color="+"red>" +"screenshot of failure"+"</font>"+"</b>", MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String methodName = result.getMethod().getMethodName();
		String text = "<b>"+"Test Case: "+methodName.toUpperCase()+" FAILED"+"</b>";
		Markup m = MarkupHelper.createLabel(text, ExtentColor.RED);
		testReport.get().fail(m);

		
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
