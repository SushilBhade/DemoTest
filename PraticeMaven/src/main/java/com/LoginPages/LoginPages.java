package com.LoginPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.LoginRepo.LoginRepo;

public class LoginPages extends LoginRepo{   // class extended to call object from other class with the help of reference

	public LoginPages(WebDriver driver) {    //parameterized constructed of sameclass
		PageFactory.initElements(driver, this);  
		//pagefactor is class of selenium 
		//initElement is stati cmethod bcz method is called by using classs name
	}
	public void loginToApplication() {
		email.sendKeys("kiran@gmail.com");
		pass.sendKeys("123456");
		button.click();
	}

}
