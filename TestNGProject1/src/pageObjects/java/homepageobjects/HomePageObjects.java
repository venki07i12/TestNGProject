package homepageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import baselibrary.BaseLibrary;

public class HomePageObjects extends BaseLibrary {
	
	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH, using = "//a[@title='Women']")
	public WebElement women;
	
	@FindBy(how=How.XPATH, using = "(//img[contains(@class,'replace-2x')])[2]")
	public WebElement WomenTops;
	
	@FindBy(how=How.XPATH, using = "(//a[@title='Dresses'])[2]")
	public WebElement Dresses;
	
	@FindBy(how=How.XPATH, using = "(//a[contains(@title,'T-shirts')])[2]")
	public WebElement Tshirts;
	
	@FindBy(how=How.XPATH, using = "//a[text()='Contact us']")
	public WebElement Contactus;
	
	@FindBy(how=How.XPATH, using = "//a[contains(.,'Sign in')]")
	public WebElement Signin;
	
	@FindBy(how=How.XPATH, using = "//input[@id='search_query_top']")
	public WebElement searchtext;
	
	@FindBy(how=How.XPATH, using = "//button[@type='submit'][contains(.,'Search')]")
	public WebElement searchbutton;
	
	@FindBy(how=How.XPATH, using = "//select[@id='selectProductSort']")
	public WebElement dropdwon;
	
	@FindBy(how=How.XPATH, using = "//a[contains(text(),'Popular')]")
	public WebElement Popular;
	
	@FindBy(how=How.XPATH, using = "//a[contains(text(),'Best Sellers')]")
	public WebElement BestSellers;
	
	@FindBy(how=How.XPATH, using = "(//a[contains(text(),'Tops')])[2]")
	public WebElement Tops;
	
	@FindBy(how=How.XPATH, using = "(//a[contains(text(),'shirts')])[3]")
	public WebElement Tshirt;
}
