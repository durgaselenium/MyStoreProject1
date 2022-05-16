package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.utility.Log;

public class IndexPageTest extends BaseClass {
 IndexPage indexpage;

 @Parameters("browser")
@BeforeMethod(groups= {"smoke","sanity","Regression"})	
public void	setUp(String browser) {
launchApp(browser);	
}
@AfterMethod(groups= {"smoke","sanity","Regression"})
public void tearDown() {
	getDriver().quit();
}

@Test(priority=1,groups="smoke")
public void verifyLogo() {

Log.startTestCase("verifyLogo");	
  indexpage = new IndexPage();
  boolean result = indexpage.validateLogo();
  Assert.assertTrue(result);
Log.endTestCase("verifyLogo");  
}

@Test(priority=2,groups="smoke")
public void verifyTitle() throws InterruptedException {
	
Log.startTestCase("verifyTitle");	
  String actTitle = indexpage.getMyStoreTitle();
  Thread.sleep(3000);
  Assert.assertEquals(actTitle, "My Store");
Log.endTestCase("verifyTitle");   
}	
}
