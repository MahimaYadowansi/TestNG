package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreatingDependies {
	@Test(priority=1)
	public void doUserReg()
	{
		System.out.println("Executing registration test");
		Assert.fail("User not registered"); //if test fail
	}
@Test(priority=2,dependsOnMethods={"doUserReg","fourTest"})  //multiple dependency
	public void doLogIn()
	{
		System.out.println("Executing login test");
	//there is test fail in doUserReg so the dependend test will be skipped	
	}
@Test(priority=3,dependsOnMethods="doUserReg",alwaysRun=true)
public void thirdTest()
{
	System.out.println("Executing third test");
	
}
@Test(priority=4)
public void fourTest()
{
	System.out.println("Executing fourth test");
	
}
	
}
