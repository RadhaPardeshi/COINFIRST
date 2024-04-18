package com.netBanking.ObjectRepository.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApprovePendingAccountPage {
	
	@FindBy(name = "application_no")private WebElement applicationNoTxt;
	@FindBy(name = "search_application")private WebElement searchAppBtn;
	@FindBy(name = "approve_cust")private WebElement approveCustBtn;
	//@FindBy(name = "logout_btn")private WebElement approveLogoutBtn;
	
	public ApprovePendingAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void eneterApplicationNoTxt(String applicationNumberStr )
	{
		applicationNoTxt.sendKeys(applicationNumberStr);
	}
	public WebElement getSearchAppBtn() {
		return searchAppBtn;
	}
	public WebElement getApproveCustBtn() {
		return approveCustBtn;
	}
//	public void getApproveLogoutBtn() {
//		approveLogoutBtn.click();
//	}

}
