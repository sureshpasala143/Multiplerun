package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowseFactory {
	static WebDriver driver;
	public static WebDriver startBrowser(String browser, String url){
		if(browser.equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.Firefox.driver","E:\\Selenium jars\\geckodriver-v0.19.0-win32\\geckodriver.exe");
			driver= new FirefoxDriver();
			
		}
		else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","E:\\Selenium jars\\chromedriver_win32\\chromedriver.exe");
						driver= new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.chrome.driver","E:\\Selenium jars\\IEdriver\\IEDriverServer.exe");
			
		//	E:\Selenium jars\IEdriver
			driver= new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

}
