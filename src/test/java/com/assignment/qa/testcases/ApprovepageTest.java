package com.assignment.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.assignment.qa.pages.Homepage;
import com.assignment.qa.pages.Loginpage;
import com.assignment.qa.pages.Approvepage;
import com.assignment.qa.util.TestUtil;
import com.assignment.qa.base.Testbase;


public class ApprovepageTest extends Testbase{
	
	Logger log = Logger.getLogger(LoginpageTest.class);
	Loginpage login;
	Homepage home;
	Approvepage time;
	String sheetName = "ApproveTime";
	
	public ApprovepageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialitation();
		time = new Approvepage();
		login = new Loginpage();
		home = login.ValidateLogin("admin", "manager");
		time = home.ClickOnApproveTimeLink();
	}
	
	@DataProvider
	public Object[][] getTestDataFromExcel() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority =1)
	public void VerifyUserTitleLableTest() {
		log.info("=================== Validating user tile =================== ");
		Assert.assertTrue(time.VerifyApproveTimeTrackTitleLabel(), "Title is incorrect");
	}
	
	@Test(priority =2, dataProvider="getTestDataFromExcel")
	public void ApproveTime(String name, String date) {
		log.info(" ===================Validating time approval=================== ");
		boolean flag = time.ApproveTimeTrack(name, date);
		Assert.assertTrue(flag, "Test Failed");
	}
	
	@AfterMethod
	public void Dispose() {
		driver.quit();
	
	}

}
