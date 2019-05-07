package com.crm.qa.testes;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.loginpage;

import junit.framework.Assert;

import org.testng.annotations.*;

public class LoginTest extends TestBase {
	
	Homepage homepage;
	loginpage Loginpage;
	
	public LoginTest() {
		// TODO Auto-generated constructor stub
		super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		Loginpage = new loginpage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = Loginpage.validateLoginPageTitle();
		org.testng.Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest(){
		boolean flag = Loginpage.validateCRMImage();
		org.testng.Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest(){
		homepage = Loginpage.Login(pro.getProperty("username"), pro.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
