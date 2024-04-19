package POMUsingTestScripts;

import java.awt.AWTException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.GenericTtilities.BaseClass;
import com.GenericTtilities.ExcelUtility;
import com.GenericTtilities.FileUtility;
import com.GenericTtilities.JavaUtility;
import com.GenericTtilities.WebdiverUtility;
import com.netBanking.ObjectRepository.pom.ApplyDebitCardPage;
import com.netBanking.ObjectRepository.pom.ApprovePendingAccountPage;
import com.netBanking.ObjectRepository.pom.HomePage;
import com.netBanking.ObjectRepository.pom.InternetBankingRegistrationPage;
import com.netBanking.ObjectRepository.pom.OnlineActOpeningPage;
import com.netBanking.ObjectRepository.pom.StaffHomePage;
import com.netBanking.ObjectRepository.pom.StaffLoginPage;
import com.netBanking.ObjectRepository.pom.UserLoginPage;

public class LoginAsUserPOMTest extends BaseClass {
	public static String[] fetchDebit(String text) {
		String[] lines1 = text.split("\\r?\\n");
		System.out.println(Arrays.toString(lines1));
		String debitCardNum = "";
		String pin1 = "";
		String[] parts = null;
		for (String liD : lines1) {
			if (liD.contains("Your Debit Card No is : ")) 
			{
				// Split the line to get the application number
				parts = liD.trim().split(" ");

				for (String part : parts) {
					if (isNumeric(part)) {
						if (debitCardNum.isEmpty()) {
							debitCardNum = part;
						} else {
							pin1 = part;
							break;}}}}}
		String[] arr= {debitCardNum,pin1};
		return arr;	
	}
	public static boolean isNumeric(String str) {

		for (int i = 0; i < str.length(); i++) {

			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public void saveDataInExcel(Workbook workbook) throws IOException {

		FileOutputStream fOut= new FileOutputStream(".\\src\\test\\resources\\Coin1TestData.xlsx");

		workbook.write(fOut);
	}
//	@Test(retryAnalyzer = com.genericutilities.RetryImplementationClass.class)
	@Test
	public void loginAsUserInBanking() throws IOException, AWTException, InterruptedException 
	{
		
	    String URL = fUtil.readDataFromPropertyFile("url");
		driver.get(URL);
		HomePage homePage =new HomePage(driver);
		OnlineActOpeningPage onlineActOpeningPage = new OnlineActOpeningPage(driver);
		homePage.getOpenAccountBtn().click();
		String Name= eUtil.readDataFromExcelFile("useropenAccount", 0, 1);
		String mobileNo = eUtil.readDataFromExcelFile("useropenAccount", 1, 1);
		String emailId = eUtil.readDataFromExcelFile("useropenAccount", 2, 1);
		String panNo= eUtil.readDataFromExcelFile("useropenAccount", 3, 1);
		String citizenship= eUtil.readDataFromExcelFile("useropenAccount", 4, 1);
		String homeAdd=eUtil.readDataFromExcelFile("useropenAccount", 5, 1);
		String offAdd=eUtil.readDataFromExcelFile("useropenAccount", 6, 1);
		String pin= eUtil.readDataFromExcelFile("useropenAccount", 7, 1);
		String area= eUtil.readDataFromExcelFile("useropenAccount", 8, 1);
		String landline =eUtil.readDataFromExcelFile("useropenAccount", 9, 1);
		String gender = eUtil.readDataFromExcelFile("useropenAccount", 0, 5);
		String state = eUtil.readDataFromExcelFile("useropenAccount", 1, 5);
		String city = eUtil.readDataFromExcelFile("useropenAccount", 2, 5);
		String account= eUtil.readDataFromExcelFile("useropenAccount", 3, 5);
		int random=jUtil.random();
		String CustName = Name+random;
		onlineActOpeningPage.selectNameTxtfld(CustName);
		onlineActOpeningPage.selectgenderDropDown(gender, wUtil);
		onlineActOpeningPage.enetrMobileTxtfld(mobileNo);
		onlineActOpeningPage.enetrEmailTxtfld(emailId);
		onlineActOpeningPage.enetrlandlineTxtField(landline);
		String PANNO = panNo;
		Thread.sleep(3000);
		onlineActOpeningPage.eneterPanTxtField(PANNO);
		System.out.println(PANNO);
		System.out.println(PANNO.length());
		onlineActOpeningPage.eneterCitizenNoTxtField(citizenship);
		onlineActOpeningPage.eneterHomeAddsTxtField(homeAdd);
		onlineActOpeningPage.enterOfficeAddTxtField(offAdd);
		onlineActOpeningPage.enterStateDropDown(state, wUtil);
		onlineActOpeningPage.eneterCityDropDown(city, wUtil);
		onlineActOpeningPage.eneterPinTxtField(pin);
		onlineActOpeningPage.eneterareaLocTxtField(area);
		onlineActOpeningPage.eneterAccTypeDropDown(account, wUtil);
		onlineActOpeningPage.enetrDobTxtField();
		onlineActOpeningPage.getSubmitBtn().click();
		onlineActOpeningPage.clickcnfSubmitBtn();
		Alert a = wUtil.objectAlert(driver);
		String apptext=a.getText();
		String[] lines = apptext.split("\\r?\\n");
		System.out.println(Arrays.toString(lines));
		String applicationNumberStr = null;
		for (String line : lines) {
			if (line.startsWith("Application number :")) {
				String[] parts = line.split(":");
				applicationNumberStr = parts[1].trim();
				break; 
			}
		}
		wUtil.acceptAlert(driver);
		Thread.sleep(5000);
		String finaltitle = driver.getTitle();
		if(finaltitle.equalsIgnoreCase("Online banking System")){
			System.out.println("Account opened with unique application id and test case pass");}
		else{
			System.out.println("Account not opened with unique application id and test case fail");}
		homePage.getStaffLoginLink().click();
		StaffLoginPage staffLoginPage = new StaffLoginPage(driver);
        String USERNAME= fUtil.readDataFromPropertyFile("username");
        String PASSWORD = fUtil.readDataFromPropertyFile("password");
		staffLoginPage.enterStaffIdFiled(USERNAME);
		staffLoginPage.enterPasswordFiled(PASSWORD);
		staffLoginPage.getloginBtn().click();
		StaffHomePage staffHomePage =new StaffHomePage(driver);
		staffHomePage.getApprovePenAccBtn().click();
		ApprovePendingAccountPage approvePendingAccountPage=new ApprovePendingAccountPage(driver);
		approvePendingAccountPage.eneterApplicationNoTxt(applicationNumberStr);		
		Thread.sleep(5000);
		approvePendingAccountPage.getSearchAppBtn().click();
		Thread.sleep(5000);
		String accountID =null ;
		Thread.sleep(5000);
		approvePendingAccountPage.getApproveCustBtn().click();
		Thread.sleep(5000);
		Alert aler = wUtil.objectAlert(driver);
		Thread.sleep(5000);
		String txt=aler.getText();
		Thread.sleep(5000);

		String[] line = txt.split("\\r?\\n");

		System.out.println(Arrays.toString(line));
		
		for (String li : line) {
			if (li.startsWith("Account no :")) {
				String[] parts = li.split(":");
				accountID = parts[1].trim();
				break;
			}
			System.out.println(accountID);
		}
		Thread.sleep(2000);
		wUtil.acceptAlert(driver);
		staffHomePage.getLogoutbutton();
		homePage.getHomePageLink().click();
		homePage.getApplyDebitCardBtn().click();
		ApplyDebitCardPage applyDebitCardPage = new ApplyDebitCardPage(driver);
		applyDebitCardPage.enterHolderNameTxt(CustName);
		System.out.println(CustName);
		applyDebitCardPage.enterDateBirthTxt();
		Thread.sleep(3000);
		applyDebitCardPage.getPanNo().sendKeys(PANNO);
		System.out.println(PANNO);
		System.out.println(PANNO.length());
		applyDebitCardPage.enterMobileNoTxt(mobileNo);
		System.out.println(mobileNo);
		applyDebitCardPage.enteraccNoTxt(accountID);
		System.out.println(accountID);
		applyDebitCardPage.getSubBtn().click();
		Thread.sleep(3000);
		Alert add = wUtil.objectAlert(driver);
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(3000);
		String debitText =add.getText();
		Thread.sleep(3000);
		System.out.println("Debit data"+debitText);
		String[] arr=fetchDebit(debitText) ;
		System.out.println(arr);
		String debitno = arr[0];
		String pin1no = arr[1];
		System.out.println(debitno); 
		System.out.println(pin1no);
		wUtil.acceptAlert(driver);
		homePage.getHomePageLink().click();
		homePage.clickInternetBnkBtn(driver, wUtil);
	    InternetBankingRegistrationPage internetBankingRegistrationPage = new InternetBankingRegistrationPage(driver);Thread.sleep(2000);
		 internetBankingRegistrationPage.typeHolderNameTxtf(CustName);Thread.sleep(2000);
		 internetBankingRegistrationPage.typeaccountNumTxtf(accountID);Thread.sleep(2000);
		 internetBankingRegistrationPage.typeDebitCardTxtf(debitno);Thread.sleep(2000);
		 internetBankingRegistrationPage.typedebitCardPinTxtf(pin1no);Thread.sleep(2000);
		 internetBankingRegistrationPage.typemobiNoTxtf(mobileNo);Thread.sleep(3000);
		 internetBankingRegistrationPage.typepANNoTxtf(PANNO);Thread.sleep(2000);
		 internetBankingRegistrationPage.typedateOfBirthTxtf();Thread.sleep(2000);
		 internetBankingRegistrationPage.typeLastTarnsTxtf();
		 String password = eUtil.readDataFromExcelFile("useropenAccount", 10, 1);
		 String confpassword = eUtil.readDataFromExcelFile("useropenAccount", 11, 1);
		 Thread.sleep(2000);
		 internetBankingRegistrationPage.typepasswordTxtf(password);Thread.sleep(2000);
		 internetBankingRegistrationPage.typeconfPasswordTxtf(confpassword);Thread.sleep(2000);
		 internetBankingRegistrationPage.getSubButton().click();Thread.sleep(3000);
		 Alert pop = wUtil.objectAlert(driver);Thread.sleep(3000);
		 String regpopup=pop.getText();Thread.sleep(5000);
		 String internetAccountNumber="";
		for(int i=0;i<regpopup.length();i++) {
			if(Character.isDigit(regpopup.charAt(i))) {
				internetAccountNumber+=regpopup.charAt(i);}
		}
		System.out.println(internetAccountNumber);
		wUtil.acceptAlert(driver);
		homePage.getHomePageLink().click();
		homePage.clickInternetBnkButton(driver, wUtil);
		UserLoginPage userLoginPage = new UserLoginPage(driver);
		userLoginPage.typecustIDTxt(internetAccountNumber);
		userLoginPage.typePasswordTxt(password);
		userLoginPage.pressLoginButton();
		System.out.println("print");
		
		
	}

}
