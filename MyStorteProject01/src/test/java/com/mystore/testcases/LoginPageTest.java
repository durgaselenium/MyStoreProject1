package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviderTest;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTest extends BaseClass{
 IndexPage indexpage;
 LoginPage loginpage;
 HomePage homepage;
 
 @Parameters("browser")
@BeforeMethod(groups= {"smoke","sanity","Regression"})	
public void	setUp(String browser) {
 launchApp(browser);	
}

 @AfterMethod(groups= {"smoke","sanity","Regression"})
 public void tearDown() {
	 getDriver().quit();
 }
 
@Test(dataProvider="Credentials",dataProviderClass=DataProviderTest.class,groups= {"smoke","sanity"})
public void loginTest(String un,String pwd) throws InterruptedException{
	
 Log.startTestCase("loginTest");
    indexpage = new IndexPage();
 Log.info("User is going to click on SigIn");
   loginpage = indexpage.clickOnSignIn();
 Log.info("Enter usernamae and password"); 
//  homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
    homepage = loginpage.login(un, pwd);
    
  String actualURL = homepage.getCurrURL();
   String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
 Log.info("Verify the user is able to login");
   Thread.sleep(3000);
   Assert.assertEquals(actualURL, expectedURL);
 Log.info("Login in Success"); 
 Log.endTestCase("loginTest"); 

}	
	
	
}
