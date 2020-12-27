package com.excel.util;

import java.util.ArrayList;

public class TestDataUtil {

	static Xls_Reader reader;

	public static ArrayList<Object[]> getDataFromExcel() {

		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		try {
			reader = new Xls_Reader(
					"C:\\Selenium\\Last\\DataDrivenFramework\\src\\main\\java\\com\\excel\\util\\RegTestData.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int rowNum = 2; rowNum <= reader.getRowCount("RegTestData"); rowNum++) {
			String firstname = reader.getCellData("RegTestData", "firstname", rowNum);
			String lastname = reader.getCellData("RegTestData", "lastname", rowNum);
			String address1 = reader.getCellData("RegTestData", "address1", rowNum);
			String address2 = reader.getCellData("RegTestData", "address2", rowNum);
			String city = reader.getCellData("RegTestData", "city", rowNum);
			String state = reader.getCellData("RegTestData", "state", rowNum);
			String zipcode = reader.getCellData("RegTestData", "zipcode", rowNum);
			String emailaddress = reader.getCellData("RegTestData", "emailaddress", rowNum);
			
			Object oj[] = {firstname, lastname, address1, address2, city, state, zipcode, emailaddress};
			
			myData.add(oj);

		}
		
		return myData;
	}

}
