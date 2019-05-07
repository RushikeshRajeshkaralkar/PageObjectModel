package com.crm.qa.pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import com.crm.qa.base.TestBase;

public class loginpage extends TestBase {
	
	@FindBy(xpath="//input[@name='username']")
	WebElement Username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@class='btn btn-small' and @type='submit']")
	WebElement submit;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement LogoImage;
	
	
	public loginpage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	
	
	public Homepage Login(String username,String password)
	{
		Username.sendKeys(username);
		Password.sendKeys(password);
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	   js.executeScript("arguments[0].click();", submit);
	   return new Homepage();
		
	}
	


	public boolean validateCRMImage() {
		// TODO Auto-generated method stub
		return LogoImage.isDisplayed();
	}



	public String validateLoginPageTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}
	

}
