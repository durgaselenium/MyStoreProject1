package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(xpath="//span[text()='My wishlists']")
	WebElement myWishList;
	@FindBy(xpath = "//span[text()='Order history and details']")
	WebElement orderHistory;

	// constructor:
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean validateMyWishList() {
	//return Action.isDisplayed(driver, myWishList);	
	 return	myWishList.isDisplayed();
	}
	
	public boolean validateOrderHistory() {
	//	return Action.isDisplayed(driver, orderHistory);
		return orderHistory.isDisplayed();	
	}

	public String getCurrURL() {
	 //return driver.getCurrentUrl();
	 String homepageURL = getDriver().getCurrentUrl();
	 return homepageURL;
	}

}
