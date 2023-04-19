package com.obs.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class T4CreateNewUserAndVerifyManageAcc extends BasePage {

	
	String url,username,password,UserURL;
	
	long accountnumber=RandomNumber.getRandomNumber();
	String emailid= "ss"+accountnumber+"@gmail.com";
	String userpwd="1234";
	//String sacc="ss";
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
		
		HashMap<String, String> data =new HashMap<String, String>();
		data.put("accountNumber", String.valueOf(accountnumber));
		data.put("FirstName", "ss");
		data.put("middleName", "Reddy");
		data.put("lastName", "A");
		data.put("email", emailid);
		data.put("password", userpwd);
		data.put("pin", "12345");
		data.put("balance", "10000");
			
	
		
		P4NewAccountPage na=new P4NewAccountPage(driver, test);
		na.NewUserCreation(data);
		
		P5ManageAccountPage ma= new P5ManageAccountPage(driver, test);
		
		
		ma.clickonmanageacnt();
		ma.SearchUserInManageAccount(sacc);
		
		home.logout();
		
		login.gotoUserLogin();
		//User Login
		P6UserLoginPage ul=new P6UserLoginPage(driver, test);
		ul.userLogin(emailid, userpwd);
		
		//Verify welcome text
		P7UserHomePage uh=new P7UserHomePage(driver, test);
		uh.verifyWelcomeText();
		
		uh.logout();
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
