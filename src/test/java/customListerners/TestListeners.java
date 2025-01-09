package customListerners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utilities.Screenshot;

public class TestListeners extends BaseTest implements ITestListener{
	
	public void onTestStart(ITestResult result)
	{
		System.out.println("Test execution started");
	}
	public void onFinish(ITestContext context)
	{
		System.out.println("Test execution ended");
	}

	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Test success"+result.getName());
	}
	public void onTestFailure(ITestResult result)
	{
	
    String screenshotName = result.getName() + "_failure"; // Use test method name or any other string as the name
    Screenshot.takeScreenshot(driver, screenshotName);
	}
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("Test skipped");
	}
	
	

}
