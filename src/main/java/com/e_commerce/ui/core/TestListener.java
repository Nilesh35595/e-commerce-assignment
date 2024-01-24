package com.e_commerce.ui.core;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.e_commerce.ui.utility.Config;
import com.e_commerce.ui.utility.ExtentReportUtils;
import com.e_commerce.ui.utility.FileUtils;


public class TestListener implements ITestListener {

    public static ExtentTest extentTest ;
	String browser = Config.getBrowser();
	protected static final Logger LOGGER = LogManager.getLogger(TestListener.class);
	
	@Override
	public void onTestStart(ITestResult iTestResult) {
		DriverManager.createInstance(browser);
		extentTest = BaseTestPage.extentReports.createTest(iTestResult.getMethod().getMethodName());
	} 
	
	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		LOGGER.info("onTestSuccess method - " + iTestResult.getMethod().getMethodName() + " succeed");
		ExtentReportUtils.extentReports.flush();
		DriverManager.getDriver().quit();		
	}
	
	@Override
	public void onTestFailure(ITestResult iTestResult) {
		
		LOGGER.info("onTestFailure method - " + iTestResult.getMethod().getMethodName() + " failed");
	    String ssFileName = FileUtils.generateScreenshotFileName(iTestResult);
	    BaseTestPage.captureScreenshot(ssFileName);
	    extentTest.addScreenCaptureFromPath(ssFileName);
		ExtentReportUtils.extentReports.flush();
		DriverManager.getDriver().quit();
	}
}
