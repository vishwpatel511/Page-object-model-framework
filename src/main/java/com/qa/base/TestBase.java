package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	Properties prop =new Properties();
	FileInputStream inputStream;
	WebDriver driver;
	
	// This method initialize the browser, page
	public void initialization() {
		
		
		
		try {
			inputStream = new FileInputStream("../src/main/java/com/qa/env_vars/prop.properties");
			prop.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String browser = prop.getProperty("browser");
		if(browser.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\vishw\\Desktop\\Study Material\\SeleniumJar\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishw\\Desktop\\Study Material\\SeleniumJar\\chromedriver");
			driver = new ChromeDriver();
			
		}
		else if(browser.equals("ie")) {
			
			System.setProperty("webdriver.ie.driver", "C:\\Users\\vishw\\Desktop\\Study Material\\SeleniumJar\\iedriver");
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Browser not available");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		
	}
	
	public void Exit() {
	
		driver.quit();
	}
	
	

}
