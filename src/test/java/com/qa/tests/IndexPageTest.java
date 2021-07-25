package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.TestBase;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

public class IndexPageTest extends TestBase {
	
	
   @BeforeMethod
   public void setUp() {
  
	TestBase.initialization();
	   
    }

  @AfterMethod
  public void tearDown() {
  
	  TestBase.Exit();
	  
  }

}
