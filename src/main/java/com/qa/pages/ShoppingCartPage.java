package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.base.TestBase;

public class ShoppingCartPage extends TestBase{
	
	public ShoppingCartPage() {
		
		super();
	}
	
	/*
	 * WebElement linkToCart = driver.findElement(By.xpath("//a[text()='Cart']"));
	 * 
	 * WebElement productName =
	 * driver.findElement(By.xpath("//tr[@class='success']/td[2]"));
	 * 
	 * WebElement DeleteBtn = driver.findElement(By.xpath("//a[text()='Delete']"));
	 * 
	 * WebElement placeOrderBtn =
	 * driver.findElement(By.xpath("//button[text() = 'Place Order']"));
	 */

	
	public String ProductNameVerify() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[text()='Cart']")).click();
		Thread.sleep(2000);
		
		WebElement productName = driver.findElement(By.xpath("//tr[@class='success']/td[2]"));
	
		
		return productName.getText();
		
	}
	
	public List<WebElement> DeleteBtnFunctionalityVerify() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[text()='Cart']")).click();
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		Thread.sleep(2000);
		List<WebElement> productsinTheCart = driver.findElements(By.xpath("//tr[@class='success']/td[2]"));
		return productsinTheCart;
		
	}
	
	public PersonalDetailsFormPage PlaceOrderBtnVerify() {
		
		driver.findElement(By.xpath("//a[text()='Cart']")).click();
		driver.findElement(By.xpath("//button[text() = 'Place Order']")).click();
		
		return new PersonalDetailsFormPage();
	}
}
