package com.e_commerce.ui.utility;

import java.io.File;
import java.time.LocalDateTime;

import org.testng.ITestResult;

public class FileUtils {

	
	public static String generateReportFileName() {
		LocalDateTime currentTime = LocalDateTime.now();
		String fileName = "test-reports"+File.separator+"product_order_"+currentTime+".html";
		return fileName;
	}
	
	public static String generateScreenshotFileName(ITestResult result) {
		LocalDateTime currentTime = LocalDateTime.now();
		String fileName = "screenshots"+File.separator+result.getMethod().getMethodName()+currentTime+".png";
	    return fileName;
	}
	
}
