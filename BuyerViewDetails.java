package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;

public class BuyerViewDetails extends BaseTest {
	@Test(priority = 3, enabled = true)
	public void buyerViewDetails() throws InterruptedException {
		//Get Buyer Details from the grid.
		 String buyerCode= driver.findElement(By.cssSelector(locators.getProperty("Code_Cell"))).getText();
		 String buyerFullNames= driver.findElement(By.cssSelector(locators.getProperty("Full_Name_Cell"))).getText();
		 String buyerPhoneNumber= driver.findElement(By.cssSelector(locators.getProperty("Phone_Number_Cell"))).getText();
		 String buyerWalletBalance= driver.findElement(By.cssSelector(locators.getProperty("Buyer_Wallet_Balance"))).getText();
		 String buyerExternalID= driver.findElement(By.cssSelector(locators.getProperty("External_id_cell"))).getText();
		 //String buyerIDType= driver.findElement(By.cssSelector(locators.getProperty("Id_type_cell"))).getText();
		 //String buyerID= driver.findElement(By.cssSelector(locators.getProperty("Id_cell"))).getText();
		 
		 //Combine buyer first and family Name
		 final String expectedfullName = BuyerCreation.firstName + " " + BuyerCreation.familyName;
		 Assert.assertEquals(buyerFullNames, expectedfullName, "Family name mismatch");
		 
		 //Assert Buyer Code
	     Assert.assertEquals(buyerCode, BuyerCreation.buyerCode, "Buyer code mismatch");
	     //Assert Phone Number
	     final String expectedPhoneNumber = "225" + BuyerCreation.phoneNumber;
	     Assert.assertEquals(buyerPhoneNumber, expectedPhoneNumber, "Phone number mismatch");
	     //Buyer balance
	     Assert.assertEquals(buyerWalletBalance, "0", "Wallet Balance mismatch");
	     //Buyer External id
	     Assert.assertEquals(buyerExternalID, BuyerCreation.externalID, "External id mismatch");
	     
}
}


