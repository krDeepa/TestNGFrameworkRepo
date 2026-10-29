package com.training.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotsImg {	
	
	
	public void captureScreenshot(WebDriver driver,String method) {
	
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File srcFile=screenshot.getScreenshotAs(OutputType.FILE);	
		
		  // Create a unique timestamp format (replace colons and spaces for valid file names)    
        	//String timeStamp=new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());
        
        //DateTimeFormatter and LocalDateTime are thread-safe and accurate
        String timeStamp1=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        
		String imagePath="Screenshorts\\screenshot"+"_"+timeStamp1+"_" +method+ ".jpg";
		File destFile=new File(imagePath);
		
		try {
			FileUtils.copyFile(srcFile, destFile);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}
}
