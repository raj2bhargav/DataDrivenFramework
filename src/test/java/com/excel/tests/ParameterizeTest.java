package com.excel.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.util.Xls_Reader;

public class ParameterizeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Xls_Reader reader = new Xls_Reader(
				"C:\\Selenium\\Last\\DataDrivenFramework\\src\\main\\java\\com\\excel\\util\\RegTestData.xlsx");
		String sheetName = "RegTestData";

		int rowCount = reader.getRowCount(sheetName);

		reader.addColumn(sheetName, "Status");

		System.setProperty("webdriver.driver.chrome", "C:\\Selenium\\SeleniumJars\\NewDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=");

		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {

			String firstname = reader.getCellData(sheetName, "firstname", rowNum);
			String lastname = reader.getCellData(sheetName, "lastname", rowNum);
			String address1 = reader.getCellData(sheetName, "address1", rowNum);
			String address2 = reader.getCellData(sheetName, "address2", rowNum);
			String city = reader.getCellData(sheetName, "city", rowNum);
			String state = reader.getCellData(sheetName, "state", rowNum);
			String zipcode = reader.getCellData(sheetName, "zipcode", rowNum);
			String emailaddress = reader.getCellData(sheetName, "emailaddress", rowNum);
			
			driver.findElement(By.id("firstname")).clear();
			driver.findElement(By.id("firstname")).sendKeys(firstname);
			
			driver.findElement(By.id("lastname")).clear();
			driver.findElement(By.id("lastname")).sendKeys(lastname);
			
			driver.findElement(By.id("address1")).clear();
			driver.findElement(By.id("address1")).sendKeys(address1);
			
			driver.findElement(By.id("address2")).clear();
			driver.findElement(By.id("address2")).sendKeys(address2);
			
			driver.findElement(By.id("city")).clear();
			driver.findElement(By.id("city")).sendKeys(city);

			Select select = new Select(driver.findElement(By.id("state")));
			select.selectByVisibleText(state);

			driver.findElement(By.id("zip")).clear();
			driver.findElement(By.id("zip")).sendKeys(zipcode);
			
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(emailaddress);
			
			driver.findElement(By.id("retype_email")).clear();
			driver.findElement(By.id("retype_email")).sendKeys(emailaddress);
			
			reader.setCellData(sheetName, "Status", rowNum, "Pass"); //write the data into the cell.

		}

	}

}
