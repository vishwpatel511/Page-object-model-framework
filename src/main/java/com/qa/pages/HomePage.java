package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.base.TestBase;

public class HomePage extends TestBase {

	public HomePage() {
		
		super();
		
	}
	
	WebElement WelcomeLbl = driver.findElement(By.xpath("//div[@id='navbarExample']/ul/li[7]"));
	
	WebElement LogOutLink = driver.findElement(By.xpath("//div[@id='navbarExample']/ul/li[6]"));
	
	public String VerifyWelcomeLbl() {
		
		return WelcomeLbl.getText();
		
	}
	
	public boolean VerifyCorrectPage() {
		
		return LogOutLink.isDisplayed();
	}
	
	public ProductsPage VerifyCategories(String category, String productName) throws InterruptedException {
		
		driver.findElement(By.xpath("//div[@class='list-group']/a[text() = '" + category + "']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='tbodyid']/div/div/a/following-sibling::div/h4/a[text()='" + productName + "']")).click();
		
		return new ProductsPage();
	}
	
}
