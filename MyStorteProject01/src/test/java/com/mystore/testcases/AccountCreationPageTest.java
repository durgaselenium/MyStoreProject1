package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviderTest;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class AccountCreationPageTest extends BaseClass{
 IndexPage  indexpage;
 LoginPage loginpage;
 HomePage homepage;
 AccountCreationPage accountcreationpage;
 
 @Parameters("browser")
 @BeforeMethod(groups= {"smoke","sanity","Regression"})	
 public void setUp(String browser) {
 launchApp(browser);	
	}	

 @AfterMethod(groups= {"smoke","sanity","Regression"})
 public void tearDown() {
	 getDriver().quit();	
	}
	
 @Test(dataProvider="emailCredentials",dataProviderClass=DataProviderTest.class,groups="sanity")
 public void verifyCreateAccountPageTest(String emailID) throws InterruptedException {
	 
Log.startTestCase("verifyCreateAccountPageTest");	 
  indexpage = new IndexPage();
  loginpage = indexpage.clickOnSignIn();
//  accountcreationpage = loginpage.createNewAccount("sample987@gmail.com");
  accountcreationpage = loginpage.createNewAccount(emailID);
  boolean result = accountcreationpage.validateAccountCreatePage();
  Thread.sleep(3000);
  
  Assert.assertTrue(result);
 Log.endTestCase("verifyCreateAccountPageTest");
  
	}
	
	
}
