 package com.obs.pages;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.obs.common.StandardWaitTimes;

public class P3AccountManagementPage {

	Logger log = (Logger) LogManager.getLogger(P3AccountManagementPage.class);
	WebDriver driver;
	ExtentTest test;
	
	
	
	@FindBy(xpath="//p[normalize-space()='Account Management']")
	WebElement accountManagement;
	
	@FindBy(xpath="//p[normalize-space()='New Account']")
	WebElement NewAccount;
	
	@FindBy(xpath="//p[normalize-space()='Manage Account']")
	WebElement ManageAccount;
	

	@FindBy(xpath="//input[@name='account_number']")
	WebElement accountNumber;

	@FindBy(xpath="//input[@name='firstname']")
	WebElement FirstName;

	@FindBy(xpath="//input[@placeholder='(optional)']")
	WebElement MiddleName;
	
	 
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement LastName;
	

	@FindBy(xpath="//input[@name='email']")
	WebElement Email;

	@FindBy(xpath="//input[@name='generated_password']")
	WebElement Password;

	@FindBy(xpath="//button[@id='generate_pass']")
	WebElement AutoPassword;

	@FindBy(xpath="//input[@name='pin']")
	WebElement Pin;

	@FindBy(xpath="//input[@name='balance']")
	WebElement DepositAmount;

	@FindBy(xpath="//button[@class='btn btn-primary mr-2']")
	WebElement Save;

	@FindBy(xpath="//a[@class='btn btn-default']")
	WebElement Cancel;

	
	
	public P3AccountManagementPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		driver.manage().timeouts().implicitlyWait(StandardWaitTimes.waitTime, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	//Click on Account management
	public void clickOnnewacc() {
		try {
			test.log(Status.PASS, " AccountManagement Page is displayed successfully ");
			log.info(" AccountManagement page is displayed successfully");
			
			NewAccount.click();

		}catch (Exception e) {
			test.log(Status.FAIL, "AccountManagement  page is NOT displayed");
			log.info("AccountManagement  page is NOT displayed");

		}
		
	}
	
	
	
	
		
}
