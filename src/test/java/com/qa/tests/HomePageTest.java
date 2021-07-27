package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.data.ExcelDataReader;
import com.qa.data.TestDataProvider;
import com.qa.pages.HomePage;
import com.qa.pages.IndexPage;
import com.qa.utils.Xls_Reader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class HomePageTest extends TestBase{
	
	IndexPage indexpage;
	HomePage homepage;
	ExcelDataReader excelreader;
	Xls_Reader reader;
	
	public HomePageTest() {
		
		super();
		
	}
	
	 @BeforeMethod
	  public void beforeMethod() throws Exception {
		 	
		  initialization();
		  indexpage = new IndexPage();
	   	homepage = new HomePage();
		  indexpage.VerifyLoginFunctionality(TestBase.prop.getProperty("username"), TestBase.prop.getProperty("password"));
	  }	
  @Test
  public void LogoutPresentTest() {
	  indexpage = new IndexPage();
		homepage = new HomePage();
		
	  Assert.assertTrue(homepage.VerifyCorrectPage());
  
  }

  
  @Test(dataProviderClass = TestDataProvider.class, dataProvider = "dataforWeb")
  public void productSelection(String product, String brand) throws InterruptedException {
	  
	  Thread.sleep(2000);
	  homepage.VerifyCategories(product, brand);
	  // System.out.println(driver.getCurrentUrl().contains("prod.html"));
	  Assert.assertTrue(driver.getCurrentUrl().contains("prod.html"));
	  }
  
  
  
  @Test
  public void LoginSuccessfulTest() {
	  indexpage = new IndexPage();
		homepage = new HomePage();
		
	  Assert.assertEquals(homepage.VerifyWelcomeLbl(), "Welcome test123@yahoo.com");
	  
  }
  
 

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
