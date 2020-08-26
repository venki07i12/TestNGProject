package testpackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import baselibrary.BaseLibrary;
import baselibrary.Utility;
import homepageobjects.HomePageObjects;
import junit.framework.Assert;

public class Testclass extends Utility {

	@Test(priority = 1)
	public void women() throws Throwable
	{
		StartTest("Verify Women items");
		HomePageObjects hm = new HomePageObjects(driver);
		click(hm.women, "women");
		verifyelement(hm.women, "women");
		String actualTitle= driver.getTitle();
		String expectedTitle = "Women - My Store";
		Assert.assertEquals("Condition true", actualTitle, expectedTitle);
		Actions act = new Actions(driver);
		System.out.println("welcome to Skilldrive");
		act.moveToElement(hm.WomenTops).build().perform(); 
		endTest();
	}
	
	
	@Test(priority = 2)
	public void dresses() throws Throwable
	{
		StartTest("Verify Dresses");
		HomePageObjects hm = new HomePageObjects(driver);
		click(hm.Dresses, "Dresses");
		verifyelement(hm.Dresses, "Dresses");
		endTest();
	}

	@Test(priority = 3)
	public void Tshirts() throws Throwable
	{
		StartTest("Verify T-shirts");
		HomePageObjects hm = new HomePageObjects(driver);
		click(hm.Tshirts, "Tshirts");
		verifyelement(hm.Tshirts, "Tshirts");
		endTest();
	}

	@Test(priority = 4)
	public void Contactus() throws Throwable
	{
		StartTest("Verify Contactus navigation");
		HomePageObjects hm = new HomePageObjects(driver);
		click(hm.Contactus, "Contactus");
		verifyelement(hm.Contactus, "Contactus");
		endTest();
	}
	
	@Test(priority = 5)
	public void Signin() throws Throwable
	{
		StartTest("Verify Signin Account");
		HomePageObjects hm = new HomePageObjects(driver);
		click(hm.Signin, "Signinbutton");
		verifyelement(hm.Signin, "Signinbutton");
		endTest();
	}
	
	@Test(priority = 6)
	public void Searchtext() throws Throwable
	{
		StartTest("Type items to be search");
		HomePageObjects hm = new HomePageObjects(driver);
		entertext(hm.searchtext, "searchtextitem");
		endTest();
	}
	
	@Test(priority = 7)
	public void Searchbutton() throws Throwable
	{
		StartTest("Submit after searching an item");
		HomePageObjects hm = new HomePageObjects(driver);
		click(hm.searchbutton, "searchbutton");
		verifyelement(hm.searchbutton, "searchbutton");
		endTest();
	}
	
	@Test(priority = 8)
	public void dropdown()
	{
		WebElement pro = driver.findElement(By.id("selectProductSort"));
		List<WebElement> lc = pro.findElements(By.tagName("option"));
		boolean status = false;
		for(int i=0; i<lc.size();i++) {
		String Productinfo = lc.get(i).getText();
		if(Productinfo.equals("In stock")) {
			Select select = new Select(pro);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			select.selectByVisibleText("In stock");
			System.out.println("Option with 'In stock' is available in Dropdown");
			status = true;
			break;
		}
		}
		if (status != true) {
			System.out.println("Option with 'In stock' is  not available in Dropdown");
		}
	} 
	
/*	@Test(priority = 8)
	public void dropdown() throws Throwable
	{
		StartTest("Select dropdown options");
		HomePageObjects hm = new HomePageObjects(driver);
		dropdown(hm.dropdwon, "select dropdown item");
		endTest();
	} */
	
	@Test(priority = 9)
	public void getlinks()
	{
		List<WebElement> alinks = driver.findElements(By.tagName("a"));
		System.out.println("No of Link in a page: " + alinks.size());
		
		for(WebElement link:alinks){
			 System.out.println(link.getText() + " - " + link.getAttribute("href"));
			 }
	}
}
