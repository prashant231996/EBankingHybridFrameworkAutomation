package com.inetbanking.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
	
	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	WebElement userId;
	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(name="btnLogin")
	WebElement loginBtn;
	
	public void setUserName(String userName)
	{
		userId.sendKeys(userName);
	}
	
	public void setPassword(String password)
	{
		pwd.sendKeys(password);
	}
	
	public void clickLogin()
	{
		loginBtn.click();
	}
	
	public void doLogin(String userName,String password)
	{
		setUserName(userName);
		setPassword(password);
		clickLogin();
	}
	

}
