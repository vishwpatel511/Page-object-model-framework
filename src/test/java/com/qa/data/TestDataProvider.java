package com.qa.data;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utils.Xls_Reader;


public class TestDataProvider {
	
	static ExcelDataReader excelreader;
	static Xls_Reader reader;
	
	 @DataProvider
	  public static Object[][] dataforWeb() { 
		  Object[][] data;
		  excelreader = new ExcelDataReader();
		   	reader = new Xls_Reader("src\\main\\java\\com\\qa\\data\\HomePageTestData.xlsx");

		  data = new Object[reader.getRowCount("Sheet1") - 1][reader.getColumnCount("Sheet1")];
		
		  int counter = 0;
		  for(int i = 0; i<reader.getRowCount("Sheet1") - 1; i++) {
			  
			  for(int j = 0; j<reader.getColumnCount("Sheet1"); j++) {
			  
				  data[i][j] = excelreader.retrivingExcel().get(counter);
			  		counter++;
		  }

	  }
		return data;
		  }
		
}
