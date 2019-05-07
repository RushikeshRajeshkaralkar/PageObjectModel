package com.crm.qa.testes;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.loginpage;
import com.crm.qa.util.TestUtil;

public class HomepageTest extends TestBase {

	loginpage Loginpage;
	Homepage homepage;
	public HomepageTest() {
		// TODO Auto-generated constructor stub
		super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		Loginpage = new loginpage();
		homepage=Loginpage.Login(pro.getProperty("username"), pro.getProperty("password"));
		homepage=new Homepage();
		TestUtil.switchToFrame();
		
	}
	
	@Test(priority=1)
	public void clickOnContacs()
	{
		homepage=new Homepage();
		homepage.ClickOnContact();
	}
	
	@Test(priority=2)
	public void ClickOnNewContact()
	{
		homepage=new Homepage();
		homepage.ClickOnContact();
		homepage.ClickOnNewContact();
		
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
	

}
