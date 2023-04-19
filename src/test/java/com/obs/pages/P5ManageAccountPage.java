package com.obs.pages;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.obs.common.StandardWaitTimes;

public class P5ManageAccountPage {

	Logger log = (Logger) LogManager.getLogger(P4NewAccountPage.class);
	WebDriver driver;
	ExtentTest test;
	
	@FindBy(xpath="//p[normalize-space()='Account Management']")
	WebElement accountManagement;
	
	@FindBy(xpath="//p[normalize-space()='Manage Account']")
	WebElement ManageAccount;
	
	
	@FindBy(xpath="//a[@class='btn btn-flat btn-primary']")
	WebElement CreateNewAccount;
	
	@FindBy(xpath = "//input[@type='search' and @class='form-control form-control-sm' ]")
	WebElement SearchAccount;
	
	
	@FindBy(xpath="//tbody/tr[1]/td[7]/button[1]")
	WebElement Action;

	@FindBy(xpath="    //div[@class='dropdown-menu show']//a[@class='dropdown-item edit_data'][normalize-space()='Edit']  ")
	WebElement Edit;

	@FindBy(xpath="//div[@class='dropdown-menu show']//a[@class='dropdown-item delete_data'][normalize-space()='Delete']")
	WebElement Delete;

	//*[@id='confirm']
	@FindBy(xpath="//button[@id='confirm' and text()='Continue']")
	WebElement confirmDelete;
	
	
	public P5ManageAccountPage(WebDriver driver, ExtentTest test) 
	{
	
		this.driver=driver;
		this.test=test;
		driver.manage().timeouts().implicitlyWait(StandardWaitTimes.waitTime, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickonmanageacnt()
	{
		try {
			test.log(Status.PASS, "Manage Account page is displayed successfully");
			log.info("Manage Account page is displayed successfully");
			
		accountManagement.click();
		ManageAccount.click();
		 
		}catch (Exception e) {
			test.log(Status.FAIL, "Manage Account page is NOT displayed");
			log.info("Manage Account page is NOT displayed");

		}
	}
	
	public void SearchUserInManageAccount(String sacc)
	{
		try {
			test.log(Status.PASS, "SearchAccount is displayed successfully");
			log.info("SearchAccount is displayed successfully");
			
		      SearchAccount.sendKeys(sacc);
		  
		}catch (Exception e) {
			test.log(Status.FAIL, "SearchAccount is NOT displayed");
			log.info("SearchAccount is NOT displayed");

		}
	}
	
	public void deleteaccount()
	{
		Action.click();
		Delete.click();
		confirmDelete.click();
	}


	
	
	
	
	
	
	
	
	
	
	

}
