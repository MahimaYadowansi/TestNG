package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class Listeners  implements ITestListener {
	 private WebDriver driver;

	    @Override
	    public void onTestStart(ITestResult result) {
	        System.out.println("Test started: " + result.getName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        System.out.println("Test passed: " + result.getName());
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        System.out.println("Test failed: " + result.getName());
	        // Capture screenshot on test failure
	        
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        System.out.println("Test skipped: " + result.getName());
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        // This method can be used if you care about tests failing within a success percentage
	    }

	    @Override
	    public void onStart(ITestContext context) {
	        System.out.println("Test suite started: " + context.getName());
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        System.out.println("Test suite finished: " + context.getName());
	    }

	    
}
