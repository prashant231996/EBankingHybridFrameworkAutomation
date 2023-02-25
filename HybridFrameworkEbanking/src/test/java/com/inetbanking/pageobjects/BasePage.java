package com.inetbanking.pageobjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.inetbanking.testcases.BaseClass;

public class BasePage extends BaseClass{
	
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement logOutLink;
	
	
	public void logOutLink()
	{
		try {
			logOutLink.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isAlertPresent()
	{
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public String generateRandomString()
	{
		String randonString=RandomStringUtils.randomAlphabetic(8);
		return randonString;
	}
	
	public String generateRandomNumeric()
	{
		String randomNumber=RandomStringUtils.randomNumeric(4);
		return randomNumber;
	}
	
	public void test()
	{
	}

}
