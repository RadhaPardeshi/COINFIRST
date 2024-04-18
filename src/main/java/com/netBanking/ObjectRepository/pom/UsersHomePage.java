package com.netBanking.ObjectRepository.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersHomePage {

	@FindBy(name = "home")private WebElement homebutton;
	@FindBy(name = "logout_btn")private WebElement logoutButton;
	
	@FindBy(xpath = "//li[text()='My Account']")private WebElement myAccLink;
	@FindBy(xpath = "//li[text()='My Profile']")private WebElement myProfLink;
	@FindBy(xpath = "//li[text()='Change Password']")private WebElement changePwdLink;
	@FindBy(xpath = "//li[text()='Fund Transfer']")private WebElement fundTranLink;
	
	
	public UsersHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getHomebutton() {
		return homebutton;
	}


	public WebElement getLogoutButton() {
		return logoutButton;
	}


	public WebElement getMyAccLink() {
		return myAccLink;
	}


	public WebElement getMyProfLink() {
		return myProfLink;
	}


	public WebElement getChangePwdLink() {
		return changePwdLink;
	}


	public WebElement getFundTranLink() {
		return fundTranLink;
	}
	
	
	
}
