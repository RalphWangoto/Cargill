package testCases;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;

public class BuyerCreation extends BaseTest {
	
	// Array of first names
    private static final String[] FIRST_NAMES = {"John", "Alice", "Bob", "Emma", "Michael", "Olivia", "David", "Sophia", "Evans", "Brian", "Raphael", "Kakande", "Museveni", "Alassane", "Dramane"};
	
	public static final String familyName = "Njuguna";
	public static final String firstName = getRandomFirstName();
	public static final String buyerCode = getRandomNumber(7);
	public static final String phoneNumber = "059" + getRandomNumber(7);
	public static final String identityNumber = getRandomNumber(8);
	public static final String externalID = getRandomNumber(10);
	public static final String geoAddress = "Abijan";
	public static final String email = generateRandomEmail();

    // Method to generate a random first name
    private static String getRandomFirstName() 
    {
        return FIRST_NAMES[new Random().nextInt(FIRST_NAMES.length)];
    }
	
 // Method to generate a random number with specified length
    private static String getRandomNumber(int length) 
    {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) 
        {
            stringBuilder.append(random.nextInt(10)); // Append random digit (0-9)
        }
        return stringBuilder.toString();
    }
    
 // Method to generate a random email
    private static String generateRandomEmail() 
    {
        String domain = "example.com";
        String username = "user" + getRandomNumber(5); // Generate a random username
        return username + "@" + domain;
    }
	
	@Test(priority = 2, enabled = true)
	public void buyerCreation() throws InterruptedException {
        driver.findElement(By.xpath(locators.getProperty("Cocoa_Buyer_Menu"))).click();
        driver.findElement(By.xpath(locators.getProperty("Manage_Buyer_Menu"))).click();
        driver.findElement(By.xpath(locators.getProperty("Add_Buyer_Button"))).click();
        driver.findElement(By.xpath(locators.getProperty("Family_Name"))).sendKeys(familyName);
        driver.findElement(By.xpath(locators.getProperty("First_Name"))).sendKeys(firstName);
        driver.findElement(By.xpath(locators.getProperty("Buyer_Code"))).sendKeys(buyerCode);
        driver.findElement(By.xpath(locators.getProperty("Phone_Number"))).sendKeys(phoneNumber);
        WebElement dropdownElement = driver.findElement(By.xpath(locators.getProperty("Identity_Type")));
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // Initialize Select object with the dropdown element
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(0);
        
        // Get the selected option
        WebElement selectedOption = dropdown.getFirstSelectedOption();

        // Get the text of the selected option
        String selectedText = selectedOption.getText();
        System.out.println("Selected option: " + selectedText);
        
        driver.findElement(By.xpath(locators.getProperty("Identity_Number"))).sendKeys(identityNumber);
        driver.findElement(By.xpath(locators.getProperty("External_ID"))).sendKeys(externalID);
        
        /*WebElement genderDropdown = driver.findElement(By.xpath(locators.getProperty("Buyer_Gender")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Select genderdropdown = new Select(genderDropdown);
        genderdropdown.selectByIndex(0);*/
        
        driver.findElement(By.xpath(locators.getProperty("Buyer_Gender"))).click();
        driver.findElement(By.xpath(locators.getProperty("Male"))).click();
        driver.findElement(By.xpath(locators.getProperty("Geo_Address"))).sendKeys(geoAddress);
        driver.findElement(By.xpath(locators.getProperty("Email"))).sendKeys(email);
        driver.findElement(By.xpath(locators.getProperty("Section"))).click();
        driver.findElement(By.xpath(locators.getProperty("Gagnoa"))).click();
        driver.findElement(By.xpath(locators.getProperty("outside_email"))).click();
        driver.findElement(By.xpath(locators.getProperty("Create_Account_Button"))).click();
        String successMessage= driver.findElement(By.xpath(locators.getProperty("success_screen_message"))).getText();
        String expectedMessage= "Registered Successfully";
        Assert.assertTrue(successMessage.contains(expectedMessage), "Actual string does not contain the expected substring");
        driver.findElement(By.xpath(locators.getProperty("OK_Button"))).click();
	}
	 

} 

