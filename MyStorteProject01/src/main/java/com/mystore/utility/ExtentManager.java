package com.mystore.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.mystore.base.BaseClass;


public class ExtentManager {

public static ExtentHtmlReporter htmlReporter;
public static ExtentReports extent;
public static ExtentTest test;

public static void setExtent() {
	
// htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-out/ExtentReports+"+"MyReports_"+BaseClass.getCurrentTime()+".html");
htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReprots/"+"MyReports.html");
htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
 
 //htmlReporter.config().setDocumentTitle("Automation Test Report");
 //htmlReporter.config().setReportName("OrangeHRM Test Automation Report");
 //htmlReporter.config().setTheme(Theme.DARK); //standed
 
 extent = new ExtentReports();
 extent.attachReporter(htmlReporter);
 
 extent.setSystemInfo("HostName", "MyHost");
 extent.setSystemInfo("ProjectName", "MyStorte Project01");
 extent.setSystemInfo("Tester", "Devi Veeravalli");
 extent.setSystemInfo("Browser", "Chrome");
 
}

public static void endReport() {
	extent.flush();
}


	
	
}
