package com.inetbanking.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;



public class TC01_LoginTest extends BaseClass{
	
	public LoginPage lp;
	
	@Test
	public void loginTest()
	{
		lp=new LoginPage(driver);
		lp.doLogin(userName, passWord);
		//lp.doLogin(username, pwd);
		log.info("Log into the application...");
		System.out.println("Page Title="+driver.getTitle());
	//	Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
		if(driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true, "Test Case Passed..");
		log.info("Logged ito application successfully..");
		}
		else
		{
			Assert.assertTrue(false,"Test Case Failed..");
			log.info("Not login to application successfully..");
		}
	}

}
