package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviderTest;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

public class SearchResultPageTest extends BaseClass{
 IndexPage indexpage;
 SearchResultPage searchresultpage;
 AddToCartPage addtocartpage;
 
 @Parameters("browser")
 @BeforeMethod(groups= {"smoke","sanity","Regression"})	
 public void setUp(String browser) {
 launchApp(browser);	
 }
 
 @AfterMethod(groups= {"smoke","sanity","Regression"})
 public void tearDown() {
	 getDriver().quit();
}	

 @Test(groups="smoke",dataProvider="searchProduct1",dataProviderClass=DataProviderTest.class)
 public void isProductAvaiabilityTest(String productName) throws InterruptedException {

Log.startTestCase("isProductAvaiabilityTest");	 
  indexpage = new IndexPage();
//  searchresultpage = indexpage.searchProduct("t-shirt");
  searchresultpage = indexpage.searchProduct(productName); 
  boolean result = searchresultpage.isProductAvailable();
  Thread.sleep(3000);
  Assert.assertTrue(result);
Log.endTestCase("isProductAvaiabilityTest");	
 }
 
	
	
	
}
