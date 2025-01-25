package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class EditCustomerPage extends BasePage{

	WebDriver lDriver;
	
	public EditCustomerPage(WebDriver rDriver)
	{
		super(rDriver);
		lDriver=rDriver;
		PageFactory.initElements(lDriver, this);
	}
	
	@FindBy(xpath="//a[text()='Edit Customer']")
	WebElement editCustomer;
	
	@FindBy(name="cusid")
	WebElement customerId;
	
	@FindBy(name="AccSubmit")
	WebElement submitBtn;
	
	@FindBy(name="name")
	WebElement customerName;
	
	@FindBy(name="addr")
	WebElement addressName;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement editSubmitBtn;
	
	
	public void navigateToCustomerEdit(String custId) throws InterruptedException
	{
		editCustomer.click();
		Thread.sleep(5000);
		customerId.sendKeys(custId);
		submitBtn.click();
	}
	
	public void editCustomer(String customername, String address)
	{
		customerName.sendKeys("oooo");
		addressName.sendKeys("iiiii");
		JavaScriptExecutor js=(JavaScriptExecutor)lDriver;
		// Scrolling down the page till the element is found		
     //   js.executeScript("arguments[0].scrollIntoView();", editSubmitBtn );
		editSubmitBtn.click();
	}
	
	
	
}
