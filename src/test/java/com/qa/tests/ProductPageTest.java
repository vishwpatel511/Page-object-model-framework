package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.data.TestDataProvider;
import com.qa.pages.HomePage;
import com.qa.pages.IndexPage;
import com.qa.pages.ProductsPage;

import org.testng.annotations.BeforeMethod;

import java.util.Locale.Category;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ProductPageTest extends TestBase {
	
	ProductsPage productpage;
	HomePage homepage;
	HomePageTest homepagetest;
	
	public ProductPageTest() {
		
		super();
		
	}
	
	 @BeforeMethod
	  public void beforeMethod() throws Exception {
		 
		 initialization();

		 IndexPage indexpage = new IndexPage();
		 indexpage.VerifyLoginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
		 homepagetest = new HomePageTest();
		 productpage = new ProductsPage();
		
	  }

	 
  @Test(dataProviderClass = TestDataProvider.class, dataProvider = "dataforWeb", priority = 2)
  public void AddToCartBtnTest(String category, String productName) throws InterruptedException {
	  
	  Thread.sleep(2000);
	//  homepagetest.productSelection(category, productName);
	  homepage = new HomePage();
	  homepage.VerifyCategories(category, productName);
	  Thread.sleep(1000);
	  Assert.assertTrue(productpage.VerifyaddToCartBtn().getText().contains("Product added"));
	  Thread.sleep(1000);
	  driver.switchTo().alert().accept();
	  Thread.sleep(3000);
  }
  
 @Test(dataProviderClass = TestDataProvider.class, dataProvider = "dataforWeb", priority = 1)
 public void CorrectProductAddedTest(String category, String productName) throws InterruptedException {
	 Thread.sleep(1000);
	AddToCartBtnTest(category, productName);
	Thread.sleep(1000);
	Assert.assertEquals(productName, productpage.VerifyCorrectProductAdded()); 
 }
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
