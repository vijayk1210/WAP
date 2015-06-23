package com.mb.wapsanity.testscripts;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mb.wapsanity.modules.PropertySRP;
import com.mb.wapsanity.modules.contactForm;
import com.mb.wapsanity.common.*;

  
  public class VerifyContacts extends LaunchWap{
	  
	  
 
  //****************Test cases*********************************************************
  // Step 1: Navigate too property SRP.
  // Step 2: Click on call button of any of the property listed.
  // Step 3: Fill the contact form and submit.
  // Step 4: Check the entry in Database.
  
  //***********************************************************************************
  
  
  @Test(enabled=false)
  public void propertySRPContactCheck() throws InterruptedException {
	  boolean testStatus = true;
	  String funcToExcecute = null;
	  
	try{
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		Properties prop = new Properties();
		  InputStream input = null;
		  input = new FileInputStream("TestData.properties");	  
		  prop.load(input);
		  String appUrlSrp =prop.getProperty("appUrlSrp")+prop.getProperty("propType")+"-real-estate-"+prop.getProperty("city")+"";
		  driver.get(appUrlSrp);
		    
	  PropertySRP callObj = new PropertySRP(driver);  
	  contactForm contactfromObj = new contactForm(driver);
	  
	  //Step 2:
	  funcToExcecute= "Clicking call button on Property SRP";
	  callObj.clickCallButton();
	  Thread.sleep(3000);
	  
	  //Step 3:
	  funcToExcecute= "Filling the conytact form";
	  contactfromObj.fillAndSubmitContactForm(prop.getProperty("userName"),prop.getProperty("userEmail"),prop.getProperty("contactNumber"));
	  Thread.sleep(6000);
	  	
	  
	  //Step 4:
	  DatabaseAccessObject obj1 = new DatabaseAccessObject(); 
		List list = new ArrayList();
		try {
			funcToExcecute="Getting data from database";
			list = obj1.verifyContact(prop.getProperty("userEmail"));
			
			if(list.size()==0){
				Assert.fail("Zero contacts showing in database");
			}
			
			Reporter.log("Number of contacts = "+list.size());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	 }catch(Exception e){
		 testStatus = false;
		 Assert.assertTrue(testStatus, "VerifyContact test failed in: " +funcToExcecute);
		 
	 }
	  
   	  
  }
}
