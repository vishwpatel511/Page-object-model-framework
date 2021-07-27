package com.qa.data;

import java.util.ArrayList;

import com.qa.utils.Xls_Reader;

public class PersonalInfoDataReader {
	
Xls_Reader reader = new Xls_Reader("src\\main\\java\\com\\qa\\data\\PersonalInfoPageData.xlsx");
	
	public ArrayList<String> retrivingExcel() {
	
	ArrayList<String> members = new ArrayList<String>();
	
	for(int j=2; j<=reader.getRowCount("Sheet1"); j++) {
		
	for(int i=0; i<reader.getColumnCount("Sheet1"); i++) {
		members.add(reader.getCellData("Sheet1", i, j));		
		}
	}
	System.out.println(members);
	return members;
	}
	
	}

