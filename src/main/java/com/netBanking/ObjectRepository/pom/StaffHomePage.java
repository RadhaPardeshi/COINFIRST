package com.netBanking.ObjectRepository.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffHomePage {
	
	@FindBy(name = "home")private WebElement homebutton;
	@FindBy(name = "logout_btn")private WebElement logoutbutton;
	
	@FindBy(name = "viewdet")private WebElement viewActiveCustBtn;
	@FindBy(name = "view_cust_by_ac")private WebElement viewCustByAcNoBtn;
	@FindBy(name = "apprvac")private WebElement approvePenAccBtn;
	@FindBy(name = "del_cust")private WebElement delCustBtn;
	@FindBy(name = "credit_cust_ac")private WebElement creditCustAcBtn;
	
	public StaffHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getHomebutton() {
		return homebutton;
	}

	public void getLogoutbutton() {
		logoutbutton.click();
	}

	public WebElement getViewActiveCustBtn() {
		return viewActiveCustBtn;
	}

	public WebElement getViewCustByAcNoBtn() {
		return viewCustByAcNoBtn;
	}

	public WebElement getApprovePenAccBtn() {
		return approvePenAccBtn;
	}

	public WebElement getDelCustBtn() {
		return delCustBtn;
	}

	public WebElement getCreditCustAcBtn() {
		return creditCustAcBtn;
	}
	
	

}
