package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;

import freemarker.template.SimpleDate;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

// public static WebDriver driver;
public static Properties prop;

//Declare ThreadLocalDriver:
public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

/*@BeforeSuite(groups= {"smoke","sanity","Regression"})
public void beforeSuite() {
DOMConfigurator.configure("log4j.xml");	
}*/

@BeforeSuite(groups= {"smoke","sanity","Regression"})
public void loadConfig() {
ExtentManager.setExtent();
DOMConfigurator.configure("log4j.xml");	

try {
	prop = new Properties();
	System.out.println("Super constructor invoked..");
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +"//Configuration//config.properties");
	prop.load(fis);
	System.out.println("driver :" +driver);
} catch (FileNotFoundException e) {
      e.printStackTrace();
} catch (IOException e) {
      e.printStackTrace();
}
}

public static WebDriver getDriver() {
	return driver.get(); //GetDriver frome threadLocalMap
}

/*@BeforeTest(groups= {"smoke","sanity","Regression"})
public void loadConfig() {
try {
	prop = new Properties();
	System.out.println("Super constructor invoked..");
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +"//Configuration//config.properties");
	prop.load(fis);
	System.out.println("driver :" +driver);
} catch (FileNotFoundException e) {
      e.printStackTrace();
} catch (IOException e) {
      e.printStackTrace();
}

}*/

public static void launchApp(String browserName) {
//	String browserName = prop.getProperty("browser");
	if(browserName.equalsIgnoreCase("chrome")) {
	WebDriverManager.chromedriver().setup();
//	driver = new ChromeDriver();	
	driver.set(new ChromeDriver());
	}
	else if (browserName.equalsIgnoreCase("firefox")) {
	 WebDriverManager.firefoxdriver().setup();
//	 driver = new FirefoxDriver();
	 driver.set(new FirefoxDriver());
	}
//	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//	driver.get(prop.getProperty("url"));
	getDriver().get(prop.getProperty("url"));
}

@AfterSuite
public void afterSuite() {
ExtentManager.endReport();	
}
	

}
