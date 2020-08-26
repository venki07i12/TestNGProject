package baselibrary;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class Utility extends BaseLibrary{

	
	public void click(WebElement ele, String elementname) throws Throwable
	{
		try {
			wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			System.out.println("Clicked on element " + elementname);
			logger.log(LogStatus.PASS, "Should click on element " + elementname, "Clicked on element " + elementname + logger.addScreenCapture(takeScreenShot(driver)));
		} catch (Exception e) {
			System.out.println("Not Clicked on element " + elementname);
			System.out.println(e);
			logger.log(LogStatus.FAIL, "Should click on element " + elementname, "Not Clicked on element " + elementname + "Due to" +e +"<br>" + logger.addScreenCapture(takeScreenShot(driver)));
		}
		
	}
	
	public void verifyelement(WebElement ele, String elementname) throws Throwable
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.isDisplayed();
			System.out.println(elementname + " Element is Displayed");
			logger.log(LogStatus.PASS, "Should Display the element " + elementname, "Element is Diplayed " + elementname + logger.addScreenCapture(takeScreenShot(driver)));
		}catch (Exception e) {
			System.out.println(elementname + " Element not Displayed");
			System.out.println(e);
			logger.log(LogStatus.FAIL, "Should Display the element " + elementname, "Element is not Diplayed " + elementname + "Due to" +e + logger.addScreenCapture(takeScreenShot(driver)));
		}
		
	}
	
	public void entertext(WebElement ele, String elementname) throws Throwable {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.sendKeys("Dresses");
			System.out.println(elementname + " Element is Displayed");
			logger.log(LogStatus.PASS, "Should Display the element " + elementname, "Element is Diplayed " + elementname + logger.addScreenCapture(takeScreenShot(driver)));
		}catch (Exception e) {
			System.out.println(elementname + " Element not Displayed");
			System.out.println(e);
			logger.log(LogStatus.FAIL, "Should Display the element " + elementname, "Element is not Diplayed " + elementname + "Due to" +e + logger.addScreenCapture(takeScreenShot(driver)));
		}
	}
	
	public void dropdown(WebElement ele, String elementname) throws Throwable
	{
	try {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		List<WebElement> lc = ele.findElements(By.tagName("option"));
		boolean status = false;
		for(int i=0; i<lc.size();i++) {
		String Productinfo = lc.get(i).getText();
		if(Productinfo.equals("In stock")) {
			Select select = new Select(ele);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			select.selectByVisibleText("In stock");
			System.out.println("Option with 'In stock' is available in Dropdown");
			status = true;
			break;
			}
		}
		System.out.println(elementname + " Element is Displayed");
		logger.log(LogStatus.PASS, "Option with 'In stock' is available in Dropdown" + elementname, "Element is visible" + elementname + logger.addScreenCapture(takeScreenShot(driver)));
		} catch (Exception e) {
		System.out.println(e);
		logger.log(LogStatus.FAIL, "Option with 'In stock' is  not available in Dropdown" + elementname, "Element is not Diplayed " + elementname + "Due to" +e + logger.addScreenCapture(takeScreenShot(driver)));
		}
	
}
}
