package com.LoginRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginRepo {
	WebDriver driver; //WebDriver is interface of selenium

	//@FindBy is annotation and  this allows users to quickly and easily create PageObjects.
	@FindBy(id="email") 
	public WebElement email; //WebElement Represents an HTML element. 
							 //Generally, all interesting operations to do with interacting 
							// with a page will be performed through this interface. 
	@FindBy(id="password")
	public WebElement pass;
	@FindBy(xpath="//button")
	public WebElement button;

}
