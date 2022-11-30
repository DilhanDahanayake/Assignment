package com.assignment.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.assignment.qa.base.Testbase;
import com.assignment.qa.pages.Homepage;
import com.assignment.qa.pages.Loginpage;
import com.assignment.qa.pages.Reportpage;


public class ReportpageTest extends Testbase{
	
	Logger log = Logger.getLogger(LoginpageTest.class);
	Loginpage login;
	Homepage home;
	Reportpage reports;
	
	public ReportpageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialitation();
		reports = new Reportpage();
		login = new Loginpage();
		home = login.ValidateLogin("admin", "manager");
		reports = home.ClickOnReportsLink();
	}
	
	@Test(priority =1)
	public void VerifyUserTitleLableTest() {
		log.info(" ===================Validating user title=================== ");
		Assert.assertTrue(reports.VerifyUserTitleLable(), "Title is incorrect");
	}
	@Test(priority =2)
	public void GenerateLeaveReport() {
		log.info("===================Generating leave reports ===================");
		Assert.assertTrue(reports.GenerateLeaveReport(), "Leave Report not generating");
	}
	
	@AfterMethod
	public void Dispose() {
		driver.quit();
	}

}
