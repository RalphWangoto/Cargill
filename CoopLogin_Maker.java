package testCases;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
import org.testng.annotations.Test;

import baseTest.BaseTest;

public class CoopLogin_Maker extends BaseTest {
	
	public static final String username = "test@ralph.com";
	public static final String password = "123456";
	
	@Test(priority = 1, enabled = true)
	public void login() throws InterruptedException {
        driver.findElement(By.xpath(locators.getProperty("Username"))).sendKeys(username);
        driver.findElement(By.xpath(locators.getProperty("Password"))).sendKeys(password);
        driver.findElement(By.xpath(locators.getProperty("Submit_Button"))).click();
	}
	 

}