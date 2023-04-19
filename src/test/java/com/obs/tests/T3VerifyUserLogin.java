package com.obs.tests;

import java.io.IOException;
import java.util.HashMap;

import javax.swing.text.Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.obs.base.BasePage;
import com.obs.pages.*;

import com.obs.pages.P4NewAccountPage;
import com.obs.pages.P1AdminLoginPage;
import com.obs.pages.P2AdminHomePage;
import com.obs.pages.P7UserHomePage;
import com.obs.pages.P6UserLoginPage;
import com.obs.utilities.RandomNumber;
import com.obs.utilities.ReadProperties;

public class T3VerifyUserLogin extends BasePage{
	
	
	
	String url,userName,Password;
	long accountNumber = RandomNumber.getRandomNumber();
	String emailId = "ss"+accountNumber+"@gmail.com";
	String userPwd = "123456";
	
	@Test
	public void verifyUserLogin() throws IOException, InterruptedException {

		
		url = ReadProperties.readProp("AdminURL");
		userName = ReadProperties.readProp("AdminUN");
		Password = ReadProperties.readProp("AdminPwd");
		
		P1AdminLoginPage login = new P1AdminLoginPage(driver,test);
		login.launchApp(url);
		login.login(userName, Password);
		
		P2AdminHomePage adminHomePage = new P2AdminHomePage(driver,test);
		adminHomePage.verifyHomePageText();
		
		//Click on account management
		adminHomePage.clickOnAccMgmt();
		
		//Click on New Account
		HashMap<String,String> testData = new HashMap<String,String>();
		testData.put("accountNumber", String.valueOf(accountNumber));
		testData.put("FirstName", "SS");
		testData.put("middleName", "Reddy");
		testData.put("lastName", "A");
		testData.put("email", emailId);
		testData.put("password", userPwd);
		testData.put("pin", "1234");
		testData.put("balance", "100000");
		
		P4NewAccountPage newAccount = new P4NewAccountPage(driver, test);
		newAccount.NewUserCreation(testData);
		adminHomePage.logout();
		
		//User Login
		login.gotoUserLogin();
		P6UserLoginPage userPage = new P6UserLoginPage(driver, test);
		userPage.userLogin(emailId, userPwd);
		
		//Verify welcome text
		P7UserHomePage userHome = new P7UserHomePage(driver, test);
		userHome.verifyWelcomeText();
		userHome.logout();
		

	}
	
}
