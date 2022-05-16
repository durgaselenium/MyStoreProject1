package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderSummary extends BaseClass{

 @FindBy(xpath="//span[text()='I confirm my order']")WebElement confirmOderBtn;
 
//constructor:
public OrderSummary() {
PageFactory.initElements(getDriver(), this);
}		
	
public OrderConfirmationPage clickOnConfirmOrderBtn() {
	// Action.click(driver, confirmOderBtn);
	Action.clickOn(confirmOderBtn, 5);
	return new OrderConfirmationPage();
}


}
