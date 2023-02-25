package com.inetbanking.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;

public class TC02_LoginTestDDT extends BaseClass{
	
	public LoginPage lp;
	
	@Test(dataProvider = "getLoginData",dataProviderClass = com.inetbanking.dataprovider.dataProvider.class )
	public void loginTestDDT(String username, String pwd)
	{
		lp=new LoginPage(driver);
	//	lp.doLogin(userName, passWord);
		lp.doLogin(username, pwd);
		log.info("Log into the application...");
		System.out.println("Page Title="+driver.getTitle());
		if(isAlertPresent()==true)
		{
			Assert.assertTrue(false);
			log.warn("Login Failed");
		//  lp.clicklogOutLink();
		  driver.switchTo().alert().accept(); //Close Alert
		  driver.switchTo().defaultContent(); //Switching back to default window.
		}
		else
		{
		  Assert.assertTrue(true);	
		  lp.clicklogOutLink();
		  driver.switchTo().alert().accept(); //Close Alert
		  driver.switchTo().defaultContent(); //Switching back to default window
		  log.info("Login Passed.");
		}
    }
	
}
