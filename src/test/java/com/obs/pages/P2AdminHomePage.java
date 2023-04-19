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

public class P2AdminHomePage {

	Logger log = (Logger) LogManager.getLogger(P2AdminHomePage.class);
	WebDriver driver;
	ExtentTest test;
	
	@FindBy(xpath="//h1[normalize-space()='Welcome to Online Banking System']")
	WebElement HomePageText;
	
	@FindBy(xpath="//p[normalize-space()='Account Management']")
	WebElement AccountManagement;
	
	@FindBy(xpath="//p[normalize-space()='New Account']")
	WebElement NewAccount;
	
	@FindBy(xpath="//p[normalize-space()='Manage Account']")
	WebElement ManageAccount;
	
	
	@FindBy(xpath="//p[normalize-space()='Transaction']")
	WebElement Transaction;
	
	@FindBy(xpath="//p[normalize-space()='Announcements']")
	WebElement Announcements;
	
	@FindBy(xpath="//span[@class='ml-3']")
	WebElement ProfileIcon;
	
	
	@FindBy(xpath="//a[normalize-space()='My Account']")
	WebElement MyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement Logout;
	
	public P2AdminHomePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		driver.manage().timeouts().implicitlyWait(StandardWaitTimes.waitTime, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}
	
	//Verify home page text
	public void verifyHomePageText() {
		if(HomePageText.isDisplayed()) {
			Assert.assertTrue(true, "Home page is displayed successfully");
			test.log(Status.PASS, "Home page is displayed successfully");
			log.info("Home page is displayed successfully");
		}else {
			Assert.assertTrue(false, "Home page is NOT displayed");
			test.log(Status.FAIL, "Home page is NOT displayed");
			log.info("Home page is NOT displayed");
		}
	}
	
	//Click on Account management
	public void clickOnAccMgmt() {
		try {
			test.log(Status.PASS, " AccountManagement Page is displayed successfully ");
			log.info(" AccountManagement page is displayed successfully");
			
		AccountManagement.click();
		}catch (Exception e) {
			test.log(Status.FAIL, "AccountManagement  page is NOT displayed");
			log.info("AccountManagement  page is NOT displayed");

		}
	}
	
	//Click on Transactions
	public void transaction() {
		try {
			test.log(Status.PASS, " Transaction Page is displayed successfully ");
			log.info(" Transaction page is displayed successfully");
			
		Transaction.click();
		
		}catch (Exception e) {
			test.log(Status.FAIL, "Transaction  page is NOT displayed");
			log.info("Transaction  page is NOT displayed");
		}
	}
	
	//Click on announcements
	public void announcements() {
		try {
			test.log(Status.PASS, " Announcements Page is displayed successfully ");
			log.info(" Announcements page is displayed successfully");
			
		
		Announcements.click();
		
		}catch (Exception e) {
			test.log(Status.FAIL, "Announcements  page is NOT displayed");
			log.info("Announcements  page is NOT displayed");
		}
	}
	
	//For logout of admin user
	public void logout() throws InterruptedException {
			Thread.sleep(5000);
			ProfileIcon.click();
			Logout.click();
	}

	

	public static boolean isDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
