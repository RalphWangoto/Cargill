package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import baseTest.BaseTest;

public class CoopDashboard extends BaseTest {
	@Test(priority = 2, enabled = false)
	public void coopDashboard() throws InterruptedException {
		 String evalueBalance = driver.findElement(By.xpath(locators.getProperty("Evalue_Balance"))).getText();
		 System.out.println("Evalue Balance = " + evalueBalance);	
		 
		 String totalEvalueDisbursed = driver.findElement(By.xpath(locators.getProperty("Total_Evalue_Disbursed"))).getText();
		 System.out.println("Total Evalue Disbursed = " + totalEvalueDisbursed);
		 
		 String transaction_count = driver.findElement(By.xpath(locators.getProperty("Transaction_Count"))).getText();
		 System.out.println("Transaction Count = " + transaction_count);
		 
		 String farmers_count = driver.findElement(By.xpath(locators.getProperty("Farmers_Count"))).getText();
		 System.out.println("Farmers count = " + farmers_count);
		 
		 String totalEvalueDisbursed2 = driver.findElement(By.xpath(locators.getProperty("Total_Evalue_Disbursed[2]"))).getText();
		 System.out.println("Total Evalue Disbursed 2 = " + totalEvalueDisbursed2);
		 
		 Assert.assertEquals(totalEvalueDisbursed, totalEvalueDisbursed2, "Values are not the same");
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(1660,700)", "");
		 
		 //Interact with the table
		 WebElement latestCoopTransactionTable = driver.findElement(By.xpath("Latest_Cooprative_Transaction_Table"));

		 //Retrieve all Rows for the table
		 java.util.List<WebElement> rows = latestCoopTransactionTable.findElements(By.tagName("tr"));
		 
		// Iterate through each row
	        for (WebElement row : rows) {
	            // Retrieve all columns of the current row
	            java.util.List<WebElement> columns = row.findElements(By.tagName("td"));
	            
	         // Iterate through each column and print the text
	            for (WebElement column : columns) {
	                System.out.print(column.getText() + "\t");
	            }
	            System.out.println(); // Move to the next line after printing each row
		 
	        }
	}

}
