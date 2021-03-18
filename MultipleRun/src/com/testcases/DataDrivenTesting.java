package com.testcases;

import org.testng.annotations.Test;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Helper.ReadExcelFile;
import Helper.*;

public class DataDrivenTesting {
	
	WebDriver driver;
	 WebElement firstName;
	 WebElement lastName;
	 WebElement phone;
	 WebElement username;
	 WebElement pass;
	int ts=0;
	
	
	@BeforeMethod
	public void OpenApp()
	{
		System.setProperty("webdriver.chrome.driver","E:\\Selenium jars\\chromedriver_win32\\chromedriver.exe"); 
		driver=new ChromeDriver();
		driver.manage().window().maximize();
			// driver=new InternetExplorerDriver(); // this will launch IE
			
			 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			 
			driver.get("http://newtours.demoaut.com/mercuryregister.php"); 
	}
	
	@DataProvider(name="readExcel")
	public static Object[][] readExcelValues() throws IOException
	{
		// Passing File name and Excel sheet 
		Object[][]  datavalues=ReadExcelFile.readExcel("Test.xlsx", "Sheet1");
		
		return datavalues;
	}
		
		
  @Test(dataProvider="readExcel")
  public void ValidateDataDrivenTestingExcel(String fname,String lname,String mobile, String uname, String pwd) {
	  
	   firstName=driver.findElement(By.name("firstName"));
	   firstName.sendKeys(fname);
	   System.out.println(fname);
	   lastName=driver.findElement(By.name("lastName"));
	   lastName.sendKeys(lname);
	   
	   phone=driver.findElement(By.name("phone"));
	   phone.sendKeys(mobile); 
	   username=driver.findElement(By.id("email"));
	   username.sendKeys(uname);
	   pass=driver.findElement(By.name("password"));
	   pass.sendKeys(pwd);
	   pass=driver.findElement(By.name("confirmPassword"));
	   pass.sendKeys(pwd);
	   driver.findElement(By.name("register")).click();
	   
	   ts++;
		
				
  }
  
  @AfterMethod
  public void closeBrowser(ITestResult result) throws IOException
  {
	
	
	  // Method 1
	 	 if(ITestResult.FAILURE==result.getStatus())
	 	 {
	 		
	 		 System.out.println(" Test execution status -->"+result.getStatus());
	 		 System.out.println(" Name --> "+result.getName());
	 		Utility.takeScreenshots(driver,ts);
	 	 }
	 	 
	 	 if(ITestResult.SUCCESS==result.getStatus())
	 	 {
	 		
	 		 System.out.println(" Test execution status -->"+result.getStatus());
	 		 System.out.println(" Name --> "+result.getName());
	 		Utility.takeScreenshots(driver,ts);
	 	 }
	 	 
	 	 if(ITestResult.SKIP==result.getStatus())
	 	 {
	 		
	 		 System.out.println(" Test execution status -->"+result.getStatus());
	 		 System.out.println(" Name --> "+result.getName());
	 		Utility.takeScreenshots(driver,ts);
	 	 }
	 

	 	 // Method 2
	 	 //Utility.takeScreenshots(driver);
	  driver.close();
  }
  
  
}
