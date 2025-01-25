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
		try
		{
		lp=new LoginPage(driver);
		lp.doLogin(userName, passWord);
		log.info("Log into the application...");
	    Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
	    log.info("User "+userName+" logged into the application successfully.");
		lp.logoutFromApplication();
		log.info("User "+userName+" logged out from the application successfully.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}

}
