package com.mystore.dataprovider;

import org.testng.annotations.DataProvider;

import com.mystore.utility.Xls_Reader;

public class DataProviderTest {

Xls_Reader reader = new Xls_Reader("E:\\DEVI\\DeviWork\\MyStorteProject01\\src\\test\\resources\\TestData\\TestData.xlsx");

//1..Class --> LoginPageTest,HomePageTest Test Case--> loginTest, wishListTest, orderHistoryandDetailsTest

@DataProvider(name="Credentials")
public Object[][]getCredentials(){
 //Total row count
 int rows =	reader.getRowCount("Credentialsdata"); //sheetname
 //Total columns count
 int columns = reader.getColumnCount("Credentialsdata");
 int actRows = rows-1; 
 
 Object[][]data = new Object[actRows][columns];
  for(int i=0;i<actRows;i++) {
	  for(int j=0;j<columns;j++) {
		 data[i][j] = reader.getCellData("Credentialsdata", j, i+2);
	  }
  }
return data;	
}	

//2..Class --> AccountCreationPage  Test Case--> verifyCreateAccountPageTest
@DataProvider(name="emailCredentials")
public Object[][]getAccCredential(){
 //Total row count
 int rows =	reader.getRowCount("Email"); //sheetname
 //Total columns count
 int columns = reader.getColumnCount("Email");
 int actRows = rows-1; 
 
 Object[][]data = new Object[actRows][columns];
  for(int i=0;i<actRows;i++) {
	  for(int j=0;j<columns;j++) {
		 data[i][j] = reader.getCellData("Email", j, i+2);
	  }
  }
return data;	
}

//3.Class --> AddToCartPageTest, EndToEndTest,  Test Case--> OrderpageTest,addToCartTest, endToEndTest
@DataProvider(name="getProduct")
public Object[][]getProduct(){
 //Total row count
 int rows =	reader.getRowCount("ProductDetails"); //sheetname
 //Total columns count
 int columns = reader.getColumnCount("ProductDetails");
 int actRows = rows-1; 
 
 Object[][]data = new Object[actRows][columns];
  for(int i=0;i<actRows;i++) {
	  for(int j=0;j<columns;j++) {
		 data[i][j] = reader.getCellData("ProductDetails", j, i+2);
	  }
  }
return data;	
}

//4. Class --> SearchResultPageTest, Test Case--> productAvailabilityTest
@DataProvider(name="searchProduct1")
public Object[][]getSearchCredential(){
 //Total row count
 int rows =	reader.getRowCount("SearchProduct"); //sheetname
 //Total columns count
 int columns = reader.getColumnCount("SearchProduct");
 int actRows = rows-1; 
 
 Object[][]data = new Object[actRows][columns];
  for(int i=0;i<actRows;i++) {
	  for(int j=0;j<columns;j++) {
		 data[i][j] = reader.getCellData("SearchProduct", j, i+2);
	  }
  }
return data;	
}



}
