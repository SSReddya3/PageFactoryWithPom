package com.obs.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import javax.swing.text.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.obs.base.BasePage;
import com.obs.pages.P1AdminLoginPage;
import com.obs.pages.P2AdminHomePage;
import com.obs.pages.P3AccountManagementPage;
import com.obs.pages.P4NewAccountPage;
import com.obs.pages.P6UserLoginPage;
import com.obs.pages.*;
import com.obs.utilities.RandomNumber;
import com.obs.utilities.ReadProperties;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T5CreateNewAccountAndVerifyManageAcc extends BasePage {

	
	String url,username,password;
	
		String accNo = String.valueOf(RandomNumber.getRandomNumber());
	
	String fname="SS" ;
	String lname ="arp" ;
	String midName="Reddy" ;
	String emailId="ss"+RandomNumber.getRandomNumber()+"@gmail.com" ;
	String apwd= "123";
	int pinNum= 123;
	int begBalance=1000;
	
	
	String sacc="SSReddy";
	
	
	
	
	
	@Test
	public void createnewuser() throws IOException, InterruptedException
	{
		
		
		url = ReadProperties.readProp("AdminURL");
		username = ReadProperties.readProp("AdminUN");
		password = ReadProperties.readProp("AdminPwd");
		
		


		P1AdminLoginPage login=new P1AdminLoginPage(driver,test);
		login.launchApp(url);
		login.login(username, password);
		
		P2AdminHomePage home=new P2AdminHomePage(driver, test);
		
		home.clickOnAccMgmt();
		
		P3AccountManagementPage acm=new P3AccountManagementPage(driver, test);
		acm.clickOnnewacc();
		
		
			
	
		
		P4NewAccountPage na=new P4NewAccountPage(driver, test);

            na.createNewAccount(accNo,fname, lname, midName, emailId,apwd,pinNum, begBalance);
			
          
          P5ManageAccountPage ma= new P5ManageAccountPage(driver, test);
		
         
          ma.clickonmanageacnt();
          ma.SearchUserInManageAccount(sacc);
  		
		
		home.logout();
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
