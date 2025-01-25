package com.inetbanking.pageobjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.inetbanking.testcases.BaseClass;

public class BasePage{
	
	WebDriver driver;
	JavascriptExecutor js;
	Alert alert;
	WebDriverWait wait;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		js=(JavascriptExecutor)driver;
		wait=new WebDriverWait(driver,10);
	}
	
	
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
	
	public void acceptAlert()
	{
		alert=driver.switchTo().alert();
		alert.accept();
	}
	
	public void logoutFromApplication()
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(logOutLink));
		js.executeScript("arguments[0].scrollIntoView();", logOutLink);
		logOutLink.click();
		acceptAlert();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
