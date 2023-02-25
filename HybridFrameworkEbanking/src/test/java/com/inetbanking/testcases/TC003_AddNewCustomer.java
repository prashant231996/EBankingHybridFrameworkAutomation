package com.inetbanking.testcases;

import java.util.Map;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.AddCustomerPage;
import com.inetbanking.pageobjects.LoginPage;

public class TC003_AddNewCustomer extends BaseClass{

	public LoginPage lp;
	public AddCustomerPage acp;
	
	@Test(dataProvider = "testData", dataProviderClass = com.inetbanking.dataprovider.MapWIthDataProvider.class)
	public void addNewCustomer(Map<String,String> dataMap) throws InterruptedException
	{
		lp=new LoginPage(driver);
		lp.doLogin(userName, passWord);
		//lp.doLogin(userrName, pwd);
		Thread.sleep(5000);
		acp=new AddCustomerPage(driver);
		acp.addNewCustomer(dataMap.get("name"), dataMap.get("gender"), dataMap.get("birthDate"),dataMap.get("birthMonth"),dataMap.get("birthYear"), dataMap.get("address"), dataMap.get("city"), dataMap.get("state"),dataMap.get("pincode"),dataMap.get("phoneno"), dataMap.get("email"), dataMap.get("password"));
	//	Assert.assertTrue(driver.getPageSource().contains("sss"));
	}
}
