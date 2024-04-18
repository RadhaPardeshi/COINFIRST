package com.netBanking.ObjectRepository.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {
	
	@FindBy(name = "customer_id")private WebElement custIDTxt;
	@FindBy(name = "password")private WebElement passwordTxt;
	@FindBy(name = "login-btn")private WebElement loginButton;
	
	public UserLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void typecustIDTxt(String internetAccountNumber)
	{
		custIDTxt.sendKeys(internetAccountNumber);
	}
	
	public void typePasswordTxt(String password)
	{
		passwordTxt.sendKeys(password);
	}
	
	public void pressLoginButton()
	{
		loginButton.click();
	}
	
	
	

}
