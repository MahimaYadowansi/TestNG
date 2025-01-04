package parameterization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BasicTest {
	@Test(dataProvider="loginData", dataProviderClass=ParameterTestFromExcel.class)
	public void TestLogin(String username, String password) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com");

        // Enter username and password
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Wait for error message in case of invalid credentials
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            // Check for error message if credentials are invalid
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Invalid credentials']")));
            if (errorMessage.isDisplayed()) {
                System.out.println("Invalid credentials for username: " + username + " and password: " + password);
                driver.quit(); // Close the browser for invalid credentials
                return; // Move to the next data set
            }
        } catch (Exception e) {
            // If error message is not found, proceed with the valid credentials check
        }

        // Validation for valid credentials (Admin, admin123)
        if (username.equals("Admin") && password.equals("admin123")) {
            WebElement dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
            Assert.assertTrue(dashboard.isDisplayed(), "Dashboard is not displayed for valid credentials.");
        }

        // Close the browser after processing the data set
        driver.quit();
	}
}
