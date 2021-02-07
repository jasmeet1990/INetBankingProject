package com.iNetBanking.TestClasses;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBanking.BaseClass.BaseClass;
import com.iNetBanking.PageClasses.AddNewCustomer;
import com.iNetBanking.PageClasses.LoginPage;


public class AddNewCustomerTest1 extends BaseClass{

	@Test
	public void AddNewCust() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.ClickLogin();
		
		
		AddNewCustomer addnewcust = new AddNewCustomer(driver);
		addnewcust.ClickAddNewCustomer();
		addnewcust.custName("Jasmeet Kaur");
		addnewcust.custGender("Female");
		addnewcust.custDOB("07", "14", "1990");
		Thread.sleep(5000);
		addnewcust.custAddress("HNo 56Green City");
		addnewcust.custCity("Zirakpur");
		addnewcust.custState("Punjab");
		addnewcust.custPinNo("140603");
		addnewcust.custTelNo("7973845478");
		String email = randomString()+"@gmail.com";
		addnewcust.custEmailId(email);
		addnewcust.custPassword("Gracefulgod1990");
		addnewcust.ClickSubmitButton();
		
		boolean result =driver.getPageSource().contains("Customer Registered Successfully!!!");
				System.out.println(result);
		if(result==true) {
			Assert.assertTrue(true);
		}
		else {
		
			Assert.assertTrue(false);
		}
	}
	
	
	
	
	
}
