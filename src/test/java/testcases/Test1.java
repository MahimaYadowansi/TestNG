package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {

	@Test(priority=1,groups="functional")
	public void doUserReg()
	{
		System.out.println("Executing registration test");
		//Assert.fail("User not registered"); //if test fail
	}
@Test(priority=2,groups="functional")  //multiple dependency
	public void doLogIn()
	{
		System.out.println("Executing login test");
	//there is test fail in doUserReg so the dependend test will be skipped	
	}
@Test(priority=3,groups="smoke")
public void thirdTest()
{
	System.out.println("Executing third test");
	
}
@Test(priority=4,groups={"functional","smoke"})
public void fourTest()
{
	System.out.println("Executing fourth test");
	
}
	
}
