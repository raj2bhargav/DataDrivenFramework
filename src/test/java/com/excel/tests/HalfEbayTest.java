package com.excel.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excel.util.TestDataUtil;

public class HalfEbayTest {
	
	WebDriver driver;
	
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.driver.chrome", "C:\\Selenium\\SeleniumJars\\NewDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=");
	}
	
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		
		ArrayList<Object[]> testData = TestDataUtil.getDataFromExcel();
		return testData.iterator();
	}
	
	
	@Test(dataProvider = "getTestData")
	public void halfEbayRegPageTest(String firstname, String lastname, String address1, 
			String address2, String city, String state, String zipcode, String emailaddress) {
		
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

	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	

}
