package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClearTripPages {
	WebDriver Driver;

	//loginAlert Close
	@FindBy(xpath="(//div[@class='flex flex-column']/following-sibling::div)[2]")
	public static WebElement clickcross;


	//Click oneway

	@FindBy(xpath="//span[text()='One way']") public static WebElement
	clickoneway;

	//clickagainoneway

	@FindBy(xpath="(//div[@class='flex flex-middle']//span)[2]")
	public static
	WebElement onewaytrip;


	//From
	@FindBy(xpath="//input[@placeholder='Where from?']")
	public static WebElement from;

	//confirmFromDAta
	@FindBy(xpath="(//p[contains(@class,'to-ellipsis o-hidden')])[1]")
	public static WebElement cfrom;

	//To
	@FindBy(xpath="//input[@placeholder='Where to?']")
	public static WebElement to;

	//ConfirmToData
	@FindBy(xpath="(//p[contains(@class,'to-ellipsis o-hidden')])[1]")
	public static WebElement cto;

	//searchflights
	@FindBy(xpath="//span[text()='Search flights']")
	public static WebElement Search;

	//firstflight
	@FindBy(xpath="(//div[contains(@class,'ba bc-neutral-100')])[2]")
	public static WebElement firstflight;




	public ClearTripPages(WebDriver Driver) {
		this.Driver=Driver;
		PageFactory.initElements(Driver, this);
	}

}
