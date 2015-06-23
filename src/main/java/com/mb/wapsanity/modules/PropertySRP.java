package com.mb.wapsanity.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PropertySRP {
	
	//************************Locators********************************************
	 private String propertyType = ".//*[@id='propertyType']/option[text()='xx']";
	 private String city = ".//*[@id='cityTypeValue']";
	 private String searchProperty = ".//*[@id='search']/div[6]/a";
	 private String callContactButton = ".//*[@id='resultContainerData']/div[2]/div[2]/div[@class='msgCall']/a[contains(text(),'CALL')]";
	 
	 
	 private RemoteWebDriver driver;
	 
	 
	 public PropertySRP(RemoteWebDriver driver) {
		super();
		this.driver = driver;
	}


	public void selectPropertyType(String propertyType)
	 {
		 String propertyTyepNew = propertyType.replace("xx", propertyType);
		 driver.findElement(By.xpath(propertyTyepNew)).click();
	 }

	
	public void enterCity(String cityname){
		
	     driver.findElement(By.xpath(city)).sendKeys(cityname);
	}
	
	public void searchProperty(){
	    driver.findElement(By.xpath(searchProperty)).click();
	} 
	
	
	public void clickCallButton(){
		driver.findElement(By.xpath(callContactButton)).click();
	}
}
