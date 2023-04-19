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
import com.obs.pages.P8TransactionsPage;
import com.obs.pages.P7UserHomePage;
import com.obs.pages.P6UserLoginPage;
import com.obs.utilities.RandomNumber;
import com.obs.utilities.ReadProperties;

public class T2VerifyDepositAmount extends BasePage{

	String url,userName,Password;
	long accountNumber = RandomNumber.getRandomNumber();
	String emailId = "onlinetestinghelp"+accountNumber+"@gmail.com";
	String userPwd = "123456";
	String deposit_Amount = "10000";
	int expected_Balance = 1010000;

	@Test
	public void verifyDepositAmount() throws IOException, InterruptedException {
		
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
		testData.put("FirstName", "Venkat");
		testData.put("middleName", "Krishna");
		testData.put("lastName", "VK");
		testData.put("email", emailId);
		testData.put("password", userPwd);
		testData.put("pin", "1234");
		testData.put("balance", "100000");
		
		P4NewAccountPage newAccount = new P4NewAccountPage(driver, test);
		newAccount.NewUserCreation(testData);
		//Deposit Operation
		P8TransactionsPage transactions = new P8TransactionsPage(driver, test);
		transactions.clickOnTransaction();
		transactions.clickonDeposit();
		transactions.deposit_Amount(String.valueOf(accountNumber), deposit_Amount);
		
		adminHomePage.logout();
		
		//User Login
		login.gotoUserLogin();
		P6UserLoginPage userPage = new P6UserLoginPage(driver, test);
		userPage.userLogin(emailId, userPwd);
		
		P7UserHomePage userHome = new P7UserHomePage(driver, test);
		userHome.verifyWelcomeText();
		
		//Verify Deposit Amount
		userHome.verifyAmount(expected_Balance);
		
		//Logout
		userHome.logout();
		

	}
	
}
