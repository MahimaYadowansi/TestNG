package zipFile_SendAutomatedMail;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
	
	@Test(priority=1)
	public void doLogin(){
		
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("trainer@way2automation.com");
		driver.findElement(By.id("next")).click();
		
	}
	
	@Test(priority=2)
	public void composeEmail(){
		
		Assert.fail("Error in composing Email");
		
	}

}
