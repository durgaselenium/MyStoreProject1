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

public class AddToCartPageTest extends BaseClass{
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
 
/* Log.startTestCase("addToCartTest");
	index= new IndexPage();
	searchResultPage=index.searchProduct(productName);
	addToCartPage=searchResultPage.clickOnProduct();
	addToCartPage.enterQuantity(qty);
	addToCartPage.selectSize(size);
	addToCartPage.clickOnAddToCart();
	boolean result=addToCartPage.validateAddtoCart();
	Assert.assertTrue(result);
	Log.endTestCase("addToCartTest");*/
 
 
 @Test(groups= {"Regression","Sanity"},dataProvider="getProduct",dataProviderClass=DataProviderTest.class)
 public void addToCartTest(String productName,String qty,String size) throws Exception {
	 
  Log.startTestCase("addToCartTest");
	 indexpage = new IndexPage();
//	 searchresultpage = indexpage.searchProduct("t-shirt");
	 searchresultpage = indexpage.searchProduct(productName);
	 addtocartpage = searchresultpage.clickOnProduct();
	  //Thread.sleep(3000);
//	 addtocartpage.enterQuality("2");
	 addtocartpage.enterQuality(qty);
	 
//	 addtocartpage.selectSize("M");
	 addtocartpage.selectSize(size);
	 addtocartpage.clickOnAddToCart();
	// Thread.sleep(3000);
	 boolean result = addtocartpage.validateAddToCart();
	// Thread.sleep(3000);
	Assert.assertTrue(result);	 
  Log.endTestCase("addToCartTest");	 
 }
	
	
	
	
	
	
	
}
