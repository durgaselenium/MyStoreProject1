package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass {

	@FindBy(xpath = "//img[@title='Faded Short Sleeve T-shirts']")
	WebElement productResult;// image
   
	
	// constructor:
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
 public boolean isProductAvailable() {
	return	Action.isDisplayed(getDriver(), productResult);
	}

 public AddToCartPage clickOnProduct() {
 //	Action.click(driver, productResult);
   Action.clickOn(productResult, 5); 
	return new AddToCartPage();
 }
 
}
