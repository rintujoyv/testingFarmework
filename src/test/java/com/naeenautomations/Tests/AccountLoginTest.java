package com.naeenautomations.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naveenautomations.Pages.AccountLogin;
import com.naveenautomations.Pages.MyAccountPage;
import com.naveenautomations.Pages.YourStorePage;
import com.naveenautomations.base.TestBase;
import com.navenautomations.Utils.ExcelUtils;

public class AccountLoginTest extends TestBase {

	YourStorePage yp;
	AccountLogin accountLogin;
	
	@BeforeMethod
	public void startBrowserSession() {
		initiliazation();
		yp= new YourStorePage();
		yp.clickMyAccountBtn();
		accountLogin=yp.clickLoginBtn(); 
		
	}

	@Test(dataProvider = "LoginData")
	public void verifyCustomerLogin(String userName, String password) {
		MyAccountPage map = accountLogin.login(userName, password);
		Assert.assertEquals(map.getTextFromMyAccount(), "My Account");
	}
	
	
	
	@DataProvider(name = "LoginData")
	String[][] dataProviderToLogin() throws Exception {

		String filePath = "./Book1.xlsx";
		int row = ExcelUtils.getRowsCount(filePath, "Sheet1");
		int col = ExcelUtils.getColumnCount(filePath, "Sheet1", row);

		String[][] logindata = new String[row][col];
		for (int i = 1; i <= row; i++) {
			for (int j = 0; j < col; j++) {
				logindata[i - 1][j] = ExcelUtils.getCellData(filePath, "Sheet1", i, j);
			}
		}

		return logindata;
	}

	@AfterMethod
 
	public void quitBrowserSession() {

		quitBrowser();
	}
}
