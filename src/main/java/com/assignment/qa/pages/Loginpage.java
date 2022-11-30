package com.assignment.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.assignment.qa.base.Testbase;

public class Loginpage extends Testbase{
	
	@FindBy(name="username")
	@CacheLookup
	WebElement username;
	
	@FindBy(name="pwd")
	@CacheLookup
	WebElement pwd;
	
	@FindBy(id="loginButton")
	@CacheLookup
	WebElement loginBtn;
	
	public Loginpage() {
		PageFactory.initElements(driver, this);
	}
	
	public String ValidatePageTitles() {
		return driver.getTitle();
	}
	
	public Homepage ValidateLogin(String un, String Pass) {
		username.sendKeys(un);
		pwd.sendKeys(Pass);
		loginBtn.click();
		
		return new Homepage();
	}

}
