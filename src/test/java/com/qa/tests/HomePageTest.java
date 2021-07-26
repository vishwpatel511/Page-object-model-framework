package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.data.ExcelDataReader;
import com.qa.pages.HomePage;
import com.qa.pages.IndexPage;
import com.qa.utils.Xls_Reader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.junit.Assert;
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
	  public void beforeMethod() {
		 	
		  initialization();
		  indexpage = new IndexPage();
	   	homepage = new HomePage();
	   	excelreader = new ExcelDataReader();
	   	reader = new Xls_Reader("C:\\Users\\vishw\\Desktop\\HomePageTestData.xlsx");
		  indexpage.VerifyLoginFunctionality(TestBase.prop.getProperty("username"), TestBase.prop.getProperty("password"));
	  }	
  @Test
  public void LogoutPresentTest() {
	  indexpage = new IndexPage();
		homepage = new HomePage();
		
	  Assert.assertTrue(homepage.VerifyCorrectPage());
  
  }
  
  @DataProvider
  public Object[][] dataforWeb(){
	
	  
	  Object[][] data;
	  data = new Object[3][2];
	
	  int counter = 0;
	  System.out.println(excelreader.retrivingExcel().size());
	  for(int i = 0; i<3; i++) {
		  
		  for(int j = 0; j<2; j++) {
		  
			  data[i][j] = excelreader.retrivingExcel().get(counter);
		  		counter++;
		  		System.out.println(excelreader.retrivingExcel().get(counter));
		  		
		  		
		  		// data[3][2]:::: data[0][0]
		  		
	  }

		  }
	return data;
	
	}
	
	  
  
  @Test(dataProvider = "dataforWeb")
  public void productSelection(String category, String product) throws InterruptedException {
	  
	  homepage.VerifyCategories(category, product);
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
