package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ValidationTest {
@Test
	public void validateTitle()
	{
	System.out.println("Begining");
	
		String expected_title="yahoo.com"; //got from excel sheet
		String actual_title="Gmail.com"; //got from selenium
		//never use if condition here always use class called ASSERTION
		//use assertion to report a failure
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actual_title, expected_title);
		
		//to find isElementPresent("xpath")--true,false
		SoftAssert softAssert2 = new SoftAssert();
		softAssert2.assertTrue(false, "Element not found");
		
		//wants to forcefully fail a test
	//	Assert.fail("test fail as condition not statisfied");
		
		SoftAssert softAssert3 = new SoftAssert();
		softAssert3.assertEquals(true, false);
		
		System.out.println("Ending");
		SoftAssert softAssert4 = new SoftAssert();
		softAssert4.assertAll();
	}

}
