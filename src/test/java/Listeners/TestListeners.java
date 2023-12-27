package Listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resource.Base;
import resource.Extentreport;

public class TestListeners extends Base implements ITestListener{
	WebDriver driver=null;
	ExtentReports extentreporter = Extentreport.getExtentreport();
	ExtentTest extenttest;

	@Override
	public void onTestSuccess(ITestResult result) {
		extenttest.log(Status.PASS, result.getName()+"Test passed");

		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testMethodName =result.getName();
		extenttest.fail(result.getThrowable());
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			takrscreenshot(testMethodName,driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	

	@Override
	public void onTestStart(ITestResult result) {
	   extenttest = extentreporter.createTest(result.getName()+"excution started");
	}

	@Override
	public void onFinish(ITestContext context) {
		extentreporter.flush();
		
	}
	
	  

}
