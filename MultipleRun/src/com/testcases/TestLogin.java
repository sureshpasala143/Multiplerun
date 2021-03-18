package com.testcases;
import com.pages.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.loginPage;

import Helper.BrowseFactory;
import Helper.ReadExcelFile;

@SuppressWarnings("unused")
public class TestLogin {
	WebDriver driver;
	Actions action = new Actions(driver);
	@DataProvider(name="readExcel")
	public static Object[][] readExcelValues() throws IOException
	{
		// Passing File name and Excel sheet 
		Object[][]  datavalues=ReadExcelFile.readExcel("Test.xlsx", "Sheet1");
		
		return datavalues;
	}
	//Before test  param
	@BeforeTest
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver","E:\\Selenium jars\\chromedriver_win32\\chromedriver.exe"); 
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		    WebDriverWait myWaitVar = new WebDriverWait(driver, 30);
		}
	@Test(dataProvider="readExcel")
	  public void loginUser(String uname,String pswd, String item, String cnt) {
		 
		WebDriver driver=BrowseFactory.startBrowser("chrome", "https://www.amazon.in");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		loginPage log_in=PageFactory.initElements(driver, loginPage.class);
		log_in.login(uname,pswd,item,cnt);
		  //
		
			
					
	  }
	@AfterMethod
	public void close(){
		driver.close();
	}
	  
	

}
