package com.obs.tests;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.obs.base.BasePage;
import com.obs.pages.P1AdminLoginPage;
import com.obs.pages.P2AdminHomePage;
import com.obs.pages.P5ManageAccountPage;
import com.obs.utilities.ReadProperties;

public class DelectAccount extends BasePage 
{

	String url,userName,Password;
	String sacc ="SSReddy";
	
	
	
	
	@Test(invocationCount = 5)
	public void delectaccount() throws IOException, InterruptedException
	{
		url=ReadProperties.readProp("AdminURL") ;
		userName=ReadProperties.readProp("AdminUN");
		Password=ReadProperties.readProp("AdminPwd");
		
		
		
		P1AdminLoginPage login=new P1AdminLoginPage(driver, test);
		
		login.launchApp(url);
		login.login(userName, Password);
		
		P5ManageAccountPage map=  new P5ManageAccountPage(driver, test);
		
		

		
		map.clickonmanageacnt();
		map.SearchUserInManageAccount(sacc);
		Thread.sleep(2000);
		map.deleteaccount();
		Thread.sleep(2000);
		map.SearchUserInManageAccount(sacc);
		Thread.sleep(5000);
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
