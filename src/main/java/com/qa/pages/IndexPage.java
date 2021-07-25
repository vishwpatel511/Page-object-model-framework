package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class IndexPage extends TestBase{
	
	// Page factory :: Objects Repo. 
	

	
	public IndexPage() {

	super();
	
	}

	WebElement LinkForLogin = driver.findElement(By.id("login2"));


	WebElement userNameInput = driver.findElement(By.id("loginusername"));
	

	WebElement passwordInput = driver.findElement(By.id("loginpassword"));
	
	
	WebElement loginButton = driver.findElement(By.xpath("//button[text()='Log in']"));
	

	List<WebElement> linkList = driver.findElements(By.xpath("//div[@id='navbarExample']/ul/li/a"));
	
	
	WebElement AboutUsfooter = driver.findElement(By.xpath("//div[@id='fotcont']/div/div/div/p"));

	/*
	@FindBy(how=How.ID, using="loginpassword")
	WebElement passwordInput;
	
	@FindBy(how=How.XPATH, using="//button[text()='Log in']")
	WebElement loginButton;
	

	@FindBy(how=How.XPATH, using="//div[@id='navbarExample']/ul/li/a")
	List<WebElement> linkList;
	
	
	@FindBy(how=How.XPATH, using="//div[@id='fotcont']/div/div/div/p")
	WebElement AboutUsfooter;
	//initializing the page factory
	
	
	public IndexPage() {
		
		PageFactory.initElements(TestBase.driver, this);
		
	}
	
	*/
	//Actions to take
	
	public String VerifyIndexPageTitle() {
	
		return TestBase.driver.getTitle();
		
	}
	
	public HomePage VerifyLoginFunctionality(String userName, String password) {

		this.LinkForLogin.click();
		this.userNameInput.sendKeys(userName);
		this.passwordInput.sendKeys(password);
		this.loginButton.click();
		
		return new HomePage();
		
	}
	
	public List<WebElement> VerifyLinksPresent() {
		
		return this.linkList;
		
	}
	
	public String VerifyAboutUsFooter() {
	
		
		return this.AboutUsfooter.getText();
		
	}
	

}
