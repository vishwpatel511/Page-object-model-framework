package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.base.TestBase;

public class PersonalInfoModalPage extends TestBase {
	
	public PersonalInfoModalPage() {
		super();
	}
	
	
public String fillFormVerify(String name, String country, String city, String cardNum, String month, String year) throws InterruptedException {
	

	WebElement nameInputBox = driver.findElement(By.id("name"));
	
	WebElement countryInputBox = driver.findElement(By.id("country"));
	
	WebElement cityInputBox = driver.findElement(By.id("city"));
	
	WebElement cardInputBox = driver.findElement(By.id("card"));
	
	WebElement monthInputBox = driver.findElement(By.id("month"));
	
	WebElement yearInputBox = driver.findElement(By.id("year"));

	WebElement purchaseBtn = driver.findElement(By.xpath("//button[text() = 'Purchase']"));

	//WebElement orderConfirmationMsg = driver.findElement(By.xpath("//p[@class = 'lead text-muted ']"));
	
	nameInputBox.sendKeys(name);
	countryInputBox.sendKeys(country);
	cityInputBox.sendKeys(city);
	cardInputBox.sendKeys(cardNum);
	monthInputBox.sendKeys(month);
	yearInputBox.sendKeys(year);
	Thread.sleep(2000);
	purchaseBtn.click();
	Thread.sleep(3000);
	return driver.findElement(By.xpath("//p[@class = 'lead text-muted ']")).getText();
}








}
