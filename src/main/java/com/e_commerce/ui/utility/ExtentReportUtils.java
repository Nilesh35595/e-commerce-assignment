package com.e_commerce.ui.utility;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtils {

	public static ExtentReports extentReports;
	
	 public static ExtentReports createReportInstance() {
	    	
	        String fileName = FileUtils.generateReportFileName();
	        extentReports = new ExtentReports();
	        ExtentSparkReporter sparkReport = new ExtentSparkReporter(fileName);
	        
	        sparkReport.config().setTheme(Theme.DARK);
	        sparkReport.config().setDocumentTitle(fileName);
	        sparkReport.config().setEncoding("utf-8");
	        sparkReport.config().setReportName(fileName);
	        sparkReport.config().setTimelineEnabled(true);
	 
	        extentReports.attachReporter(sparkReport);
	 
	        return extentReports;
	    }
	
	
}
