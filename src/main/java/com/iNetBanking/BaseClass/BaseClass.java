package com.iNetBanking.BaseClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.iNetBanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();

	public String baseUrl = readConfig.getbaseUrl();
	public String userName = readConfig.getUsername();
	public String password = readConfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("BrowserName")
	@BeforeClass
	public void SetUp(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
		ChromeOptions co = new ChromeOptions();
		co.setAcceptInsecureCerts(true);
		driver = new ChromeDriver(co);
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
		System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
		driver= new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("IE")) {
		System.setProperty("webdriver.ie.driver", readConfig.getIEPath());
		}
		
		driver.get(baseUrl);
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
	}
	
//	@AfterClass
//	public void tearDown() {
//		driver.quit();
//	}
	
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
public String randomString() {
		
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		
		return generatedString;
		
		
	}
	
	
	
}
