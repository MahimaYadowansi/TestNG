package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class BasicLogIn {
	@BeforeTest
	public void creatingDBCon()
	{
		System.out.println("creating database connection");
	}
	@AfterTest
	public void closingDBCon()
	{
		System.out.println("closing database connection");
	}
	
	@BeforeMethod
	public void launchBrowser()
	{
		System.out.println("launch browser");
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		System.out.println("close browser");
	}
	@Test(priority=1)
	public void doUserReg()
	{
		System.out.println("Executing registration test");
	}
@Test(priority=2)
	public void doLogIn()
	{
		System.out.println("Executing login test");
		
	}


}
