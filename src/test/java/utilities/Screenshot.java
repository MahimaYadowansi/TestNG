package utilities;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {

    // Method to take a screenshot
    public static String takeScreenshot(WebDriver driver, String screenshotName) {
        // Generate a timestamp to make the screenshot name unique
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String Screenshotfile = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "_" + timestamp + ".png";

        try {
            // Capture the screenshot
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Create the destination file
            File destinationFile = new File(Screenshotfile);

            // Copy the screenshot to the destination file
            FileUtils.copyFile(sourceFile, destinationFile);

            System.out.println("Screenshot saved at: " + Screenshotfile);
        } catch (IOException e) {
            System.out.println("Error while taking screenshot: " + e.getMessage());
        }

        return Screenshotfile;
    }
}

