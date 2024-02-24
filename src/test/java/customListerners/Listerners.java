package customListerners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listerners implements ITestListener
{
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
	System.setProperty("org.uncommons.reportng.escape-output","false");
	System.out.println("Test got fail");
	Reporter.log("<a href=\"C:\\Users\\AMIT\\Pictures\\Screenshots.jpg\"> Screenshot links</a>");
	Reporter.log("<br>");
	Reporter.log("<a href=\"C:\\Users\\AMIT\\Pictures\\Screenshots.jpg\" target=\"_blank\"> <img height =200 width=200 scr=\"C:\\Users\\AMIT\\Pictures\\Screenshots.jpg\" Screenshot links</a>");
	
	System.out.println("take screenshot"+" "+result.getName()); // code of screenshot
}
public void onTestSkipped(ITestResult result)
{
	System.out.println("Test skipped");
}


}
