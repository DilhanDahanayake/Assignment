package com.assignment.qa.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.assignment.qa.base.Testbase;
import com.assignment.qa.pages.Homepage;
import com.assignment.qa.pages.Loginpage;
import com.assignment.qa.pages.Userpage;



public class UserpageTest extends Testbase{
	
	Logger log = Logger.getLogger(LoginpageTest.class);
	Loginpage login;
	Homepage home;
	Userpage user;
	
	public UserpageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialitation();
		user = new Userpage();
		login = new Loginpage();
		home = login.ValidateLogin("admin", "manager");
		user = home.ClickOnUsersLink();
	}
	
	@Test(priority =1)
	public void VerifyUserTitleLableTest() {
		log.info(" ===================Validating user page title=================== ");
		Assert.assertTrue(user.VerifyUserTitleLable(), "Title is incorrect");
	}
	
	@Test(priority =2)
	public boolean SelectUserByName(String fName, String lName) {
		log.info(" ===================Selecting user=================== ");
		String displayName = lName + ", " + fName;
		String fullName = fName + " " + lName;
				
		
		WebElement valueFromDropDown = driver.findElement(By.xpath("//span[text()='"+displayName+"']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(valueFromDropDown).build().perform();
		valueFromDropDown.click();
		
		WebElement fullNameWebElement = driver.findElement(By.xpath("//div[text()='"+fullName+"']"));
		return fullNameWebElement.isDisplayed();
	}
	
	@AfterMethod
	public void Dispose() {
		driver.quit();
	}

}
