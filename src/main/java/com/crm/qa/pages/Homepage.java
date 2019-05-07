package com.crm.qa.pages;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.xml.xpath.XPath;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Homepage extends TestBase {
	
	
	
	@FindBy(xpath="//a[text()='Contacts']")
	WebElement Contacts;
	
	@FindBy(xpath="//a[text()='New Contact']")
	WebElement NewContacts;
	
	
	
public Homepage() {
	// TODO Auto-generated constructor stub
	PageFactory.initElements(driver, this);
}


public Contact ClickOnContact()
{
	Contacts.click();
	
	return new Contact();
}

public void ClickOnNewContact()
{
	Actions action=new Actions(driver); 
			action.moveToElement(Contacts).click(NewContacts).build().perform();
		
}
}
