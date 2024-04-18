package com.netBanking.ObjectRepository.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCutomerAccountPage {
	
	@FindBy(name = "Cust_ac_no") private WebElement custACTxtf;
	@FindBy(name = "Cust_ac_Id")private WebElement custIDTxtf;
	@FindBy(name = "reason")private WebElement reasonTxtf;
	@FindBy(name = "delete")private WebElement deleteButton;
	
	
	public DeleteCutomerAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getCustACTxtf() {
		return custACTxtf;
	}


	public WebElement getCustIDTxtf() {
		return custIDTxtf;
	}


	public WebElement getReasonTxtf() {
		return reasonTxtf;
	}


	public WebElement getDeleteButton() {
		return deleteButton;
	}
	
	

}
