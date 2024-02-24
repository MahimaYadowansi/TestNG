package parameterization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicTest {
	@Test(dataProvider="loginData", dataProviderClass=ParameterTestFromExcel.class)
	public void TestLogin(String username,String password) throws Exception {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com");
	driver.findElement(By.id("txtUsername")).sendKeys("username");
	driver.findElement(By.id("txtPassword")).sendKeys("password");
	driver.findElement(By.id("btnLogin")).click();
	Assert.assertTrue(driver.findElement(By.id("welcome")).isDisplayed());
	Thread.sleep(5000);
	driver.quit();
	}
	
}
