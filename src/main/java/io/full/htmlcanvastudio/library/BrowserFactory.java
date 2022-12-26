package io.full.htmlcanvastudio.library;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.full.dataprovider.ConfigFileReader;

public class BrowserFactory {

	private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

	public static WebDriver getBrowser(String browserName) {
		WebDriver driver = null;
		ConfigFileReader configFileReader = new ConfigFileReader();

		switch (browserName) {
		
		case "Chrome":
			driver = drivers.get("Chrome");
			if (driver == null) {
				System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				drivers.put("Chrome", driver);
			}
			break;
			
		case "Firefox":
			driver = drivers.get("Firefox");
			if (driver == null) {
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				drivers.put("Firefox", driver);
			}
			break;
		}
		return driver;
	}

	public static void closeAllDriver() {
		for (String key : drivers.keySet()) {
			drivers.get(key).close();
			drivers.get(key).quit();
		}
	}
}