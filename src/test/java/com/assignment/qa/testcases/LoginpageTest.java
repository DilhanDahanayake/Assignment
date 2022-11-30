package com.assignment.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.assignment.qa.base.Testbase;
import com.assignment.qa.pages.Homepage;
import com.assignment.qa.pages.Loginpage;

public class LoginpageTest extends Testbase{
	
	Logger log = Logger.getLogger(LoginpageTest.class);
	Loginpage login;
	Homepage home;
	
	public LoginpageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialitation();
		login = new Loginpage();
		
	}
	
	@Test(priority = 1)
	public void LoginPageTitleTest() {
		log.info("=================== Validating login page title ===================");
		String title = login.ValidatePageTitles();
		Assert.assertEquals(title, "actiTIME - Login");
		
	}
	
	@Test(priority = 2)
	public void ValidateLoginTest() {
		log.info("=================== Validating login ===================");
		home = login.ValidateLogin("admin", "manager");
		
	}
	
	@AfterMethod
	public void Dispose() {
		driver.quit();
	}

}
