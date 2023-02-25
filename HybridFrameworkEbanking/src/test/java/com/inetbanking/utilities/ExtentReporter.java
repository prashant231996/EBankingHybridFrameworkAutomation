package com.inetbanking.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports extentReport;
	
	public static  ExtentReports getExtentReports()
	{
		String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName="Test-Report"+timeStamp+".html";
		String extentReportPath=System.getProperty("user.dir")+"\\Reports\\"+reportName;
		//String extentReportPath="./Reports+report.html";
		//String extentReportPath = System.getProperty("user.dir")+"\\reports\\extentreport.html";
		ExtentHtmlReporter extentHtml=new ExtentHtmlReporter(extentReportPath);
		
		extentHtml.config().setReportName("E-Banking AUtomation");
		extentHtml.config().setDocumentTitle("Automation Test Results");
		extentHtml.config().setTheme(Theme.DARK);
		
		extentReport=new ExtentReports();
		extentReport.attachReporter(extentHtml);
		
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("Tested By", "Prashant Shivaji More");

		return extentReport;
	}
	
	

}
