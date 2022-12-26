package io.full.htmlcanvasstudio;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import io.full.dataprovider.ConfigFileReader;
import io.full.htmlcanvastudio.library.BrowserFactory;
import io.full.htmlcanvastudio.pages.HomePage;

public class CanvasTests {
	
	ConfigFileReader configFileReader = new ConfigFileReader();
	
	/*
	 * @Author: Chaitanya Vaddisriram 
	 * @Role: QA Automation Engineer / SDET
	 * @Date: 26th Dec, 2022
	 * @Application: HtmlCanvaStudio
	 * @OnBehalfOf: Full Creative 
	 */
	
	@Test
	public void CanvasTests()
	{
		WebDriver driver = BrowserFactory.getBrowser("Chrome");
		HomePage homePage = new HomePage(driver);
		driver.get(configFileReader.getApplicationUrl());
		
		//1. DRAW TWO LINES
		homePage.clickLineIcon();
		homePage.drawShape(-100, -100, 200, 0, "Line");
		homePage.drawShape(0, -200, 0, 200, "Line");
		
		//2. DRAW RECTANGLE
		homePage.clickRectangleIcon();
		homePage.drawShape(-100, 120, 200, 120, "Rectangle");
		
		//3. ERASE HORIZONTAL LINE
		homePage.clickEraserIcon();
		homePage.eraseShape(-100, -100, 200, 0, "Line");
	}

	@AfterSuite
	public void tearDown()
	{
		BrowserFactory.closeAllDriver();
	}

}