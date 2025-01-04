package parameterization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.TestDataProvider;

public class LoginRegressionTest {
	 private WebDriver driver;

	    @BeforeClass
	    public void setup() {
	        
	        driver = new ChromeDriver();
	        driver.get("https://opensource-demo.orangehrmlive.com\\");
	        driver.manage().window().maximize();
	    }

	    @Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class)
	    public void testLogin(String username, String password) {
	        WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
	        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
	        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

	        // Clear fields before entering data
	        usernameField.clear();
	        passwordField.clear();

	        // Enter username and password
	        usernameField.sendKeys(username);
	        passwordField.sendKeys(password);

	        // Click login button
	        loginButton.click();
	        
	     // Wait for the page to load and check if the error message is displayed for invalid credentials
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
	        WebElement errorMessage = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Invalid credentials']")));
	        
	     // Check if error message appears for invalid credentials and fail the test if it does
	        if (errorMessage.isDisplayed()) {
	            Assert.fail("Login failed: Invalid credentials error message is displayed.");
	        }

	        // Validation for valid credentials (Admin, admin123)
	        if (username.equals("Admin") && password.equals("admin123")) {
	        	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	            WebElement dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
	            Assert.assertTrue(dashboard.isDisplayed(), "Dashboard is not displayed for valid credentials.");

	            // Check the URL after login for successful login
	            String currentUrl = driver.getCurrentUrl();
	            Assert.assertEquals(currentUrl, "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index", "URL mismatch after successful login.");
	        }
	    }

	    @AfterClass
	    public void teardown() {
	        driver.quit();

}
}