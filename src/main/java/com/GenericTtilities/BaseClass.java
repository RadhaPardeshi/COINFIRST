package com.GenericTtilities;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.mysql.cj.jdbc.Driver;
import com.netBanking.ObjectRepository.pom.StaffLoginPage;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	public JavaUtility jUtil = new JavaUtility();
	public FileUtility fUtil =new FileUtility();
	public DatabaseUtility dUtil = new DatabaseUtility();
	public ExcelUtility eUtil = new ExcelUtility();
	public WebdiverUtility wUtil = new WebdiverUtility();

	@BeforeSuite
	public void openDBconeection() throws SQLException
	{
		dUtil.connectToDB();
		Reporter.log(" --- Connect to Database --- ");
	}

	
	@BeforeClass
	public void OpeningBrowser() throws IOException
	{
		String BROWSER = fUtil.readDataFromPropertyFile("browser");
		//String BROWSER = System.getProperty("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver= new EdgeDriver();
		}
		else
		{
			Reporter.log("Improper browser ",true);
		}
		sdriver = driver;
		Reporter.log("-- open the browser --",true);
		wUtil.maximizebrowser(driver);
		wUtil.implicitlyWaitStatement(driver, 10);
		
	}

	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
		Reporter.log("--- closing the browser ---");
	}

	@AfterSuite
	public void closeTheDBConnection() throws SQLException
	{
		dUtil.colseDBConnection();
		Reporter.log("--- closing the data base connection ---");

	}
	
}
