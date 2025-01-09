package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestInvocationCount {
	@Test(invocationCount=5, threadPoolSize=5) //threadpoolsize launch all  5 browser at same time
	public void executeTest()
	{
		WebDriver driver=new ChromeDriver();
		System.out.println("Launching chrome browser");
		driver.quit();
	}

}
