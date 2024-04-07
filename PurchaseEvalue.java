package testCases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseTest.BaseTest;

public class PurchaseEvalue extends BaseTest {
	
	/*public void clickElementWithFluentWait(By locator, int timeoutInSeconds) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);

        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }*/
	
	@Test(priority = 4,  enabled = false)
	public void purchaseEvalue() throws InterruptedException {
		/*
		 int timeoutInSeconds = 60; // Adjust the timeout as needed

	        // Use FluentWait to wait for the element to be clickable
	        By purchaseMenuLocator = By.cssSelector(locators.getProperty("Purchase_Evalue_menu"));
	        clickElementWithFluentWait(purchaseMenuLocator, timeoutInSeconds);
	        */
		driver.findElement(By.className(locators.getProperty("Purchase_Evalue_menu"))).click();
		driver.findElement(By.xpath(locators.getProperty("Purchase_Evalue_submenu"))).click();
		
		String EvalueBalancePurchaseScreen = driver.findElement(By.cssSelector(locators.getProperty("Evalue_Balance_Purchase_screen"))).getText();
		System.out.println("Evalue Balance Purchase Screen = " + EvalueBalancePurchaseScreen);
		
		String PendingEvalueAmount= driver.findElement(By.cssSelector(locators.getProperty("Pending_Evalue"))).getText();
		System.out.println("Pending Evalue Amount = " + PendingEvalueAmount);
		
		driver.findElement(By.xpath(locators.getProperty("Intiate_Request_Button"))).click();
		String TransactionFee= driver.findElement(By.xpath(locators.getProperty("Transaction_Processing_Fee"))).getText();
		System.out.println("Transaction Fee = " + TransactionFee);
		
		int grosssAmount=  (int)(Math.random() * 10000);
		String grossAmountString = String.valueOf(grosssAmount);
		System.out.println("grosss Amount = "+ grossAmountString);		
		driver.findElement(By.xpath(locators.getProperty("Gross_Amount"))).sendKeys(grossAmountString);
		
		String NetAmount= driver.findElement(By.xpath(locators.getProperty("Net_Amount"))).getText();
		System.out.println("Net Amount = " + NetAmount);
		
		String TransferCharges= driver.findElement(By.xpath(locators.getProperty("Transfer_Charges"))).getText();
		System.out.println("Transfer Charges = " + TransferCharges);
		
		
		int grossAmount = Integer.parseInt(grossAmountString);
        int transferCharges = Integer.parseInt(TransferCharges);
        int expectedNetAmount = grossAmount - transferCharges;
        
     // Assert Net Amount
        String actualNetAmount = NetAmount;
        Assert.assertEquals(actualNetAmount, String.valueOf(expectedNetAmount), "Net Amount is not as expected");
        
     // Calculate expected Charge using Transaction Fee
        String expectedTransferCharges= ("TransactionFee*grossAmountString");
        Assert.assertEquals(expectedTransferCharges, TransferCharges, "Charge is not as expected");
        
        

        
        
		
		
		
		}

}
