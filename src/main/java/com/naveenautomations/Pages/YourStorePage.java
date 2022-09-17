package com.naveenautomations.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomations.base.TestBase;

public class YourStorePage extends TestBase {
	
	public YourStorePage() {
		
		PageFactory.initElements(webDriver,this);
	}

	@FindBy(css = "#top-links ul li:nth-of-type(2) span:first-of-type")
	private WebElement myAccountBtn;

	@FindBy(css = "#top-links ul.dropdown-menu li:last-of-type a")
	private WebElement loginBtn;

	public void clickMyAccountBtn() { 

		myAccountBtn.click();
	}
	
	public AccountLogin clickLoginBtn() {

		loginBtn.click();
		return new AccountLogin();
		
	}

}
