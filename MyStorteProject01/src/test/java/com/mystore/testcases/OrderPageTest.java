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
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

public class OrderPageTest extends BaseClass{
 IndexPage indexpage;
 SearchResultPage searchresultpage;
 AddToCartPage addtocartpage;
 OrderPage orderpage;
 
 @Parameters("browser")
 @BeforeMethod(groups= {"smoke","sanity","Regression"})	
 public void setUp(String browser) {
 launchApp(browser);	
 }
		 
 @AfterMethod(groups= {"smoke","sanity","Regression"})
 public void tearDown() {
	 getDriver().quit();
 }

  
 @Test(groups="Regression",dataProvider="getProduct",dataProviderClass=DataProviderTest.class)
 public void verifyTotalPrice(String productName,String qty,String size) throws Exception {

Log.startTestCase("verifyTotalPrice");	 
  indexpage = new IndexPage();
//  searchresultpage = indexpage.searchProduct("t-shirt");
  searchresultpage = indexpage.searchProduct(productName); 
  addtocartpage = searchresultpage.clickOnProduct();
 
//  addtocartpage.enterQuality("2");
  addtocartpage.enterQuality(qty);
//  addtocartpage.selectSize("S");
  addtocartpage.selectSize(size);
  addtocartpage.clickOnAddToCart();
  orderpage = addtocartpage.clickOnCheckOut();
 
  Double unitPrice = orderpage.getUnitPrice(); 
  Double totalPrice =  orderpage.getTotalPrice();
//  Double totalExpectedPrice =(unitPrice*2)+ 2;
  Double totalExpectedPrice =(unitPrice*(Double.parseDouble(qty)))+ 2;
  Thread.sleep(1000);
  Assert.assertEquals(totalPrice, totalExpectedPrice);
Log.endTestCase("verifyTotalPrice"); 
 }
 
 		
	
}
