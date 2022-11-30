package com.assignment.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment.qa.base.Testbase;


public class Homepage extends Testbase{
	
	@FindBy(xpath="//a[contains(text(),'Approve Time-Track')]")
	@CacheLookup
	WebElement approveTimeLink;
	
	@FindBy(xpath="//a[contains(@class,'content users')]")
	@CacheLookup
	WebElement usersLink;
	
	@FindBy(xpath="//a[contains(@class,'content reports')]")
	@CacheLookup
	WebElement reportsLink;
	
	public Homepage() {
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public Approvepage ClickOnApproveTimeLink() {
		
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Approve Time-Track')]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
		
		approveTimeLink.click();
		return new Approvepage();
	}
	
	public Userpage ClickOnUsersLink() {
		usersLink.click();
		return new Userpage();
	}
	
	public Reportpage ClickOnReportsLink() {
		reportsLink.click();
		return new Reportpage();
	}

}
