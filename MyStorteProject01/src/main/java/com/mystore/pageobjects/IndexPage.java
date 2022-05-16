package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{

@FindBy(xpath="//a[@class='login']")WebElement signInBtn;
@FindBy(xpath="//div[@id='header_logo']")WebElement myStoreLogo;
@FindBy(xpath="//input[@name='search_query']")WebElement seacrchProductBox;
@FindBy(xpath="//button[@type='submit' and @name='submit_search']")WebElement searchButton;
	
//constructor:
public IndexPage() {
 PageFactory.initElements(getDriver(), this);
}

public LoginPage clickOnSignIn()  {
//Action.click(driver, signInBtn);
//Action.clickOnJs(driver, signInBtn);
Action.clickOn(signInBtn, 10);
return new LoginPage();
}

public boolean validateLogo() {
return Action.isDisplayed(getDriver(), myStoreLogo);
}

public String getMyStoreTitle() {
	return getDriver().getTitle();
}

public SearchResultPage searchProduct(String productName) {
 //Action.type(seacrchProductBox, productName);
 //Action.click(driver, searchButton);
 
 Action.sendKeys(seacrchProductBox, 5, productName);
// Action.click(driver, searchButton);
  Action.clickOn(searchButton, 5);
  return new SearchResultPage();
}

}
