package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviderTest;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummary;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;
import com.mystore.utility.Log;

public class EndToEndTest extends BaseClass{
 IndexPage indexpage;
 SearchResultPage searchresultpage;
 AddToCartPage addtocartpage;
 LoginPage loginpage;
 OrderPage orderpage;
 AddressPage addresspage;
 ShippingPage shippingpage;
 PaymentPage paymentpage;
 OrderSummary ordersummary;
 OrderConfirmationPage orderconfirmationpage;
 
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
 public void endToEndTest(String productName,String qty,String size) throws Exception {
	
	Log.startTestCase("endToEndTest"); 
	 indexpage = new IndexPage();
//	 searchresultpage = indexpage.searchProduct("t-shirt");
	 searchresultpage = indexpage.searchProduct(productName); 
	 addtocartpage = searchresultpage.clickOnProduct();
	 
//	 addtocartpage.enterQuality("2");
	 addtocartpage.enterQuality(qty);
//	 addtocartpage.selectSize("S");
	 addtocartpage.selectSize(size);
	 addtocartpage.clickOnAddToCart();
	 
	 orderpage = addtocartpage.clickOnCheckOut();
	 loginpage = orderpage.clickOncheckOut();
	 addresspage =  loginpage.login1(prop.getProperty("username"), prop.getProperty("password"));
	 shippingpage = addresspage.clickOnChickOut(); 
	 shippingpage.checkTheTerms();
	 
	 paymentpage = shippingpage.clickOnProceedToCheckOut();
	 ordersummary = paymentpage.clickOnPaymentMethod();
	 orderconfirmationpage =  ordersummary.clickOnConfirmOrderBtn();
	 String actualMessage = orderconfirmationpage.validateConfirmMessage();
	 String expecetdMessage = "Your order on My Store is complete.";
	 Thread.sleep(2000);
	 Assert.assertEquals(actualMessage, expecetdMessage);
   Log.endTestCase("endToEndTest");	 
	
 }
	
	
}
