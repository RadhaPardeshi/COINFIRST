package com.GenericTtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Radha
 */
public class WebdiverUtility {

	/**
	 * This method is used for maximizing the browser
	 * @param driver
	 */
	public void maximizebrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used for minimizing the browser
	 * @param driver
	 */
	public void minimizebrowser(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method is used for Synchronization till mentioned seconds
	 * @param driver
	 * @param sec
	 */
	public void implicitlyWaitStatement(WebDriver driver,int sec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	
	/**
	 * This method is used for Synchronization using explicitly wait with condition
	 * @param driver
	 * @param sec
	 * @return
	 */
	public WebDriverWait explicitlyWaitStaement(WebDriver driver,int sec)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		return wait;
	}
	
	
	/**
	 * This method is used for Synchronization using explicitly wait with element to be clickable
	 * @param driver
	 * @param sec
	 * @param element
	 */
	public void waitlUntilEleToBeClickable(WebDriver driver,int sec,WebElement element)
	{
		explicitlyWaitStaement(driver, sec).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	/**
	 * This method is used for Synchronization using explicitly wait with condition
	 * @param driver
	 * @param sec
	 * @param element
	 */
	public void waitlUntilUrlToBe(WebDriver driver,int sec,String element)
	{
		explicitlyWaitStaement(driver, sec).until(ExpectedConditions.urlToBe(element));
	}
	/**
	 * This method is used for creating 
	 * @param driver
	 * @return
	 */
	public Actions mouseactionObject(WebDriver driver)
	{
		Actions act =new Actions(driver);
		return act;
	}
	
	public void mousehoveraction(WebDriver driver,WebElement element)
	{
		
		mouseactionObject(driver).moveToElement(element).perform();
	}
	
	public void dragAndDropaction(WebDriver driver,WebElement src,WebElement dest)
	{
		mouseactionObject(driver).dragAndDrop(src, dest).perform();
	}
	
	public void dragAndDropByaction(WebDriver driver,WebElement element,int x,int y)
	{
		mouseactionObject(driver).dragAndDropBy(element,x,y).perform();
	}
	
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		mouseactionObject(driver).doubleClick(element).perform();
	}
	
	
	public void contexClickAction(WebDriver driver,WebElement element)
	{
		
		mouseactionObject(driver).contextClick(element).perform();
	}
	

	public Select dropDownObject(WebElement element)
	{
		Select sel=new Select(element);
		return sel;
	}
	
	public void selectDropdownByindex(WebElement element,int index)
	{	
		dropDownObject(element).selectByIndex(index);
	}
	
	public void selectdropDownByValue(WebElement element ,String value)
	{
		dropDownObject(element).selectByValue(value);
	}
	
	
	public void selectdropDownByVisibleText(WebElement element ,String text)
	{
		dropDownObject(element).selectByVisibleText(text);
	}
	
	
	public Robot robotClassObject() throws AWTException
	{
		Robot robt =new Robot();
		return robt;
	}
	
	
	public void enetrkeyPress() throws AWTException
	{
		robotClassObject().keyPress(KeyEvent.VK_2);
		robotClassObject().keyPress(KeyEvent.VK_7);
		robotClassObject().keyPress(KeyEvent.VK_0);
		robotClassObject().keyPress(KeyEvent.VK_2);
		robotClassObject().keyRelease(KeyEvent.VK_2);
		robotClassObject().keyPress(KeyEvent.VK_2);
		robotClassObject().keyPress(KeyEvent.VK_0);
		robotClassObject().keyPress(KeyEvent.VK_2);
		robotClassObject().keyPress(KeyEvent.VK_4);
	}
	
	public void enetrkeyRelease() throws AWTException
	{
		robotClassObject().keyRelease(KeyEvent.VK_7);
	}
	
	public void switchToWindow(WebDriver driver)
	{
		Set<String> window=driver.getWindowHandles();
		Iterator<String> it=window.iterator();
		while(it.hasNext())
		{
			String win = it.next();
			String title = driver.switchTo().window(win).getTitle();
		}
	}
	
	public void switchFrameByindex(WebDriver driver,int fNo)
	{
		driver.switchTo().frame(fNo);
	}
	
	public void switchFrameByname(WebDriver driver,String fName)
	{
		driver.switchTo().frame(fName);
	}
	
	public void switchFrameByElement(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public Alert objectAlert(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		return alt;
	}
	
	
	public void acceptAlert(WebDriver driver)
	{
		objectAlert(driver).accept();
	}
	
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void sendDatatoAlert(WebDriver driver,String text)
	{
		driver.switchTo().alert().sendKeys(text);;
	}
	
	public static String getSceeenShot(WebDriver driver,String screenshotName) throws IOException
	{
		
		JavaUtility jUtil = new JavaUtility();
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path ="./screenshot/"+screenshotName+" "+jUtil.getSystemDateInFormat()+".png";
		File dest=new File(path);
		String srcPath = dest.getAbsolutePath();
		FileUtils.copyFile(src, dest);
		return srcPath;
	}
	
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)", "");
	}
	
	public void scrollAction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.srollBy(0,"+y+")", "");
	}
	
	public void scrollTillbottomOfThepage(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void scrollTillEleToBeVisible(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()",element);
	}
	
	public void clickOnElement(WebDriver driver,WebElement element,String expData )
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=arguments[1]",element,expData);
	}
	
	public void scrollUptillElementTobevisible(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		Point loc = element.getLocation();
		int x= loc.getX();
		int y=loc.getY();
		js.executeScript("window.scrollBy("+x+" , "+y+")");
	}

	public static void getSceeenShot(Class<BaseClass> class1, String methodname) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
