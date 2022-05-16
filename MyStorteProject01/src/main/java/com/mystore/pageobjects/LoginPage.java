package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass{

@FindBy(xpath="//input[@name='email' and @id='email']")WebElement userName;
@FindBy(xpath="//input[contains(@name,'passwd')]")WebElement password;
@FindBy(xpath="//button[@id='SubmitLogin']//child::span")WebElement siginBtn;
@FindBy(xpath="//input[contains(@name,'email_create')]")WebElement emailForNewAccount;
@FindBy(xpath="//button[@name='SubmitCreate']")WebElement createNewAcctountBtn;

//costructor:
public LoginPage() {
 PageFactory.initElements(getDriver(), this);	
}

public HomePage login(String uname,String pswd) {
 Action.type(userName, uname);
 Action.type(password, pswd);
 //Action.click(driver, siginBtn);
// Action.clickOnJs(driver, siginBtn);
 Action.clickOn(siginBtn, 10);
 
 //Action.sendKeys(userName, 5, uname);
// Action.sendKeys(password, 5, pswd);
 //Action.click(driver, siginBtn);
 
 return new HomePage();
}

public AddressPage login1(String uname,String pswd) {
	 Action.type(userName, uname);
	 Action.type(password, pswd);
	// Action.click(driver, siginBtn);
	 Action.clickOn(siginBtn, 10);
	 return new AddressPage();
	}

public  AccountCreationPage createNewAccount(String newEmail) {
 Action.type(emailForNewAccount, newEmail);
 //Action.click(driver, createNewAcctountBtn);
 Action.clickOnJs(getDriver(), createNewAcctountBtn);
 return new AccountCreationPage();
}
	
}
