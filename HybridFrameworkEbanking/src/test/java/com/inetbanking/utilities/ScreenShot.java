package com.inetbanking.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	
	public static String getScreenShot(WebDriver driver, String resultName)
	{
		String screenShotPath=System.getProperty("user.dir")+"\\Screenshots\\"+resultName+".png";
		TakesScreenshot ts=(TakesScreenshot)driver;
	    File src=ts.getScreenshotAs(OutputType.FILE);
	    try {
			FileUtils.copyFile(src, new File(screenShotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return screenShotPath;
	}

}
