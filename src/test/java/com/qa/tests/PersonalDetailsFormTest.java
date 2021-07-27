package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.data.PersonalInfoDataProvider;
import com.qa.pages.HomePage;
import com.qa.pages.IndexPage;
import com.qa.pages.PersonalInfoModalPage;
import com.qa.pages.ProductsPage;
import com.qa.pages.ShoppingCartPage;



import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class PersonalDetailsFormTest extends TestBase{
	
	IndexPage indexpage;
	HomePage homepage;
	ProductsPage productspage;
	ShoppingCartPage shoppingcartpage;
	PersonalInfoModalPage personalinfomodalpage;
	
	public PersonalDetailsFormTest() {
		
	super();
		
	}
	
	 @BeforeMethod
	  public void beforeMethod() throws InterruptedException {
	    	 initialization();
			indexpage = new IndexPage();
			indexpage.VerifyLoginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
			homepage = new HomePage();
			productspage = new ProductsPage();
			shoppingcartpage = new ShoppingCartPage();
			personalinfomodalpage = new PersonalInfoModalPage();		 
	  }
	

  @Test(dataProviderClass = PersonalInfoDataProvider.class, dataProvider = "dataforPersonalInfo")
  public void fillFormTest(String name, String country, String city, String cardNum, String month, String year) throws InterruptedException {
	  
	  driver.findElement(By.xpath("//a[text()='Cart']")).click();
	  driver.findElement(By.xpath("//button[text() = 'Place Order']")).click();
	  Thread.sleep(3000);
	  personalinfomodalpage.fillFormVerify(name, country, city, cardNum, month, year);
	  Thread.sleep(3000);
	  Assert.assertTrue(driver.findElement(By.xpath("//p[@class = 'lead text-muted ']")).getText().contains(cardNum));
  }
 
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
