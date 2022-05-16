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

public class HomePageTest extends BaseClass {
 IndexPage indexpage;
 LoginPage loginpage;
 HomePage homepage;

 @Parameters("browser")
@BeforeMethod(groups= {"smoke","sanity","Regression"})	
public void setUp(String browser) {
launchApp(browser);	
}	

@AfterMethod(groups= {"smoke","sanity","Regression"})
public void tearDown() {
	getDriver().quit();	
}
	

/*@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
public void wishListTest(String uname, String pswd) throws Throwable {
	Log.startTestCase("wishListTest");
	indexPage= new IndexPage();
	loginPage=indexPage.clickOnSignIn();
	homePage=loginPage.login(uname,pswd,homePage);
	boolean result=homePage.validateMyWishList();
	Assert.assertTrue(result);
	Log.endTestCase("wishListTest");
}*/

@Test(priority=1,groups="smoke",dataProvider="Credentials",dataProviderClass=DataProviderTest.class)
public void wishListTest(String un,String pwd) throws InterruptedException {
	
Log.startTestCase("wishListTest");	
  indexpage = new IndexPage();
  loginpage = indexpage.clickOnSignIn();
//  homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
  homepage = loginpage.login(un, pwd);
  
  boolean result = homepage.validateMyWishList();
  Thread.sleep(3000);
  Assert.assertTrue(result);
Log.endTestCase("wishListTest");
 }

@Test(priority=2,groups="smoke",dataProvider="Credentials",dataProviderClass=DataProviderTest.class)
public void orderHistoryAndDetailsTest(String un,String pwd) throws InterruptedException {
	
Log.startTestCase("orderHistoryAndDetailsTest");	
  indexpage = new IndexPage();
  loginpage = indexpage.clickOnSignIn();
//  homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
  homepage = loginpage.login(un, pwd);
  
  boolean result = homepage.validateOrderHistory();
  Thread.sleep(3000);
  Assert.assertTrue(result);
Log.endTestCase("orderHistoryAndDetailsTest");  
}
	
}
