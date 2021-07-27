package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.data.TestDataProvider;
import com.qa.pages.HomePage;
import com.qa.pages.IndexPage;
import com.qa.pages.ProductsPage;
import com.qa.pages.ShoppingCartPage;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ShoppingCartPageTest extends TestBase{
 
	IndexPage indexpage;
	HomePage homepage;
	ProductsPage productspage;
	ShoppingCartPage shoppingcartpage;
	
	
	public ShoppingCartPageTest() {
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

	  }
	
	 @Test(dataProviderClass = TestDataProvider.class, dataProvider = "dataforWeb", priority = 1)
  public void DeleteBtnFunctionalityTest(String category, String product) throws InterruptedException {
		 
		 homepage.VerifyCategories(category, product);
		 Thread.sleep(2000);
		 productspage.VerifyaddToCartBtn().accept();
		 Assert.assertEquals(shoppingcartpage.DeleteBtnFunctionalityVerify().size(), 0);
  }
  
	 @Test(dataProviderClass = TestDataProvider.class, dataProvider = "dataforWeb", priority = 1)
  public void ProductNameTest(String category, String product) throws InterruptedException {
	  
		 homepage.VerifyCategories(category, product);
		 Thread.sleep(2000);
		 productspage.VerifyaddToCartBtn().accept();
		 Assert.assertEquals(product, shoppingcartpage.ProductNameVerify());
		 shoppingcartpage.DeleteBtnFunctionalityVerify();

  }
 
	 @Test(dataProviderClass = TestDataProvider.class, dataProvider = "dataforWeb", priority = 1)
public void PlaceOrderBtnVerify(String category, String product) throws InterruptedException {
	
	 homepage.VerifyCategories(category, product);
	 Thread.sleep(2000);
	 productspage.VerifyaddToCartBtn().accept();
	 shoppingcartpage.PlaceOrderBtnVerify();
	 Thread.sleep(2000);
	
}
  
  @AfterMethod
  public void afterMethod() {
  
	  driver.quit();
	  
  }

}
