package com.naeenautomations.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomations.Pages.YourStorePage;
import com.naveenautomations.base.TestBase;

public class YourStorePageTest extends TestBase {


	public YourStorePage yp;
	
	@BeforeMethod
	public void startBrowserSession() {
		initiliazation();

		yp=  new YourStorePage();
	}
	
	
	@Test
	public void testSomthing() {
		
		
		yp.clickMyAccountBtn();
		
	}
	
	
	@AfterMethod
	 
	public void quitBrowserSession() {

		quitBrowser();
	}
}
