package com.qa.testscripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.AmazonPages;
import com.qa.pages.ClearTripPages;
import com.qa.utility.ExcelUtility;
import com.qa.utility.FromToData;

public class TC_Ctpages extends Base{	
	ClearTripPages cp;

	@DataProvider(name = "Data")
	public String[][] getData() throws IOException {

		String xFile = "C:\\Users\\abine\\eclipse-work\\Excel\\src\\test\\java\\com\\qa\\testdata\\Book1.xlsx";
		String xSheet = "Sheet2";

		int rowCount = FromToData.getRowCount(xFile, xSheet);
		int cellCount = FromToData.getCellCount(xFile, xSheet, rowCount);

		String[][] data = new String[rowCount][cellCount];

		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				data[i - 1][j] = FromToData.getCellData(xFile, xSheet, i, j);
			}
		}
		return data;
	}

	@Test(dataProvider = "Data")
	public void Search(String from, String to) throws InterruptedException, AWTException {
		Thread.sleep(4000);

		cp = new ClearTripPages(Driver);

		ClearTripPages.from.click();

		Robot rk=new Robot();
		rk.keyPress(KeyEvent.VK_BACK_SPACE);
		rk.keyRelease(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(5000);

		ClearTripPages.from.sendKeys(from);
		Thread.sleep(3000);	

		ClearTripPages.cfrom.click();
		Thread.sleep(5000);

		ClearTripPages.to.click();

		rk.keyPress(KeyEvent.VK_BACK_SPACE);
		rk.keyRelease(KeyEvent.VK_BACK_SPACE);

		ClearTripPages.to.sendKeys(to);
		Thread.sleep(5000);

		ClearTripPages.cto.click();
		Thread.sleep(7000);

		ClearTripPages.Search.click();
		Thread.sleep(10000);

		String str = ClearTripPages.firstflight.getText();
		System.out.println("Flight from " + from + " to " + to + " is:\n" + str);

		Driver.navigate().back();



	}}