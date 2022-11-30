package com.assignment.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment.qa.base.Testbase;

public class Userpage extends Testbase{
	
	@FindBy(xpath="//span[text()='List of Users']")
	@CacheLookup
	WebElement usersLabel;
	
	public Userpage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifyUserTitleLable() {
		return usersLabel.isDisplayed();
	}
	
	public boolean SelectUserByName(String fName, String lName) {
		String displayName = lName + ", " + fName;
		String fullName = fName + " " + lName;
		
		WebElement valueFromDropDown = driver.findElement(By.xpath("//span[text()='"+displayName+"']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(valueFromDropDown).build().perform();
		valueFromDropDown.click();
		
		WebElement fullNameWebElement = driver.findElement(By.xpath("//div[text()='"+fullName+"']"));
		return fullNameWebElement.isDisplayed();
	}

}
