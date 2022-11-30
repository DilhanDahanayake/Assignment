package com.assignment.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.assignment.qa.base.Testbase;
import com.assignment.qa.pages.Homepage;
import com.assignment.qa.pages.Loginpage;
import com.assignment.qa.pages.Approvepage;
import com.assignment.qa.pages.Reportpage;
import com.assignment.qa.pages.Userpage;




public class HomepageTest extends Testbase{
	
	Logger log = Logger.getLogger(LoginpageTest.class);
	Loginpage login;
	Homepage homePage;
	Userpage usersPage;
	Reportpage reports;
	Approvepage approveTimeTrack;

	
	public HomepageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialitation();
		login = new Loginpage();
		usersPage = new Userpage();
		homePage = login.ValidateLogin("admin", "manager");
	}
	
	@Test(priority = 1)
	public void VerifyPageTitleTest() {
		log.info(" ===================Validating home page title=================== ");
		String title = homePage.VerifyHomePageTitle();
		Assert.assertEquals(title, "actiTIME - Login","Title is incorrect");
	}
	
	@Test(priority = 2)
	public void ClickOnUsersLink() {
		usersPage = homePage.ClickOnUsersLink();
	}
	
	@Test(priority = 3)
	public void ClickOnApproveTimeTrackLink() {
		approveTimeTrack = homePage.ClickOnApproveTimeLink();
	}
	
	@Test(priority = 4)
	public void ClickOnReportLink() {
		reports = homePage.ClickOnReportsLink();
	}
	
	
	@AfterMethod
	public void Dispose() {
		driver.quit();
	}

}
