package reRunFailedTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin {
	@Test(priority=1)
	public void doLogin()
	{
		System.out.println("Successfull login");	}
	static int count=0;
@Test(priority=2)
public void registerUser()

{
	count++;
	System.out.println("count: "+count);
	Assert.fail("Execution failed for registration");
}
}