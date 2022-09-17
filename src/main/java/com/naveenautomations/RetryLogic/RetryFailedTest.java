package com.naveenautomations.RetryLogic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.naveenautomations.base.TestBase;

public class RetryFailedTest extends TestBase implements IRetryAnalyzer{

	int counter=0;
	int maxRetry=1;
	
	@Override
	public boolean retry(ITestResult result) {
		
		logger.info("Test has failed, Retrying again "+result.getMethod().getMethodName());
		
		if(counter<maxRetry) {
			counter++;
			return true; 
		}
		return false;
	}

	
	 
}
