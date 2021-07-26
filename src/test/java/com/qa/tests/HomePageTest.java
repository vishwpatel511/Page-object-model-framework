package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.IndexPage;

import org.testng.annotations.BeforeMethod;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;

public class HomePageTest extends TestBase{
	
	IndexPage indexpage;
	HomePage homepage;
	
	
	public HomePageTest() {
		
		super();
		indexpage = new IndexPage();
		homepage = new HomePage();
		
	}
	
	
  @Test
  public void LogoutPresentTest() {
	  
	  Assert.assertTrue(homepage.VerifyCorrectPage());
  
  }
  
  @Test
  public void LoginSuccessfulTest() {
	  
	  Assert.assertEquals(homepage.VerifyWelcomeLbl(), "Welcome test123@yahoo.com");
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  initialization();
	  indexpage.VerifyLoginFunctionality(TestBase.prop.getProperty("username"), TestBase.prop.getProperty("password"));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
