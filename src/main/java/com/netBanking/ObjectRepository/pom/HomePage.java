package com.netBanking.ObjectRepository.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericTtilities.WebdiverUtility;

public class HomePage {

	@FindBy(xpath  ="//a[text()='Home']") private WebElement homePageLink;
	
	@FindBy(xpath = "//a[text()='Staff Login']") private WebElement staffLoginLink;
	
	@FindBy(xpath = "//li[text()='Open Account']") 
	private WebElement openAccountBtn;
	
	@FindBy(xpath = "//li[text()='Apply Debit Card']")private WebElement applyDebitCardBtn;
	
	@FindBy(id = "ebanking")private WebElement internetBnkBtn;
	
	@FindBy(xpath = "//li[text()='Fund Transfer']")private WebElement fundTransBtn;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getOpenAccountBtn() {
		return openAccountBtn;
	}
	public WebElement getHomePageLink() {
		return homePageLink;
	}

	public WebElement getStaffLoginLink() {
		return staffLoginLink;
	}


	public WebElement getApplyDebitCardBtn() {
		return applyDebitCardBtn;
	}

	public void clickInternetBnkBtn(WebDriver driver,WebdiverUtility wUtility) {
		WebElement el=driver.findElement(By.xpath("//a[contains(text(),'Internet Banking')]"));
		wUtility.scrollTillEleToBeVisible(driver, el);
		WebElement element= driver.findElement(By.xpath("//li[contains(text(),'Register')]"));
		wUtility.mousehoveraction(driver, el);
		element.click();
	}
	
	public void clickInternetBnkButton(WebDriver driver,WebdiverUtility wUtility) {
		WebElement el=driver.findElement(By.xpath("//a[contains(text(),'Internet Banking')]"));
		wUtility.scrollTillEleToBeVisible(driver, el);
		WebElement element= driver.findElement(By.xpath("//li[contains(text(),'Login')]"));
		wUtility.mousehoveraction(driver, el);
		element.click();
	}

	public WebElement getFundTransBtn() {
		return fundTransBtn;
	}
	
	public void clickOnHomeLink()
	{
		homePageLink.click();
	}
	
	public void clickstaffLoginLink()
	{
		staffLoginLink.click();
	}
	
	
	
}
