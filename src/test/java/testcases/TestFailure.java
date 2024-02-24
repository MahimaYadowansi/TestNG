package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFailure {
	@Test
	public void doLogIn()
	{
		System.out.println("Executing login test");
		Assert.fail("failing the login code");
		System.out.println("capturing screenshot"); // code to take screenshot
		
	}

}
