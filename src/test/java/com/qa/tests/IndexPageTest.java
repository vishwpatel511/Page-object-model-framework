package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.IndexPage;

import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class IndexPageTest extends TestBase {
	
	IndexPage indexpage = new IndexPage();
	
	public IndexPageTest() {
		super();
	}
	
   @BeforeMethod
   public void setUp() {
  
	TestBase.initialization();
	   
    }
   
   @Test(priority=1)
   public void PageTitleTest() {
	   
	   Assert.assertEquals(indexpage.VerifyIndexPageTitle(), "STORE", "Title is not as expected");
	   
   }
   
   @Test(priority=2)
   public void LinksPresentTest() {
	 
	 String[] expectedLinksArray =new String[] {"Home ", "Contact", "About us", "Cart", "Log in", "Sign up"};  
	
	 for(int i =0; i<expectedLinksArray.length; i++) {
	
		 Assert.assertTrue(indexpage.VerifyLinksPresent().contains(expectedLinksArray[i]));
		 
	 }
   }
   
   @Test(priority=3)
   public void LoginFunctionalityTest() throws InterruptedException {
	   
	   indexpage.VerifyLoginFunctionality(TestBase.prop.getProperty("username"), TestBase.prop.getProperty("password"));
	   Thread.sleep(2000);
	   Assert.assertEquals(TestBase.driver.findElement(By.xpath("//div[@id='navbarExample']/ul/li[6]/a")).getText(), "Log out");
	   }
   
   @Test(priority=4)
   public void AboutUsFooterTest() {
	   Assert.assertTrue(indexpage.VerifyAboutUsFooter().contains("We believe performance needs to be validated"));
	   
   }
   
   
   
  @AfterMethod
  public void tearDown() throws InterruptedException {
  
	  TestBase.Exit();
	  
  }

  
  
}
