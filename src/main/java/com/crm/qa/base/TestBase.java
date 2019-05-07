package com.crm.qa.base;

import java.awt.Transparency;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {

	
	
	
	
	    public static WebDriver driver;
	    
	    public static Properties pro;
	    
	     public TestBase() {
			// TODO Auto-generated constructor stub
	    	 
	    	 
	    	 
	    	 try {
	    		 pro=new Properties();
	    		 FileInputStream file=new FileInputStream("C:\\Users\\Rushikesh\\Desktop\\SeleniumAutomation\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
	    		 pro.load(file);
	    		 
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	     
	     
	     public static void initialization(){
	 		String browserName = pro.getProperty("browser");
	 		
	 		if(browserName.equals("chrome")){
	 			System.setProperty("webdriver.chrome.driver", "A:/chromedriver.exe");	
	 			driver = new ChromeDriver(); 
	 		}
	 		else if(browserName.equals("FF")){
	 			System.setProperty("webdriver.gecko.driver", "A:/geckodriver.exe");	
	 			driver = new FirefoxDriver(); 
	 		}
	 		
	 		
	 	
	 		
	 		driver.manage().window().maximize();
	 		driver.manage().deleteAllCookies();
	 		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	 		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	 		
	 		driver.get(pro.getProperty("url"));
	 		
	 	}
}
