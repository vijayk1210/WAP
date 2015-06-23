package com.mb.wapsanity.testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mb.wapsanity.modules.PostProperty;



public class PostPropertyTest extends LaunchWap {

	//************Test Cases********************************************************
    //Step1: Select the property type.
	//Step2: Enter the area.
	//Step3: Enter the cost.
	//Step4: Enter the city and locality.
	//Step5: Click next.
	//Step6: Select property features.
	//Step7: Select transaction type and possession status.
	//Step8: Click next.
	//Step9: Submit form.
	//Step10: Verify the success message.
	//******************************************************************************	
	
	//************Variables*********************************************************
	private PostProperty postProp; 
	
    private String postedPropertyID= null;
	//******************************************************************************
	
  @Test 
  public void postProperty() throws InterruptedException, IOException{
	 driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	 Properties prop = new Properties();
	 InputStream input = null;
	 input = new FileInputStream("TestData.properties");	  
	 prop.load(input); 	
	 driver.get(prop.getProperty("appUrl"));
	 
	 String propertyType = prop.getProperty("propertyType");
	 String sellOrRent = prop.getProperty("sellOrRent");
	 
	 
	 driver.findElement(By.xpath("//*[@id='infoContainer']/div[3]/div[2]/a")).click();
	 Thread.sleep(3000);
	  driver.findElement(By.xpath(".//*[@id='wrapper']/header/div[2]")).click();
	  driver.findElement(By.xpath(".//*[@id='wrapper']/../..//a[@href='/mbs/userListings.html']")).click();
	  driver.findElement(By.xpath("//*[@id='username']")).sendKeys("mbmobiletesters@gmail.com");
	  driver.findElement(By.xpath("//*[@id='password']")).sendKeys("12341234");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(".//*[@id='loginForm']/div/div[2]/a")).click();
	  driver.findElement(By.xpath(".//*[@id='listingType']/option[2]")).click();
	  driver.findElement(By.xpath(".//*[@id='saveAndProceed']")).click();
	  
	  postProp = new PostProperty(driver);
	  boolean testStatus = true;
	  String funcToExcecute = null;
	  
	  try{
	 //Step 1 
	  funcToExcecute = "sellOrRent";
	  postProp.sellOrRent(prop.getProperty("sellOrRent"));
	  
	  funcToExcecute = "selectPropertyType";
	  postProp.selectPropertyType(prop.getProperty("propertyType"));
	 
	  //Step2
	  if(propertyType.equalsIgnoreCase("Residential Plot") || propertyType.equalsIgnoreCase("commercial land") || propertyType.equalsIgnoreCase("industrial land")){
		  funcToExcecute = "inputPlotArea";
		  postProp.inputPlotArea(prop.getProperty("plotArea")); 
	  }
	  else{
	    if(propertyType.equalsIgnoreCase("Paying guest") || propertyType.equalsIgnoreCase("Hostel")){
		  
	     }
	    else{
	    funcToExcecute = "inputArea";
	    postProp.inputArea(prop.getProperty("coveredArea"),prop.getProperty("carpetArea"));
	    }
	  }
	  
	  //Step3
	  if(sellOrRent.equalsIgnoreCase("Rent")){
		  funcToExcecute = "inputRent"; 
		  postProp.inputRent(prop.getProperty("rent"));
	  }
	  else{
	  funcToExcecute = "inputPrice";
	  postProp.inputPrice(prop.getProperty("totalPrice"));
	  }
	  
	  //Step4
	  funcToExcecute = "selectCityAndLocality";
	  postProp.selectCityAndLocality(prop.getProperty("cityName"));
	  
	  //Step5
	  funcToExcecute = "clickNextStep1";
	  postProp.clickNextStep1();
	  
	  //Step6
	  if(propertyType.equalsIgnoreCase("Residential House") ||propertyType.equalsIgnoreCase("Villa") ||propertyType.equalsIgnoreCase("Residential Plot") || propertyType.equalsIgnoreCase("commercial land") || propertyType.equalsIgnoreCase("industrial land") || propertyType.equalsIgnoreCase("Agricultral land")){
		  funcToExcecute = "isCornerPlot";
		  postProp.isCornerPlot(prop.getProperty("cornerPlot"));
		  if(propertyType.equalsIgnoreCase("Residential House") ||propertyType.equalsIgnoreCase("Villa")){
		  postProp.selectPropertyFeatures(prop.getProperty("propertyType"),prop.getProperty("numberOfBedroom"),prop.getProperty("numberOfBathroom"),prop.getProperty("numberOfBalcony"),prop.getProperty("furnishing"),prop.getProperty("floorNumber"),prop.getProperty("totalFloor"));  
		  }
	  }
	  else{
		  if(propertyType.equalsIgnoreCase("Commercial Office Space") || propertyType.equalsIgnoreCase("Commercial Shop") || propertyType.equalsIgnoreCase("Commercial Showroom") || propertyType.equalsIgnoreCase("Office in IT Park/ SEZ") || propertyType.equalsIgnoreCase("Paying Guest") || propertyType.equalsIgnoreCase("Hostel")){
		  postProp.selectCommercialFeatures(prop.getProperty("propertyType"),prop.getProperty("numberOfBathroom"),prop.getProperty("furnishing"),prop.getProperty("floorNumber"),prop.getProperty("totalFloor"));
		  }
		  else{ funcToExcecute = "selectPropertyFeatures";
		  postProp.selectPropertyFeatures(prop.getProperty("propertyType"),prop.getProperty("numberOfBedroom"), prop.getProperty("numberOfBathroom"),prop.getProperty("numberOfBalcony"),prop.getProperty("furnishing"),prop.getProperty("floorNumber"),prop.getProperty("totalFloor"));
		  }
	  }
	  
	  
	  //Step7
	  if(sellOrRent.equalsIgnoreCase("sell")){
	  if(propertyType.equalsIgnoreCase("Residential Plot") || propertyType.equalsIgnoreCase("commercial land") || propertyType.equalsIgnoreCase("industrial land")){
	  funcToExcecute = "transactionTypeForPlot";
	  postProp.transactionTypeForPlot(prop.getProperty("transactionType"));
	  }
	  else{
	  funcToExcecute = "transactionTypeAndPossession";
	  postProp.transactionTypeAndPossession(prop.getProperty("transactionType"), prop.getProperty("possessionStatus"));
	  }
	  }
	  else{
		  if(propertyType.equalsIgnoreCase("Paying Guest") || propertyType.equalsIgnoreCase("Hostel")){
		 
		  }
		  else{
			  postProp.availableFrom(prop.getProperty("availableFrom"));
		  }
		  
	  }
	  
	  //Step8
	  funcToExcecute = "clickNextStep 2";
	  postProp.clickNextStep2();
	  
	  //Step9
	  
	  funcToExcecute = "clickSubmitFinal";
	  postProp.clickSubmitFinal();
	  
	  //step10
	  funcToExcecute = "verifySuccessMesaage";
	  postedPropertyID = postProp.verifySuccessMesaage();
	  Reporter.log("Property Id of the posted property: "+postedPropertyID);
	  }catch(Exception e){
		  
		  testStatus = false;
		  Assert.assertTrue(testStatus, "postProperty test failed in: " +funcToExcecute);
		  
		  
	  }
	  
  }
  
  
}
