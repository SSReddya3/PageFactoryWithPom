package com.obs.pages;

import java.util.HashMap;
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

public class P4NewAccountPage {

	Logger log = (Logger) LogManager.getLogger(P4NewAccountPage.class);
	WebDriver driver;
	ExtentTest test;
	

	@FindBy(xpath="//p[normalize-space()='New Account']")
	WebElement NewAccount;
	
	@FindBy(xpath = "//input[@name='account_number']")
	WebElement AccountNumber;
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@placeholder='(optional)']")
	WebElement middleName;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='generated_password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='pin']")
	WebElement pin;
	
	@FindBy(xpath="//input[@name='balance']")
	WebElement balance;
	
	@FindBy(xpath="//button[@class='btn btn-primary mr-2']")
	WebElement Save;
	
	@FindBy(xpath="//a[normalize-space()='Cancel']")
	WebElement Cancel;
	
	public P4NewAccountPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		driver.manage().timeouts().implicitlyWait(StandardWaitTimes.waitTime, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	//New Account Page
	@SuppressWarnings("unlikely-arg-type")
	public void NewUserCreation(HashMap<String,String> data) {
		try {
			test.log(Status.PASS, "  successfully NewUser ");
			log.info(" AccountManagement page is displayed successfully");
			
		
		NewAccount.click();
		AccountNumber.sendKeys(data.get("accountNumber"));
		FirstName.sendKeys(data.get("FirstName"));
		middleName.sendKeys(data.get("middleName"));
		lastName.sendKeys(data.get("lastName"));
		email.sendKeys(data.get("email"));
		password.sendKeys(data.get("password"));
		pin.sendKeys(data.get("pin"));
		balance.sendKeys(data.get("balance"));
		Save.click();
		
		}catch (Exception e) {
			test.log(Status.FAIL, "AccountManagement  page is NOT displayed");
			log.info("AccountManagement  page is NOT displayed");

		}

	}
	
	public void createNewAccount(String accNo, String fname,String lname,String midName,String emailId,String apwd,int pinNum,int begBalance) {
		try {
		AccountNumber.sendKeys(accNo);
		FirstName.sendKeys(fname);
		lastName.sendKeys(lname);
		middleName.sendKeys(midName);
		email.sendKeys(emailId);
		password.sendKeys(apwd);
		pin.sendKeys(String.valueOf(pinNum));
		balance.sendKeys(String.valueOf(begBalance));
		Save.click();
		test.log(Status.PASS, "Account number is created successfully");
		}catch(Exception e) {
			test.log(Status.FAIL, "Account Number is not created");
		}
		
	}
	
}
