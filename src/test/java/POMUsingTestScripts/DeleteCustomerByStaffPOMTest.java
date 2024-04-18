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
import com.netBanking.ObjectRepository.pom.DeleteCutomerAccountPage;
import com.netBanking.ObjectRepository.pom.HomePage;
import com.netBanking.ObjectRepository.pom.InternetBankingRegistrationPage;
import com.netBanking.ObjectRepository.pom.OnlineActOpeningPage;
import com.netBanking.ObjectRepository.pom.StaffHomePage;
import com.netBanking.ObjectRepository.pom.StaffLoginPage;
import com.netBanking.ObjectRepository.pom.UserLoginPage;
import com.netBanking.ObjectRepository.pom.UsersHomePage;

public class DeleteCustomerByStaffPOMTest extends BaseClass
{
	public static String[] fetchDebit(String text) {
		String[] lines1 = text.split("\\r?\\n");
		System.out.println(Arrays.toString(lines1));
		// Search for the line containing the application number

		String debitCardNum = "";
		String pin1 = "";
		String[] parts = null;
		;
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
							break;
						}
					}
				}
			}
		}
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
	@Test
	public void deleteCustomerByStaffPOMTest()throws IOException, AWTException, InterruptedException 
	{
		
		fUtil.readDataFromPropertyFile("browser");
		String URL = fUtil.readDataFromPropertyFile("url");
		driver.get(URL);

		wUtil.maximizebrowser(driver);
		wUtil.implicitlyWaitStatement(driver, 10);
		driver.get(URL);

		HomePage homePage =new HomePage(driver);

		OnlineActOpeningPage onlineActOpeningPage = new OnlineActOpeningPage(driver);
		//driver.findElement(By.xpath("//li[text()='Open Account']")).click();
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

		//driver.findElement(By.name("name")).sendKeys(Name+jUtility.random());
		int random=jUtil.random();
		String CustName = Name+random;
		onlineActOpeningPage.selectNameTxtfld(CustName);

		//		WebElement gen = driver.findElement(By.name("gender"));
		//      wUtility.selectdropDownByVisibleText(gen, gender);
		onlineActOpeningPage.selectgenderDropDown(gender, wUtil);

		//driver.findElement(By.name("mobile")).sendKeys(mobileNo);
		onlineActOpeningPage.enetrMobileTxtfld(mobileNo);
		//driver.findElement(By.name("email")).sendKeys(emailId);
		onlineActOpeningPage.enetrEmailTxtfld(emailId);
		//driver.findElement(By.name("landline")).sendKeys(landline);
		onlineActOpeningPage.enetrlandlineTxtField(landline);
		//driver.findElement(By.name("pan_no")).sendKeys(panNo);
		String PANNO = panNo;
		Thread.sleep(3000);
		onlineActOpeningPage.eneterPanTxtField(PANNO);
		System.out.println(PANNO);
		System.out.println(PANNO.length());

		//driver.findElement(By.name("citizenship")).sendKeys(citizenship);
		onlineActOpeningPage.eneterCitizenNoTxtField(citizenship);
		//driver.findElement(By.name("homeaddrs")).sendKeys(homeAdd);
		onlineActOpeningPage.eneterHomeAddsTxtField(homeAdd);
		//driver.findElement(By.name("officeaddrs")).sendKeys(homeAdd);
		onlineActOpeningPage.enterOfficeAddTxtField(offAdd);


		//		WebElement stat = driver.findElement(By.name("state"));
		//		wUtility.selectdropDownByVisibleText(stat, state);
		onlineActOpeningPage.enterStateDropDown(state, wUtil);

		//		WebElement cit = driver.findElement(By.name("city"));
		//		wUtility.selectdropDownByVisibleText(cit, city);
		onlineActOpeningPage.eneterCityDropDown(city, wUtil);

		//driver.findElement(By.name("pin")).sendKeys(pin);
		onlineActOpeningPage.eneterPinTxtField(pin);

		//driver.findElement(By.name("arealoc")).sendKeys(area);
		onlineActOpeningPage.eneterareaLocTxtField(area);

		//		WebElement accot = driver.findElement(By.name("acctype"));
		//		wUtility.selectdropDownByVisibleText(accot, account);
		onlineActOpeningPage.eneterAccTypeDropDown(account, wUtil);


		//driver.findElement(By.name("dob")).click();
		onlineActOpeningPage.enetrDobTxtField();


		//driver.findElement(By.name("submit")).click();
		onlineActOpeningPage.getSubmitBtn().click();

		//driver.findElement(By.name("cnfrm-submit")).click();
		onlineActOpeningPage.clickcnfSubmitBtn();

		Alert a = wUtil.objectAlert(driver);
		
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());

		String apptext=a.getText();

		String[] lines = apptext.split("\\r?\\n");

		System.out.println(Arrays.toString(lines));
		// Search for the line containing the application number

		String applicationNumberStr = null;
		for (String line : lines) {
			if (line.startsWith("Application number :")) {
				// Split the line to get the application number
				String[] parts = line.split(":");
				// Extract the application number string
				applicationNumberStr = parts[1].trim();
				// Parse the application number string to integer
				//applicationNumber = Integer.parseInt(applicationNumberStr);

				break; // Break the loop once the application number is found
			}
		}
		wUtil.acceptAlert(driver);
		Thread.sleep(5000);
		String finaltitle = driver.getTitle();

		if(finaltitle.equalsIgnoreCase("Online banking System"))
		{
			System.out.println("Account opened with unique application id and test case pass");
		}
		else
		{
			System.out.println("Account not opened with unique application id and test case fail");
		}
		//driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
		homePage.getStaffLoginLink().click();

		StaffLoginPage staffLoginPage = new StaffLoginPage(driver);

		String USERNAME= fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");


		//driver.findElement(By.name("staff_id")).sendKeys(USERNAME);
		staffLoginPage.enterStaffIdFiled(USERNAME);

		//driver.findElement(By.name("password")).sendKeys(PASSWORD);
		staffLoginPage.enterPasswordFiled(PASSWORD);

		//driver.findElement(By.name("staff_login-btn")).click();
		staffLoginPage.getloginBtn().click();
		//Alert addpopup = driver.switchTo().alert();
		//addpopup.accept();

		StaffHomePage staffHomePage =new StaffHomePage(driver);
		//driver.findElement(By.name("apprvac")).click();
		staffHomePage.getApprovePenAccBtn().click();


		ApprovePendingAccountPage approvePendingAccountPage=new ApprovePendingAccountPage(driver);
		//driver.findElement(By.name("application_no")).sendKeys(applicationNumberStr);
		approvePendingAccountPage.eneterApplicationNoTxt(applicationNumberStr);

		//driver.findElement(By.name("search_application")).click();
		Thread.sleep(5000);
		approvePendingAccountPage.getSearchAppBtn().click();
		Thread.sleep(5000);

		//WebElement eleapp = approvePendingAccountPage.getApproveCustBtn();
		//Thread.sleep(2000);
		//String popupText = eleapp.getText();
		//driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]")).getText();

		//System.out.println(popupText);
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
		// Search for the line containing the application number

		for (String li : line) {
			if (li.startsWith("Account no :")) {
				// Split the line to get the application number
				String[] parts = li.split(":");
				// Extract the application number string
				accountID = parts[1].trim();
				// Parse the application number string to integer
				break;
			}
			System.out.println(accountID);

		}
		Thread.sleep(2000);
		wUtil.acceptAlert(driver);


		//driver.findElement(By.name("logout_btn")).click();
		staffHomePage.getLogoutbutton();


		//driver.findElement(By.xpath("//a[text()='Home']")).click();
		homePage.getHomePageLink().click();

		//driver.findElement(By.xpath("//li[text()='Apply Debit Card']")).click();
		homePage.getApplyDebitCardBtn().click();


		ApplyDebitCardPage applyDebitCardPage = new ApplyDebitCardPage(driver);
		//driver.findElement(By.name("holder_name")).sendKeys(Name);
		applyDebitCardPage.enterHolderNameTxt(CustName);
		System.out.println(CustName);
		//driver.findElement(By.name("dob")).click();
		applyDebitCardPage.enterDateBirthTxt();

		//driver.findElement(By.name("pan")).sendKeys(panNo);
		Thread.sleep(3000);
		applyDebitCardPage.getPanNo().sendKeys(PANNO);
		System.out.println(PANNO);
		System.out.println(PANNO.length());


		//driver.findElement(By.name("mob")).sendKeys(mobileNo);
		applyDebitCardPage.enterMobileNoTxt(mobileNo);
		System.out.println(mobileNo);

		//driver.findElement(By.name("acc_no")).sendKeys(accountID);
		applyDebitCardPage.enteraccNoTxt(accountID);
		System.out.println(accountID);

		//driver.findElement(By.name("dbt_crd_submit")).click();
		applyDebitCardPage.getSubBtn().click();
		Thread.sleep(3000);
		Alert add = wUtil.objectAlert(driver);
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

		//driver.findElement(By.xpath("//a[text()='Home']")).click();
		homePage.getHomePageLink().click();

		//WebElement element= driver.findElement(By.xpath("//li[contains(text(),'Register')]"));
		homePage.clickInternetBnkBtn(driver, wUtil);

		//		Actions action =new Actions(driver);
		//		action.moveToElement(el).perform();
		//		element.click();
		InternetBankingRegistrationPage internetBankingRegistrationPage = new InternetBankingRegistrationPage(driver);

		//driver.findElement(By.name("holder_name")).sendKeys(Name);
		Thread.sleep(2000);
		internetBankingRegistrationPage.typeHolderNameTxtf(CustName);

		//driver.findElement(By.name("accnum")).sendKeys(accountID);
		Thread.sleep(2000);
		internetBankingRegistrationPage.typeaccountNumTxtf(accountID);

		//driver.findElement(By.name("dbtcard")).sendKeys(debitno);
		Thread.sleep(2000);
		internetBankingRegistrationPage.typeDebitCardTxtf(debitno);

		//driver.findElement(By.name("dbtpin")).sendKeys(pin1no);
		Thread.sleep(2000);
		internetBankingRegistrationPage.typedebitCardPinTxtf(pin1no);

		//driver.findElement(By.name("mobile")).sendKeys(mobileNo);
		Thread.sleep(2000);
		internetBankingRegistrationPage.typemobiNoTxtf(mobileNo);

		//driver.findElement(By.name("pan_no")).sendKeys(panNo);
		Thread.sleep(3000);
		internetBankingRegistrationPage.typepANNoTxtf(PANNO);

		//driver.findElement(By.name("dob")).click();
		Thread.sleep(2000);
		internetBankingRegistrationPage.typedateOfBirthTxtf();

		//driver.findElement(By.name("last_trans")).sendKeys("0");
		Thread.sleep(2000);
		internetBankingRegistrationPage.typeLastTarnsTxtf();

		String password = eUtil.readDataFromExcelFile("useropenAccount", 10, 1);
		String confpassword = eUtil.readDataFromExcelFile("useropenAccount", 11, 1);

		//driver.findElement(By.name("password")).sendKeys(password);
		Thread.sleep(2000);
		internetBankingRegistrationPage.typepasswordTxtf(password);

		//driver.findElement(By.name("cnfrm_password")).sendKeys(confpassword);
		Thread.sleep(2000);
		internetBankingRegistrationPage.typeconfPasswordTxtf(confpassword);

		//driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		internetBankingRegistrationPage.getSubButton().click();
		Thread.sleep(3000);
		Alert pop = wUtil.objectAlert(driver);
		Thread.sleep(3000);
		String regpopup=pop.getText();
		Thread.sleep(5000);
		String internetAccountNumber="";
		for(int i=0;i<regpopup.length();i++) {
			if(Character.isDigit(regpopup.charAt(i))) {
				internetAccountNumber+=regpopup.charAt(i);
			}
		}

		System.out.println(internetAccountNumber);
		wUtil.acceptAlert(driver);

		//driver.findElement(By.xpath("//a[text()='Home']")).click();
		homePage.getHomePageLink().click();
		homePage.clickInternetBnkButton(driver, wUtil);

		UserLoginPage userLoginPage =new UserLoginPage(driver);
		userLoginPage.typecustIDTxt(internetAccountNumber);
		userLoginPage.typePasswordTxt(password);

		userLoginPage.pressLoginButton();
		
		UsersHomePage userHomePage = new UsersHomePage(driver);
		userHomePage.getLogoutButton().click();
		
		homePage.clickOnHomeLink();
		
		//driver.findElement(By.name("staff_id")).sendKeys(USERNAME);
		staffLoginPage.enterStaffIdFiled(USERNAME);

		//driver.findElement(By.name("password")).sendKeys(PASSWORD);
		staffLoginPage.enterPasswordFiled(PASSWORD);

		//driver.findElement(By.name("staff_login-btn")).click();
		staffLoginPage.getloginBtn().click();
		
		staffHomePage.getCreditCustAcBtn().click();
		
		DeleteCutomerAccountPage deleteCutomerAccountPage = new DeleteCutomerAccountPage(driver);
		deleteCutomerAccountPage.getCustACTxtf().sendKeys(applicationNumberStr);
		deleteCutomerAccountPage.getCustIDTxtf().sendKeys(internetAccountNumber);
		deleteCutomerAccountPage.getReasonTxtf().sendKeys("Not required");
		deleteCutomerAccountPage.getDeleteButton().click();
		Alert add1 = wUtil.objectAlert(driver);
		Thread.sleep(3000);
		String deleteText =add1.getText();
		Thread.sleep(3000);
		System.out.println("Debit data"+deleteText);
		
		if(deleteText.contains("Deleted Successfully"))
		{
			System.out.println("Staff is Successfully deleted Customer Account");
		}
		
		
	}
}
