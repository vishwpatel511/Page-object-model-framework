package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class IndexPage extends TestBase{
	
	// Page factory :: Objects Repo. 
	@FindBy(id="login2")
	WebElement LinkForLogin;
	
	@FindBy(id="loginusername")
	WebElement userNameInput;
	
	@FindBy(id="loginpassword")
	WebElement passwordInput;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement loginButton;
	
	@FindBy(xpath="//div[@id='navbarExample']/ul/li/a")
	List<WebElement> linkList;
	
	@FindBy(xpath="//div[@id='fotcont']/div/div/div/p")
	WebElement AboutUsfooter;
	//initializing the page factory
	public IndexPage() {
		
		PageFactory.initElements(TestBase.driver, this);
		
	}
	
	
	//Actions to take
	
	public String IndexPageTitleTest() {
		
		return TestBase.driver.getTitle();
		
	}
	
	public HomePage LoginFunctionalityTest(String userName, String password) {

		this.LinkForLogin.click();
		this.userNameInput.sendKeys(userName);
		this.passwordInput.sendKeys(password);
		this.loginButton.click();
		
		return new HomePage();
		
	}
	
	public List<WebElement> LinksPresentTest() {
		
		return this.linkList;
		
	}
	
	public String AboutUsFooterTest() {
		
		return this.AboutUsfooter.getText();
		
	}
	

}
