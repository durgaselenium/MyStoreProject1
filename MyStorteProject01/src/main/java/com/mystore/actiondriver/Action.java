package com.mystore.actiondriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.base.BaseClass;

public class Action extends BaseClass {

	
public static void scrollByVisibilityOfEelement(WebDriver driver,WebElement ele) {
JavascriptExecutor js = ((JavascriptExecutor)driver);
js.executeScript("arguments[0].scrollIntoView();", ele);	
}	

public static void clickOnJs(WebDriver driver,WebElement ele) {
 JavascriptExecutor js = ((JavascriptExecutor)driver);
 js.executeScript("arguments[0].click();", ele)	;
}
public static void click(WebDriver ldriver,WebElement locatorName) {
Actions act = new Actions(ldriver);
act.moveToElement(locatorName).build().perform();	
}
	
public static boolean findElement(WebDriver ldriver,WebElement ele) {
	boolean flag = false;
	try {
		ele.isDisplayed();
		flag = true;
	} catch (Exception e) {
		flag = false;
	}
	finally {
		if(flag) {
			System.out.println("Successfully found element at..");
		}else {
			System.out.println("Unable to locate element at..");
		}
	}
	return flag;
}
	
public static boolean isDisplayed(WebDriver ldriver,WebElement ele) {
	boolean flag = false;
	flag = findElement(ldriver, ele);
	if(flag) {
		flag = ele.isDisplayed();
		if(flag) {
			System.out.println("The element is Displayed..");
		}else {
			System.out.println("The element is not Displayed..");
		}
	}
	else {
		System.out.println("Not displayed..");
	}
	return flag;
}

public static boolean isSelected(WebDriver ldriver,WebElement ele) {
	boolean flag = false;
	flag = findElement(ldriver, ele);
	if(flag) {
		flag = ele.isSelected();
		if(flag) {
			System.out.println("The element is Selected..");
		}else {
			System.out.println("The element is not Selected..");
		}
	}
	else {
		System.out.println("Not Selected..");
	}
	return flag;	

}

public static boolean isEnabled(WebDriver ldriver,WebElement ele) {
	boolean flag = false;
	flag = findElement(ldriver, ele);
	if(flag) {
		flag = ele.isEnabled();
		if(flag) {
			System.out.println("The element is Enabled..");
		}else {
			System.out.println("The element is not Enabled..");
		}
	}
	else {
		System.out.println("Not Enabled..");
	}
	return flag;	
}

public static boolean type(WebElement ele,String text) {
	boolean flag = false;
	try {
		flag = ele.isDisplayed();
		ele.clear();
		ele.sendKeys(text);
		flag = true;
	} catch (Exception e) {
	 System.out.println("location not found..");
	 flag = false;	
	}
	finally {
		if(flag) {
			System.out.println("Succesfully entered value..");
		}else {
			System.out.println("Unable to enter value..");
		}
	}
	return false;
}

public static boolean selectBySendKeys(WebElement ele,String value) {
 boolean flag = false;
 try {
	ele.sendKeys(value);	
	 flag = true;
	 return  true;
} catch (Exception e) {
	return false;
}
 finally {
	 if(flag) {
		 System.out.println("Select value frome the DropDown..");
	 }
	 else {
		 System.out.println("Not Select value forme the DropDown..");
	 }
 }
}
public static boolean selectByVisibleText(String visibletext, WebElement ele) {
	boolean flag = false;
	try {
		Select s = new Select(ele);
		s.selectByVisibleText(visibletext);
		flag = true;
		return true;
	} catch (Exception e) {
		return false;
	} finally {
		if (flag) {
			System.out.println("Option selected by VisibleText");
		} else {
			System.out.println("Option not selected by VisibleText");
		}
	}
}

public static boolean selectByValue(WebElement ele,String value) {
	boolean flag = false;
	 try {
	   Select s = new Select(ele);
	   s.selectByValue(value);;
	    flag = true;
		 return  true;
	} catch (Exception e) {
		return false;
	}
	 finally {
		 if(flag) {
			 System.out.println("option selected by value");
		 }else {
			 System.out.println("option not select by value");
		 }
	 }
}



//wait:
	public static void sendKeys(WebElement element, int timeOut, String value) {
		new WebDriverWait(getDriver(), timeOut).until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(value);
	}

	public static void clickOn(WebElement element, int timeOut) {
		new WebDriverWait(getDriver(), timeOut).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public static String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\Screenshots\\" + filename + "_" + dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		// This new path for jenkins
		String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename + "_"
				+ dateName + ".png";
		return newImageString;
	}
	
	public String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}

}
