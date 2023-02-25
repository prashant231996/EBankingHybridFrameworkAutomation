package com.inetbanking.testcases;

import org.testng.annotations.Test;

import com.inetbanking.pageobjects.EditCustomerPage;
import com.inetbanking.pageobjects.LoginPage;

public class TC04_EditCustomer extends BaseClass{
	
	@Test
	public void editCustomerTest() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.doLogin(userName, passWord);
		EditCustomerPage ecp=new EditCustomerPage(driver);
		ecp.navigateToCustomerEdit("48345");
	    ecp.editCustomer("Prashant", "ICH.");
	}

}
