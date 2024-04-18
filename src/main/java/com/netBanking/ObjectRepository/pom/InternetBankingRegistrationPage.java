package com.netBanking.ObjectRepository.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericTtilities.WebdiverUtility;

public class InternetBankingRegistrationPage {
	
	@FindBy(name = "holder_name") private WebElement holderNameTxtf;
	
	@FindBy(name = "accnum")private WebElement accountNumTxtf;
	
	@FindBy(name = "dbtcard")private WebElement debitCardTxtf;
	
	@FindBy(name ="dbtpin")private WebElement debitCardPinTxtf;
	
	@FindBy(name = "mobile")private WebElement mobiNoTxtf;
	
	@FindBy(name = "pan_no")private WebElement pANNoTxtf;
	
	@FindBy(name = "dob")private WebElement dateOfBirthTxtf;
	
	@FindBy(name = "last_trans")private WebElement lastTarnsTxtf;
	
	@FindBy(name = "password")private WebElement passwordTxtf;
	
	@FindBy(name = "cnfrm_password")private WebElement confPasswordTxtf;
	
	@FindBy(name = "submit")private WebElement subButton;
	
	public InternetBankingRegistrationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void typeHolderNameTxtf(String Name)
	{
		holderNameTxtf.sendKeys(Name);
	}
	
	public void typeaccountNumTxtf(String accountID )
	{
		accountNumTxtf.sendKeys(accountID);
	}
	public void typeDebitCardTxtf(String debitno)
	{
		debitCardTxtf.sendKeys(debitno);
	}
	public void typedebitCardPinTxtf(String pin1no)
	{
		debitCardPinTxtf.sendKeys(pin1no);
	}
	
	public void typemobiNoTxtf(String mobileNo)
	{
		mobiNoTxtf.sendKeys(mobileNo);
	}
	
	public void typepANNoTxtf(String PANNO)
	{
		pANNoTxtf.sendKeys(PANNO);
	}
	
	public void typedateOfBirthTxtf() throws AWTException
	{
		dateOfBirthTxtf.click();
		Robot r1=new Robot();
		r1.keyPress(KeyEvent.VK_2);
		r1.keyPress(KeyEvent.VK_7);
		r1.keyPress(KeyEvent.VK_0);
		r1.keyPress(KeyEvent.VK_2);
		r1.keyRelease(KeyEvent.VK_2);
		r1.keyPress(KeyEvent.VK_2);
		r1.keyPress(KeyEvent.VK_0);
		r1.keyPress(KeyEvent.VK_2);
		r1.keyPress(KeyEvent.VK_4);
	}
	
	public void typeLastTarnsTxtf()
	{
		lastTarnsTxtf.sendKeys("00");
	}
	public void typepasswordTxtf(String password)
	{
		passwordTxtf.sendKeys(password);
	}

	public void typeconfPasswordTxtf(String confpassword)
	{
		confPasswordTxtf.sendKeys(confpassword);
	}

	public WebElement getSubButton() {
		return subButton;
	}
	

	
}
