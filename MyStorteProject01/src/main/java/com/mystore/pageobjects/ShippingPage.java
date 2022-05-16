package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass{

@FindBy(xpath="//input[@name='cgv']")WebElement terms;
@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
WebElement proceedToCheckOutBtn;
	
//constructor:
public ShippingPage() {
PageFactory.initElements(getDriver(), this);
}		

public void checkTheTerms() {
//	Action.click(driver, terms);
//	Action.clickOn(terms, 10);
	Action.clickOnJs(getDriver(), terms);
}
public PaymentPage clickOnProceedToCheckOut() {
	//Action.click(driver, proceedToCheckOutBtn);
	Action.clickOn(proceedToCheckOutBtn, 5);
	return new PaymentPage();
	
}

}
