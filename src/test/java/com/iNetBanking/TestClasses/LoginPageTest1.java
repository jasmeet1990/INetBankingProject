package com.iNetBanking.TestClasses;

import java.io.IOException;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.iNetBanking.BaseClass.BaseClass;
import com.iNetBanking.PageClasses.LoginPage;

public class LoginPageTest1 extends BaseClass {
	
	
	@Test
	public void LoginTest() throws IOException {
		
//		DesiredCapabilities dc = new DesiredCapabilities ();
//		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		
		driver.get(baseUrl);
		logger.info("Opened URL");
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.ClickLogin();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Test Case is Passed");
		}
		else {
			Assert.assertTrue(false);
			captureScreen(driver,"LoginTest");
		}
	}

}
