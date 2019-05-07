package com.crm.qa.testes;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Contact;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.loginpage;
import com.crm.qa.util.TestUtil;

public class ContacsPageTest extends TestBase{
	loginpage Loginpage;
	Homepage homepage;
	Contact contact;
	String sheetName = "contacts";
	public ContacsPageTest() {
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
	public void SelectByContactName()
	{
		homepage=new Homepage();
		homepage.ClickOnContact();
		contact=new Contact();
		contact.SelectContactByName(pro.getProperty("name"));
		
	}
	
	

	
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=2,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company){
		homepage.ClickOnNewContact();
		contact=new Contact();
		contact.createNewContact(title, firstName, lastName, company);
		
		
		
	}
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
	

}
