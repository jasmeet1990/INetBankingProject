package com.iNetBanking.TestClasses;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.iNetBanking.BaseClass.BaseClass;
import com.iNetBanking.PageClasses.LoginPage;
import com.iNetBanking.utilities.XLUtils;

public class LoginPageTest2 extends BaseClass{
	
	@Test(dataProvider = "LoginDataSheet")
	public void loginDDT(String uName,String pwd) {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(uName);
		logger.info("Username is provided");
		lp.setPassword(pwd);
		logger.info("Password is provided");
		lp.ClickLogin();
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
			lp.ClickLogout();
			driver.switchTo().alert().accept();
		}
				
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
		
	}
	
	@DataProvider(name="LoginDataSheet")
	
	String[][] getData() throws IOException{
		
		String path = "../inetBankingProject/src/main/java/com/iNetBanking/utilities/XLUtils.java";
		int rowNo = XLUtils.getRowCount(path, "Sheet1");
		int colNo = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String loginData[][]= new String[rowNo][colNo];
		
		for(int i=1;i<=rowNo;i++) {
			for(int j=0;j<=colNo;j++) {
				loginData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}

}
