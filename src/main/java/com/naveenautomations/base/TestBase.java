package com.naveenautomations.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.lang.System.Logger;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;


import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.BasicConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;

import com.navenautomations.Utils.Utils;
import com.navenautomations.Utils.WebDriverEvents;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver webDriver;
	public Properties prop;
	public static Logger logger;
	public static EventFiringWebDriver e_driver;
	public static WebDriverEvents events;

	public TestBase() {

		prop = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream(
					"C:\\JavaProject\\testingframework\\src\\main\\java\\com\\naveenautomations\\Config\\config.properties");
			try {

				// Load this file in that prop object
				prop.load(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@BeforeClass
	public void loggerSetUp() {

		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();

		logger.setLevel(Level.INFO);
	}

	public void initiliazation() {

		String branchName = prop.getProperty("browser");

		switch (branchName) {
		case "chrome":
			webDriver = WebDriverManager.chromedriver().create();
			break;
		case "firefox":
			webDriver = WebDriverManager.firefoxdriver().create();
			break;
		case "edge":
			webDriver = WebDriverManager.edgedriver().create();
			break;

		default:
			System.out.println("Verify you have passed the correct  browser name");
			break;
		}

		e_driver = new EventFiringWebDriver(webDriver);
		events = new WebDriverEvents();
		e_driver.register(events);
		webDriver = e_driver;

		webDriver.manage().window().maximize();
		webDriver.get(prop.getProperty("base_url"));
		webDriver.manage().deleteAllCookies();
		webDriver.manage().timeouts().pageLoadTimeout(Utils.PAGE_LOAD_WAIT, TimeUnit.SECONDS);
		webDriver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);

	}

	public void quitBrowser() {

		webDriver.quit();
	}
}
