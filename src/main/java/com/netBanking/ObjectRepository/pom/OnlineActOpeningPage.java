package com.netBanking.ObjectRepository.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericTtilities.WebdiverUtility;

public class OnlineActOpeningPage {
	@FindBy(name = "name")private WebElement nameTxtfld;
	@FindBy(name = "gender")private WebElement genderTxtfld;
	@FindBy(name = "mobile")private WebElement mobileTxtfld;
	@FindBy(name = "email")private WebElement emailTxtfld;
	@FindBy(name = "landline")private WebElement landlineTxtField;
	@FindBy(name = "dob")private WebElement dobTxtField;
	@FindBy(name ="pan_no")private WebElement panTxtField;
	@FindBy(name ="citizenship")private WebElement citizenTxtField;
	@FindBy(name ="homeaddrs")private WebElement homeAddsTxtField;
	@FindBy(name ="officeaddrs")private WebElement officeAddTxtField;
	@FindBy(name ="state")private WebElement stateTxtField;
	@FindBy(name ="city")private WebElement cityTxtField;
	@FindBy(name ="pin")private WebElement pinTxtField;
	@FindBy(name = "arealoc")private WebElement areaLocTxtField;
	@FindBy(name="acctype")private WebElement accTypeLocTxtField;
	@FindBy(name = "submit")private WebElement submitBtn;
	@FindBy(name = "cnfrm-submit")private WebElement cnfSubmitBtn;
	@FindBy(xpath = "//input[@value='Go back']")private WebElement goBackBtn;
	
	
	public OnlineActOpeningPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void selectNameTxtfld(String Name)
	{
		nameTxtfld.sendKeys(Name);
	}
	public void selectgenderDropDown(String gender,WebdiverUtility wUtility)
	{
		wUtility.selectdropDownByVisibleText(genderTxtfld, gender);
	}
	
	public void enetrMobileTxtfld(String mobileNo)
	{
		mobileTxtfld.sendKeys(mobileNo);
	}
	
	public void enetrEmailTxtfld(String emailId)
	{
		emailTxtfld.sendKeys(emailId);
	}
	
	public void enetrlandlineTxtField(String landline)
	{
		landlineTxtField.sendKeys(landline);
	}
	
	public void enetrDobTxtField() throws AWTException
	{
		dobTxtField.click();
		Robot r=new Robot();
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
	
	public void eneterPanTxtField(String PANNO)
	{
		panTxtField.sendKeys(PANNO);
	}
	
	public void eneterCitizenNoTxtField(String citizenship)
	{
		citizenTxtField.sendKeys(citizenship);
	}
	
	public void eneterHomeAddsTxtField(String homeAdd)
	{
		homeAddsTxtField.sendKeys(homeAdd);
	}
	
	public void enterOfficeAddTxtField(String offAdd)
	{
		officeAddTxtField.sendKeys(offAdd);
	}
	
	public void enterStateDropDown(String state,WebdiverUtility wUtility)
	{
		wUtility.selectdropDownByVisibleText(stateTxtField, state);
	}
	public void eneterCityDropDown(String city,WebdiverUtility wUtility)
	{
		wUtility.selectdropDownByVisibleText(cityTxtField, city);
	}
	
	public void eneterPinTxtField(String pin)
	{
		pinTxtField.sendKeys(pin);
	}
	
	public void eneterareaLocTxtField(String area)
	{
		areaLocTxtField.sendKeys(area);
	}
	public void eneterAccTypeDropDown (String account,WebdiverUtility wUtility)
	{
	     wUtility.selectdropDownByVisibleText(accTypeLocTxtField, account);
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	public void clickcnfSubmitBtn()
	{
		cnfSubmitBtn.click();
	}
	public void clickGobackBtn()
	{
		goBackBtn.click();
	}
		
	
}
