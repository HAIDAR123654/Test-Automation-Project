package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import com.constants.Env;
import com.utility.JsonUtility;

public class MyRetryAnalyzer implements IRetryAnalyzer{

//	private static final int MAX_NUMBER_OF_ATTEMPTS = 
//			Integer.parseInt(PropertiesUtils.readProperty(Env.DEV, "MAX_NUMBER_OF_ATTEMPTS"));
	private static final int MAX_NUMBER_OF_ATTEMPTS = JsonUtility.readJosn(Env.QA).getMAX_NUMBER_OF_ATTEMPTS();
	
	private static int curreentAttempts = 1;
	
	public boolean retry(ITestResult result) {
		if(curreentAttempts <= MAX_NUMBER_OF_ATTEMPTS) {
			curreentAttempts++;
			return true;
		}
		return false;
	}
}
