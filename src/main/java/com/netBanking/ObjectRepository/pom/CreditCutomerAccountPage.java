package com.netBanking.ObjectRepository.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCutomerAccountPage {
	
	@FindBy(name = "customer_account_no")private WebElement custAccNoTxt;
	@FindBy(name = "credit_amount")private WebElement creditAmtTxt;
	@FindBy(name="credit_btn")private WebElement creditButton;
	
	public CreditCutomerAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCustAccNoTxt() {
		return custAccNoTxt;
	}

	public WebElement getCreditAmtTxt() {
		return creditAmtTxt;
	}

	public WebElement getCreditButton() {
		return creditButton;
	}
	
	

}
