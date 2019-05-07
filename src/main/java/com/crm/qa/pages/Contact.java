package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class Contact extends TestBase {
	
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement FirstName;
	@FindBy(xpath="//input[@name='surname']")
	WebElement Surname;
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement Company;
	@FindBy(xpath="//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/input[2]")
	WebElement Submit;
	
	
	public void SelectContactByName(String name)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']/input[@name='contact_id']")).click();
	}
	

	public void createNewContact(String title, String firstName, String lastName, String company){
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@name='surname']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@name='client_lookup']")).sendKeys(company);
		driver.findElement(By.xpath("//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/input[2]")).click();
	
		
	}
	
	
	

}
