package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass{

 @FindBy(xpath="//span[text()='Proceed to checkout']")WebElement proceedToCheckOut;	
	
//constructor:
public AddressPage() {
PageFactory.initElements(getDriver(), this);
}	

public ShippingPage clickOnChickOut() {
	Action.clickOn(proceedToCheckOut, 10);
	//Action.click(driver, proceedToCheckOut);
	return new ShippingPage();
}
	
}
