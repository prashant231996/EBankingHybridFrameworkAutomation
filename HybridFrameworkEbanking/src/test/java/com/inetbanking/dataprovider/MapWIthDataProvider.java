package com.inetbanking.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.testcases.BaseClass;

public class MapWIthDataProvider extends BaseClass{
	
	
	@DataProvider(name="testData")
	public Object[][] dataProviderMethod() throws IOException
	{
	     String excelFilePath=".\\src\\test\\resources\\testData.xlsx";
	     File file=new File(excelFilePath);
	     FileInputStream fis=new FileInputStream(file);
	     XSSFWorkbook wb=new XSSFWorkbook(fis);
	    // XSSFSheet sh=wb.getSheet("NEW CUSTOMER");
	     XSSFSheet sh=wb.getSheet(sheetName);
	     int rowCount=sh.getLastRowNum();
	     int colCount=sh.getRow(0).getLastCellNum();
	     
	     Object[][]data=new Object[rowCount][1];
	     Map<Object,Object>dataMap=new HashMap<Object, Object>();
	     for(int i=0;i<rowCount;i++)
	     {
	    	 for(int j=0;j<colCount;j++)
	    	 {
	    		 dataMap.put(sh.getRow(0).getCell(j).toString(), sh.getRow(i+1).getCell(j).toString());
	    	 }
	    	 data[i][0]=dataMap;
	     }
		
		return data;
	}

}
