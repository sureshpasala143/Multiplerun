package Helper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	
	public static void takeScreenshots(WebDriver driver, int tsn) throws IOException
	{
	      // Getting current date and time
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    //The below method will save the screen shot in d drive with name "screenshot.png"
       FileUtils.copyFile(scrFile, new File("E:\\Eclipse\\MultipleRun\\"+"TS_0"+tsn+timeStamp+"Jun2019.png"));
	}

}