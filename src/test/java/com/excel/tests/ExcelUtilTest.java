package com.excel.tests;

import com.excel.util.Xls_Reader;

public class ExcelUtilTest {
	
	public static void main(String[] args) {
		
		Xls_Reader reader = new Xls_Reader(".\\src\\main\\java\\com\\excel\\util\\SampleExcel.xlsx");
		String sheetName = "login";
		
		System.out.println(reader.getCellData(sheetName, "username", 3));
		
		String data = reader.getCellData(sheetName, 0, 2);
		
		System.out.println(data);
		
		
		int rowCount = reader.getRowCount(sheetName);
		System.out.println("Total Row Count = " + rowCount);
		
		
		if(! reader.isSheetExist("Registration")) {
			reader.addSheet("Registration");
		}
		
		reader.setCellData(sheetName, "status", 2, "PASS");
		
		System.out.println(reader.getColumnCount(sheetName));
		
		System.out.println(reader.getCellData("Regsitration", "phonenumber", 2));
		System.out.println(reader.getCellData("Regsitration", "age", 2));
		
		
	}

}
