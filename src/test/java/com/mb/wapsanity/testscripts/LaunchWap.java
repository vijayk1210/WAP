package com.mb.wapsanity.testscripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class LaunchWap {
  public static RemoteWebDriver driver;
  
  @BeforeTest
  public void beforeSuite() {
	  
   
  	DesiredCapabilities capabilities = new DesiredCapabilities();
  	capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("deviceName","Nexus 4");
    capabilities.setCapability("platformVersion", "5.0");
    capabilities.setCapability("app", "Chrome");
    //capabilities.setCapability(CapabilityType.BROWSER_NAME, "Firefox");
  	try {
  		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
  		
  	} catch (MalformedURLException e) {
  		e.printStackTrace();
  	}
  	
  }

}
