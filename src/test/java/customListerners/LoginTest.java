package customListerners;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest  {
	@Test
	public void doLogin()
	{
		 
	        // Enter username and password
	        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admins");
	        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("gffgd");
	        driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
		
}

