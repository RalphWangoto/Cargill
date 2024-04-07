package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;

public class BuyerUpdate extends BaseTest {
	@Test(priority = 4, enabled = true)
	public void buyerUpdate() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.xpath(locators.getProperty("Edit_Button"))).click();
		String editBuyerScreenHeader= driver.findElement(By.xpath(locators.getProperty("Edit_Button"))).getText();
		Assert.assertTrue(editBuyerScreenHeader.contains("Edit"), "Actual header does not contain the expected header");
		
		String expectedBuyerFamilyName = BuyerCreation.familyName;
		String familyName= driver.findElement(By.xpath(locators.getProperty("Family_Name"))).getText();
		System.out.println("Actual Family Name" + familyName);
		Assert.assertEquals(familyName, expectedBuyerFamilyName, "Buyer Family Name mismatch");
		
        String firstName= driver.findElement(By.xpath(locators.getProperty("First_Name"))).getText();
        Assert.assertEquals(firstName, BuyerCreation.firstName, "Buyer first Name mismatch");
        
        String buyerCode= driver.findElement(By.xpath(locators.getProperty("Buyer_Code"))).getText();
        Assert.assertEquals(buyerCode, BuyerCreation.buyerCode, "Buyer Code mismatch");
        
        String buyerPhoneNumber= driver.findElement(By.xpath(locators.getProperty("Phone_Number"))).getText();
        final String expectedPhoneNumber = "225" + BuyerCreation.phoneNumber;
        Assert.assertEquals(buyerPhoneNumber,expectedPhoneNumber, "Buyer Phone Number mismatch");
        
        String externalId= driver.findElement(By.xpath(locators.getProperty("External_ID"))).getText();
        Assert.assertEquals(externalId,BuyerCreation.externalID, "Buyer External ID mismatch");
        
        String geoAddress= driver.findElement(By.xpath(locators.getProperty("Geo_Address"))).getText();
        Assert.assertEquals(geoAddress,BuyerCreation.geoAddress, "Buyer Geo Address mismatch");
        
        String email= driver.findElement(By.xpath(locators.getProperty("Email"))).getText();
        Assert.assertEquals(email,BuyerCreation.email, "Buyer Email mismatch");
	}
	}
