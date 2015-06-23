package com.mb.wapsanity.modules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class PostProperty {

 //*****************locators**********************************************************************
	//Page 1
	private String rentID = "cgR";
	private String propertyTypeDropDownXPATH = ".//*[@id='ty']/option[text()='propertyType']";
	private String coveredAreaID = "covArea";
	private String carpetAreaID = "carpetArea";
	private String plotAreaID ="plArea";
	private String totalPriceID = "price";
	private String monthlyRent ="monthlyRent";
	private String cityDropDownXPATh = ".//*[@id='ct']/optgroup[@label='Popular Cities']/option[text()='cityName']";
	private String localityDropDownXPATH = ".//*[@id='lt']/option[3]";
	private String nextButtonID = "submitButtonStep1";
	
	//Page2
	private String bedroomXPATH = ".//*[@id='bd']/option[text()='numbOfBedroom']";
	private String bathroomXPATH = ".//*[@id='bathroom']/option[text()='numbOfBathroom']";
	private String balconyXPATh = ".//*[@id='balcony']/option[text()='numbOfBalcony']";
	private String furnishingXPATH = ".//*[@id='furnished']/option[text()='furnishing']";
	private String floorNumberXPATH = ".//*[@id='floor']/option[text()='floorNumber']";
	
	private String totalFloorXPATh = ".//*[@id='totalFloor']/option[text()='totalFloors']";
	private String cornerPlotXpath = ".//*[@id='corner']/option[text() ='yesOrno']";
	
	private String newPropertyID = "chooseOne1";
	private String resaleID = "chooseOne2";
	private String possessionStatusXPATH =".//*[@id='posStatus']/option[text()='possessionStatusType']";
	private String availableFromXPATH = ".//*[@id='posStatus']/option[text() ='available']";
	
	private String submitButtonID = "submitButtonStep2";
  //************************************************************************************************
	
	//page3
	private String finalSubmitButtonID = "step3SubmitButton";
	private String successMessageXPATH = ".//*[@id='wrapper']/section/div[1]/div[1]/p";
	private String propertyidXPATH = ".//*[@id='wrapper']/section/div[1]/div[1]/p/span";
	
	private RemoteWebDriver driver;
	private String expectedSuccessMessage = "Your Property has been Successfully Posted";
		
	public PostProperty(RemoteWebDriver driver) {
	super();
	this.driver = driver;
    }

	public void sellOrRent(String type){
		if(type.equalsIgnoreCase("rent")){
			driver.findElement(By.id(rentID)).click();
		}
	}
	
	public void selectPropertyType(String property){
		
		String newPropertyTypeDropDownXPATH = propertyTypeDropDownXPATH.replace("propertyType", property);
		WebDriverWait wait = new WebDriverWait(driver,60);
	    WebElement attachFile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(newPropertyTypeDropDownXPATH)));
	    attachFile.click();
		//driver.findElement(By.xpath(newPropertyTypeDropDownXPATH)).click();
	}
	
	public void inputArea(String covered,String carpet){
		driver.findElement(By.id(coveredAreaID)).sendKeys(covered);
		driver.findElement(By.id(carpetAreaID)).sendKeys(carpet);
				
	}
	
	public void inputPlotArea(String area){
		driver.findElement(By.id(plotAreaID)).sendKeys(area);
	}
	
	public void inputPrice(String price){
		driver.findElement(By.id(totalPriceID)).sendKeys(price);
	}
	
	public void inputRent(String rent){
		driver.findElement(By.id(monthlyRent)).sendKeys(rent);
	}
	
	public void selectCityAndLocality(String city){
		
		try {
			String newCityDropDownXPATh =cityDropDownXPATh.replace("cityName", city);
			driver.findElement(By.xpath(newCityDropDownXPATh)).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(localityDropDownXPATH)).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void clickNextStep1(){
		driver.findElement(By.id(nextButtonID)).click();
	}
	
	
	public void selectPropertyFeatures(String propType,String numberOfBedroom,String numberOfBathroom,String numberOfBalcony,String furnishing,String floorNumber,String totalFloor){
		if(propType!="Studio Apartment"){
		String bedroomNewXPATh = bedroomXPATH.replace("numbOfBedroom", numberOfBedroom);
		driver.findElement(By.xpath(bedroomNewXPATh)).click();
		}
		String bathroomNewXpath = bathroomXPATH.replace("numbOfBathroom", numberOfBathroom);
		System.out.println(bathroomNewXpath);
		driver.findElement(By.xpath(bathroomNewXpath)).click();
		
		String balconyNewXpath = balconyXPATh.replace("numbOfBalcony", numberOfBalcony);
		driver.findElement(By.xpath(balconyNewXpath)).click();
		
		String furnishingNewXpath = furnishingXPATH.replace("furnishing", furnishing);
		driver.findElement(By.xpath(furnishingNewXpath)).click();

		
		if( propType!="Villa") {
		System.out.println("öther then Villa");
		String floorNumberNewXpath = floorNumberXPATH.replace("floorNumber", floorNumber);
		driver.findElement(By.xpath(floorNumberNewXpath)).click();
		}
		
		String totalFloorNewXpath = totalFloorXPATh.replace("totalFloors", totalFloor);
		driver.findElement(By.xpath(totalFloorNewXpath)).click();
		
		
		
	}
	
	public void selectCommercialFeatures(String propType,String numbOfBathroom,String furnishing,String floorNumber,String totalFloor){
		
		
		
		String furnishingNewXpath = furnishingXPATH.replace("furnishing", furnishing);
		driver.findElement(By.xpath(furnishingNewXpath)).click();
		
		String floorNumberNewXpath = floorNumberXPATH.replace("floorNumber", floorNumber);
		driver.findElement(By.xpath(floorNumberNewXpath)).click();
		
		String totalFloorNewXpath = totalFloorXPATh.replace("totalFloors", totalFloor);
		driver.findElement(By.xpath(totalFloorNewXpath)).click();
		
		if(propType.equalsIgnoreCase("Commercial Office Space") || propType.equalsIgnoreCase("Commercial Showroom") || propType.equalsIgnoreCase("Office in IT Park/ SEZ")){
			String bathroomNewXpath = bathroomXPATH.replace("numbOfBathroom", numbOfBathroom);
			driver.findElement(By.xpath(bathroomNewXpath)).click();
		}
	}
	
	public void isCornerPlot(String value){
		String cornerPlotNewXpath = cornerPlotXpath.replace("yesOrno", value);
		driver.findElement(By.xpath(cornerPlotNewXpath)).click();
	}
	
	public void transactionTypeAndPossession(String transactionType,String possessionStatus){
		 
		 for(int i=0;i<=20;i++){
			 driver.findElement(By.tagName("body")).sendKeys(Keys.DOWN);
		 }
		 
		if(transactionType.equalsIgnoreCase("New Property")){
			driver.findElement(By.id(newPropertyID)).click();
			
		}else{
			driver.findElement(By.id(resaleID)).click();
		}
		String possessionStatusNewXpath = possessionStatusXPATH.replace("possessionStatusType", possessionStatus);
		driver.findElement(By.xpath(possessionStatusNewXpath)).click();
		
	}
	
	public void transactionTypeForPlot(String transactionType){
		 for(int i=0;i<=4;i++){
			 driver.findElement(By.tagName("body")).sendKeys(Keys.DOWN);
		 }
		 
		if(transactionType.equalsIgnoreCase("New Property")){
			driver.findElement(By.id(newPropertyID)).click();
			
		}else{
			driver.findElement(By.id(resaleID)).click();
		}
	}
	
	public void availableFrom(String availableValue){
	 String availableFromNewXPATH = availableFromXPATH.replace("available", availableValue);
	 driver.findElement(By.xpath(availableFromNewXPATH)).click();
	}
	
	public void clickNextStep2(){
		driver.findElement(By.id(submitButtonID)).click();
	}
	
	public void clickSubmitFinal(){
		 for(int i=0;i<=20;i++){
			 driver.findElement(By.tagName("body")).sendKeys(Keys.DOWN);
		 }
		driver.findElement(By.id(finalSubmitButtonID)).click();
	}
	
	public String verifySuccessMesaage(){
		boolean status = true;
		String propertyid = null;
		String successMessage = driver.findElement(By.xpath(successMessageXPATH)).getText();
		System.out.println("Success msg: "+successMessage);
		
	    if(successMessage.contains(expectedSuccessMessage)){
	    	Reporter.log("Property is Successfully posted");
	    	propertyid = driver.findElement(By.xpath(propertyidXPATH)).getText();
	    }
	    else{
	    	status = false;
	    	Assert.assertTrue(status, "Post property success message doesn't match with expected message");
	    }
		
		
		return propertyid;
	}
	
}
