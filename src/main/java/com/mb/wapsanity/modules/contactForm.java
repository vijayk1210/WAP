package com.mb.wapsanity.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class contactForm {
	
	
	
	//************************Locators********************************************
	private String name = ".//*[@id='name']";
	private String email = ".//*[@id='email']";
	private String countryCode = ".//*[@id='codeISD']/option[2]";
	private String phone = ".//*[@id='ph']";
	private String userType = ".//*[@id='iamIndividual']";
	private String contactNow = ".//*[@id='snd_btn']";
	
	
    private RemoteWebDriver driver;
	 
	 
	 public contactForm(RemoteWebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void fillAndSubmitContactForm(String username,String useremail,String contactno){
		
		driver.findElement(By.xpath(name)).sendKeys(username);
		driver.findElement(By.xpath(email)).sendKeys(useremail);
		driver.findElement(By.xpath(countryCode)).click();
		driver.findElement(By.xpath(phone)).sendKeys(contactno);
		driver.findElement(By.xpath(userType)).click();
		driver.findElement(By.xpath(contactNow)).click();
		
		
	}

}
