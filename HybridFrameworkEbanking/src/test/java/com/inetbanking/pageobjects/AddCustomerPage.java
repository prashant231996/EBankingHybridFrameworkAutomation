package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage extends BasePage{
	
	WebDriver lDriver;
	
	public AddCustomerPage(WebDriver rDriver)
	{
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(xpath="//a[text()='New Customer']")
	WebElement addCustomer;
	
	@FindBy(name="name")
	WebElement customerName;
	
	@FindBy(name="rad1")
	WebElement maleGender;
	
	@FindBy(xpath="//input[@value='f']")
	WebElement femaleGender;
	
	@FindBy(id="dob")
	WebElement dobTexBox;
	
	@FindBy(name="addr")
	WebElement custaddress;
	
	@FindBy(name="city")
	WebElement custcity;
	
	@FindBy(name="state")
	WebElement custstate;
	
	@FindBy(name="pinno")
	WebElement custpincode;
	
	@FindBy(name="telephoneno")
	WebElement custphoneNo;
	
	@FindBy(name="emailid")
	WebElement custemail;
	
	@FindBy(name="password")
	WebElement custpassword;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement submitButton;
	
	@FindBy(xpath = "//input[@value='Reset']")
	WebElement resetButton;
	
	
	public void addNewCustomer(String customername, String gender,String date, String month, String year, String address, String city, String state, 
			String pinCode, String phoneNo,String email,String password)
	{
		addCustomer.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		customerName.sendKeys(customername);
		if(gender.equalsIgnoreCase("Male"))
		{
			maleGender.click();
		}
		else if(gender.equalsIgnoreCase("Female"))
		{
			femaleGender.click();
		}
		dobTexBox.sendKeys(date);
		dobTexBox.sendKeys(month);
		dobTexBox.sendKeys(year);
		custaddress.sendKeys(address);
		custcity.sendKeys(city);
		custstate.sendKeys(state);
		custpincode.sendKeys(pinCode);
		custphoneNo.sendKeys(phoneNo);
		email=generateRandomString()+"@gmail.com";
		custemail.sendKeys(email);
		custpassword.sendKeys(password);
		submitButton.click();
	}
	

}
