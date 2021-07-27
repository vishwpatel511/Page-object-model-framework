package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.base.TestBase;

public class PersonalInfoModalPage extends TestBase {
	
	public PersonalInfoModalPage() {
		super();
	}
	
	WebElement nameInputBox = driver.findElement(By.id("name"));
	
	WebElement countryInputBox = driver.findElement(By.id("country"));
	
	WebElement cardInputBox = driver.findElement(By.id("card"));
	
	WebElement monthInputBox = driver.findElement(By.id("month"));
	
	WebElement yearInputBox = driver.findElement(By.id("year"));

	WebElement purchaseBtn = driver.findElement(By.xpath("//button[text() = 'Purchase']"));

	WebElement orderConfirmationMsg = driver.findElement(By.xpath("//p[@class = 'lead text-muted ']"));
	
public String fillFormVerify(String name, String country, String cardNum, String month, String year) throws InterruptedException {
	
	nameInputBox.sendKeys(name);
	countryInputBox.sendKeys(country);
	cardInputBox.sendKeys(cardNum);
	monthInputBox.sendKeys(month);
	yearInputBox.sendKeys(year);
	Thread.sleep(2000);
	purchaseBtn.click();
	Thread.sleep(3000);
	return orderConfirmationMsg.getText();
}








}
