package com.qa.data;

import java.util.ArrayList;

import com.qa.utils.Xls_Reader;

public class ExcelDataReader {
	
Xls_Reader reader = new Xls_Reader("C:\\Users\\vishw\\Desktop\\HomePageTestData.xlsx");
	
	public ArrayList<String> retrivingExcel() {
	
		
		// Row: 4, Column: 2
	ArrayList<String> itemTypeanddescription = new ArrayList<String>();
	int counter=0;
	for(int j=2; j<=reader.getRowCount("Sheet1"); j++) {
		
	for(int i=0; i<reader.getColumnCount("Sheet1"); i++) {
		itemTypeanddescription.add(counter, reader.getCellData("Sheet1", i, j));		
		counter++;
	}
	
	}
	
	return itemTypeanddescription;
	}

}
