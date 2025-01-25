package listner;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.inetbanking.testcases.BaseClass;
import com.inetbanking.utilities.ExtentReporter;
import com.inetbanking.utilities.ScreenShot;

public class Listner extends BaseClass implements ITestListener{
  //  WebDriver driver;
	ExtentReports extentReport=ExtentReporter.getExtentReports();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest>extentTestThread=new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		extentTest=extentReport.createTest(result.getName());
		extentTestThread.set(extentTest);
	}

	public void onTestSuccess(ITestResult result) {
		extentTestThread.get().log(Status.PASS, result.getName()+"Passed successfully..");
	}

	public void onTestFailure(ITestResult testResult) {
		extentTestThread.get().fail(testResult.getThrowable());
		extentTestThread.get().log(Status.FAIL, testResult.getName()+"Test Case got failed");
	//	     driver=null;
			String testName=testResult.getName();
	        String screenShotFilePath=ScreenShot.getScreenShot(driver,testName);
			 try {
				extentTestThread.get().addScreenCaptureFromPath(screenShotFilePath, testName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void onTestSkipped(ITestResult result) {
		extentTestThread.get().log(Status.SKIP, "Test Cases Skipeed succesffully..");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		extentReport.flush();
	}

}
