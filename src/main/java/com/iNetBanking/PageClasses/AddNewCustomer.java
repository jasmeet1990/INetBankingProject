package com.iNetBanking.PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {

	
	WebDriver ldriver;
	
	public AddNewCustomer(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement NewCustomerLink;
	
	@FindBy(name ="name")
	@CacheLookup
	WebElement CustomerName;
	
	@FindBy(name ="rad1")
	@CacheLookup
	WebElement CustGender;
	
		
	@FindBy(name ="dob")
	@CacheLookup
	WebElement CustDateOfBirth;
	
	@FindBy(name ="addr")
	@CacheLookup
	WebElement CustAddress;
	
	
	@FindBy(name ="city")
	@CacheLookup
	WebElement CustCity; 
	
	
	@FindBy(name ="state")
	@CacheLookup
	WebElement CustState;  
	
	@FindBy(name ="pinno")
	@CacheLookup
	WebElement CustPinNumber;
	
	
	@FindBy(name ="telephoneno")
	@CacheLookup
	WebElement CustTelephoneNumber;   
	
	@FindBy(name ="emailid")
	@CacheLookup
	WebElement CustEmailId;
	
	@FindBy(name ="password")
	@CacheLookup
	WebElement CustPassword;
	
	@FindBy(name ="sub")
	@CacheLookup
	WebElement SubmitButton;
	
	public void ClickAddNewCustomer() {
		NewCustomerLink.click();
	}
	
	public void custName(String cname) {
		CustomerName.sendKeys(cname);
	}
	
	public void custGender(String cgender) {
		CustGender.click();
	}
	public void custDOB(String mm,String dd,String yy) {
		CustDateOfBirth.sendKeys(mm);
		CustDateOfBirth.sendKeys(dd);
		CustDateOfBirth.sendKeys(yy);
	}
	public void custAddress(String caddress) {
		CustAddress.sendKeys(caddress);
	}
	
	public void custCity(String ccity) {
		CustCity.sendKeys(ccity);
	}
	
	public void custState(String cstate) {
		CustState.sendKeys(cstate);
	}
	
	public void custPinNo(String cpinno) {
		CustPinNumber.sendKeys(cpinno);
	}
	
	public void custTelNo(String ctelNo) {
		CustTelephoneNumber.sendKeys(ctelNo);
	}
	
	public void custEmailId(String cemail) {
		CustEmailId.sendKeys(cemail);
	}
	
	public void custPassword(String cpwd) {
		CustPassword.sendKeys(cpwd);
	}
	
	public void ClickSubmitButton() {
		SubmitButton.click();
	}
}
