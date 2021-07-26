package com.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.base.TestBase;

public class ProductsPage extends TestBase{
	
	
	public ProductsPage() {
		
		
		super();
		
	}
	
//	WebElement addToCartBtn = driver.findElement(By.xpath("//a[text() = 'Add to cart']"));
	
	//WebElement addedProductName = driver.findElement(By.xpath("//div[@id= 'tbodyid']/h2"));
	
	public Alert VerifyaddToCartBtn() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[text() = 'Add to cart']")).click();
		Thread.sleep(2000);
		return driver.switchTo().alert();
	}
	
	public String VerifyCorrectProductAdded() {
		
		driver.findElement(By.xpath("//a[text() = 'Add to cart']")).click();
		return driver.findElement(By.xpath("//div[@id= 'tbodyid']/h2")).getText();
		
	}
	

}
