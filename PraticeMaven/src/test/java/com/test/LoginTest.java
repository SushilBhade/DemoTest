package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.LoginPages.LoginPages;

public class LoginTest {
	WebDriver driver; // WebDriver is used to find WebElements. 
	LoginPages lp;
	
	@BeforeMethod  //annotation from TestNg
	//by using above annotation we will be calling this before any method only once
	public void correctCred() {    //method to be runned
		System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///E:/SeleniumSoftware/Offline%20Website/index.html");// url of site
		driver.manage().window().fullscreen();
											//manage() Gets the Option interface
											//window() the interface for managing the current window.
											//fullscreen() Fullscreen the current window if it is not already fullscreen
		lp=new LoginPages(driver);// object creation

	}
	@Test//Mark a class or a method as part of the test.
public void verifyTitleOfTestPage() { //method to test case
		lp.loginToApplication();
		Assert.assertEquals(driver.getTitle(),"JavaByKiran | DashBoard");
		
	}
}
