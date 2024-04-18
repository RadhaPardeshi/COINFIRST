package com.netBanking.ObjectRepository.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplyDebitCardPage {

	@FindBy(name = "holder_name")
	private WebElement holderNameTxt;
	@FindBy(name = "dob")
	private WebElement dateOfBirthDD;
	@FindBy(name = "pan")
	private WebElement panNoTxt;
	@FindBy(name = "mob")
	private WebElement mobileNoTxt;
	@FindBy(name = "acc_no")
	private WebElement accountNoTxt;
	@FindBy(name = "dbt_crd_submit")
	private WebElement subBtn;

	public ApplyDebitCardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterHolderNameTxt(String Name) {
		holderNameTxt.sendKeys(Name);
	}

	public WebElement getSubBtn() {
		return subBtn;
	}

	public void enterDateBirthTxt() throws AWTException {
		dateOfBirthDD.click();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_2);
		r.keyPress(KeyEvent.VK_7);
		r.keyPress(KeyEvent.VK_0);
		r.keyPress(KeyEvent.VK_2);
		r.keyRelease(KeyEvent.VK_2);
		r.keyPress(KeyEvent.VK_2);
		r.keyPress(KeyEvent.VK_0);
		r.keyPress(KeyEvent.VK_2);
		r.keyPress(KeyEvent.VK_4);
	}

	public void enterMobileNoTxt(String mobileNo) {
		mobileNoTxt.sendKeys(mobileNo);
	}

	public WebElement getPanNo() {
		return panNoTxt;
	}

	public void enteraccNoTxt(String accountID) {
		accountNoTxt.sendKeys(accountID);
	}
	//Thank you

}
