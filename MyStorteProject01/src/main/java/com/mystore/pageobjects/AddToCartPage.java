package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass {

@FindBy(xpath="//input[@name='qty']")WebElement quality;
@FindBy(xpath="//select[@name='group_1']")WebElement size;//dropdown
@FindBy(xpath="//span[text()='Add to cart']")WebElement addtoCartBtn;
@FindBy(xpath="//div[@class='layer_cart_product col-xs-12 col-md-6']//h2")WebElement addToCartMessage; // Product successfully added to your shopping cart --title
@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")WebElement proceedToCheckOutBtn;

// constructor:
 public AddToCartPage() {
 PageFactory.initElements(getDriver(), this);
}
 
 public void enterQuality(String quality1) {
	Action.sendKeys(quality, 10, quality1); 
	//Action.type(quality, quality1); 
 }
 public void selectSize(String size1) throws Exception {
//	Action.selectByVisibleText(size, size1);
 Action.selectByVisibleText(size1, size);	
 }
 
	
 public void clickOnAddToCart() {
	// Action.click(driver, addtoCartBtn);
	 Action.clickOn(addtoCartBtn, 5);
 }
 
 public boolean validateAddToCart() {
	 // Action.fuentwait(addToCartMessage,10);
	 WebDriverWait wait = new WebDriverWait(getDriver(), 10);
	 wait.until(ExpectedConditions.visibilityOf(addToCartMessage));
	 
	return Action.isDisplayed(getDriver(), addToCartMessage);
 }
 
 public OrderPage clickOnCheckOut() {
	 Action.clickOn(proceedToCheckOutBtn, 10);
	 //Action.clickOnJs(driver, proceedToCheckOutBtn);
	 return new OrderPage();
 }
	
}
