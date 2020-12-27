package com.excel.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.util.Xls_Reader;

public class WebTableHandle {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.driver.chrome", "C:\\Selenium\\SeleniumJars\\NewDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.get("https://www.w3schools.com/html/html_tables.asp");

		// *[@id="customers"]/tbody/tr[2]/td[1]
		// *[@id="customers"]/tbody/tr[3]/td[1]
		// *[@id="customers"]/tbody/tr[7]/td[1]

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		System.out.println("Total Number of rows = " + rows.size());

		int rowCount = rows.size();

		Xls_Reader reader = new Xls_Reader(
				"C:\\Selenium\\Last\\DataDrivenFramework\\src\\main\\java\\com\\excel\\util\\SampleExcel.xlsx");

		if (!reader.isSheetExist("TableName")) {
			reader.addSheet("TableData");

			reader.addColumn("TableData", "CompanyName");
			reader.addColumn("TableData", "ContactName");

		}

		String beforeXpath_company = "//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath_company = "]/td[1]";

		for (int i = 2; i <= rowCount; i++) {
			String actualXpath_company = beforeXpath_company + i + afterXpath_company;
			String companyName = driver.findElement(By.xpath(actualXpath_company)).getText();
			System.out.println(companyName);

			reader.setCellData("TableData", "CompanyName", i, companyName);
		}

		System.out.println("-----------------------------");

		// *[@id="customers"]/tbody/tr[2]/td[2]
		// *[@id="customers"]/tbody/tr[7]/td[2]

		String beforeXpath_contact = "//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath_contact = "]/td[1]";

		for (int i = 2; i <= rowCount; i++) {
			String actualXpath_contact = beforeXpath_contact + i + afterXpath_contact;
			String contactName = driver.findElement(By.xpath(actualXpath_contact)).getText();
			System.out.println(contactName);

			reader.setCellData("TableData", "ContactName", i, contactName);
		}

	}

}
