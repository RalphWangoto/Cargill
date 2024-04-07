package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import baseTest.BaseTest;

public class Evalue_Disburements extends BaseTest {
	@Test(priority = 3,  enabled = false)
	public void evalueDisbursements() throws InterruptedException {
		driver.findElement(By.xpath(locators.getProperty("Evalue_Disbursements"))).click();
		
		String EvalueDisbursedtoBuyers= driver.findElement(By.xpath(locators.getProperty("Evalue_Disbursed_to_Buyers"))).getText();
		System.out.println(EvalueDisbursedtoBuyers);	
		
		String CurrentEvalueBalance= driver.findElement(By.cssSelector(locators.getProperty("Current_evalueBalance"))).getText();
		System.out.println(CurrentEvalueBalance);
		
		driver.findElement(By.xpath(locators.getProperty("Intiate_evalueDisbursementButton"))).click();
		WebElement buyerDropdown = driver.findElement(By.xpath(locators.getProperty("Buyer")));
		Select dropdown	= new Select(buyerDropdown);
		dropdown.selectByIndex(1);
		String buyerName = dropdown.getFirstSelectedOption().getText();
		System.out.println("Buyer Name " + buyerName);	
		
		String buyerPhoneNumber = driver.findElement(By.xpath(locators.getProperty("Buyer_PhoneNumber"))).getText();
		System.out.println("Buyer Phone Number = " + buyerPhoneNumber);
		
		String buyerBalance = driver.findElement(By.xpath(locators.getProperty("Buyer_Balance"))).getText();
		System.out.println("Buyer Phone Number = " + buyerBalance);
		
		int amountToTransfer =  (int)(Math.random() * 1000);
		String amountToTransferString = String.valueOf(amountToTransfer);
		System.out.println("grosss Amount = "+ amountToTransferString);		
		driver.findElement(By.xpath(locators.getProperty("Amount_To_Transfer"))).sendKeys(amountToTransferString);
		
		driver.findElement(By.xpath(locators.getProperty("Validate_Button"))).click();
		
		
		
		
		
	}

}
