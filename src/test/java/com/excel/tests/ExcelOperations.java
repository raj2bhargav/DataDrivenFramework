package com.excel.tests;

import com.excel.util.Xls_Reader;

public class ExcelOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Xls_Reader reader = new Xls_Reader(
				"C:\\Selenium\\Last\\DataDrivenFramework\\src\\main\\java\\com\\excel\\util\\RegTestData.xlsx");
		String sheetName = "RegTestData";
		
		//reader.addSheet("HomePage");
		
		if(! reader.addSheet("TestPage")) {
			reader.addSheet("TestPage");
		}
		
		
		
		
		

	}

}
