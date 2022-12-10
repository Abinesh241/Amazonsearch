package com.qa.testscripts;

import java.io.IOException;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.AmazonPages;
import com.qa.pages.ClearTripPages;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	AmazonPages Amazonp;
	ClearTripPages pages;
	WebDriver Driver;
	@Parameters({"Browser","url"})
	 @BeforeClass
	 public void Setup(String Browser,String Url)throws IOException, InterruptedException
	 {
	 
		 if(Browser.equalsIgnoreCase("Chrome"))
		  {
			  WebDriverManager.chromedriver().setup();
			  Driver=new ChromeDriver();
		  }
		  else if(Browser.equalsIgnoreCase("Edge"))
		  {
			  System.setProperty("webdriver.edge.driver","./Driverfolder/msedgedriver.exe");
			   Driver=new EdgeDriver();
//			  WebDriverManager.edgedriver().setup();
//			  Driver=new EdgeDriver();
		  }  else
		  {
			  WebDriverManager.firefoxdriver().setup();
			  Driver=new FirefoxDriver();
		  }
		 
		  
	 pages=new ClearTripPages(Driver);
	 Driver.manage().window().maximize();
	 Driver.get(Url);
	 Thread.sleep(3000);
	 
	 ClearTripPages.clickcross.click(); 
		Thread.sleep(2000);	

	 }

	 @AfterClass public void TearDown() throws InterruptedException {
	 Thread.sleep(5000); Driver.close(); }
}
