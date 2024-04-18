package com.netBanking.ObjectRepository.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffLoginPage {
	
	@FindBy(name = "staff_id")private WebElement staffIdFiled;
	
	@FindBy(name="password")private WebElement passwordFiled;
	
	@FindBy(name = "staff_login-btn")private WebElement loginBtn;
	
	public StaffLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterStaffIdFiled(String USERNAME)
	{
		staffIdFiled.sendKeys(USERNAME);
	}
	
	public void enterPasswordFiled(String PASSWORD)
	{
		passwordFiled.sendKeys(PASSWORD);
	}

	public WebElement getloginBtn() {
		return loginBtn;
	}

}
