package com.navenautomations.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.naveenautomations.base.TestBase;

public class Utils extends TestBase {

	public static final int PAGE_LOAD_WAIT = 30;
	public static final int IMPLICIT_WAIT = 10;

	public static void takeFailedTestScreeshots(String testcaseName) {

		// Get the current date and time
		String timeStamp = new SimpleDateFormat("YYYY.MM.DD.HH.MM.ss").format(new Date());

		// Save the Screenshot in a file
		File screenshotFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);

		// Save the screenshot
		try {
			FileUtils.copyFile(screenshotFile,
					new File("./FailedScreenshot\\" + "_" + testcaseName + "_" + timeStamp + ".jpeg"));
		} catch (IOException e) {
			System.out.println("Unable to save or take screen shot pf failed  test " + testcaseName);
		}

	}

	public static String generateRandomEmail() {

		String email = RandomStringUtils.randomNumeric(3);
		String emailID = "Rintu" + email + "@gmail.com";
		return emailID;
	}

	public static String generateRandomPassword() {

		String randomStringForPassword = RandomStringUtils.randomNumeric(3);
		String password = "Manger@" + randomStringForPassword;
		return password;
	}

	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {

		}
	}
}
