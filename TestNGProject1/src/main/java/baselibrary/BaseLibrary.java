package baselibrary;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseLibrary {

	public WebDriver driver;
	public Properties prop;
	public static Date date = new Date();
	public static DateFormat dateformat = new SimpleDateFormat("MM-dd-yyyy HHmmss");
	public static String reportLocation = System.getProperty("user.dir") + "\\Reports\\Reports_"
			+ dateformat.format(date) + "\\";
	public ExtentReports reports;
	public ExtentTest logger;
	public WebDriverWait wait;

	public void initialize() throws Exception {
		FileInputStream fis = new FileInputStream(".//config.properties");
		prop = new Properties();
		prop.load(fis);

	}

	
	/*  @BeforeSuite public void invokereports() { reports = new
	  ExtentReports(reportLocation + "Reports_" + dateformat.format(date) +
	  ".html"); reports .addSystemInfo("Environment URL", prop.getProperty("url"))
	  .addSystemInfo("Browser", prop.getProperty("browser")) .addSystemInfo("Test",
	  "xyz"); }
	 */
	
//if we specify the above code in @BeforeClass we can see the Environment details in ExtentReports

	@BeforeClass
	public void LaunchBrowser() throws Exception {
		reports = new ExtentReports(reportLocation + "Reports_" + dateformat.format(date) + ".html");
		initialize();
		reports
		.addSystemInfo("Environment URL", prop.getProperty("url"))
		.addSystemInfo("Browser", prop.getProperty("browser"))
		.addSystemInfo("Test", "xyz");
		
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
			driver.manage().getCookies().clear();
			driver.get(prop.getProperty("url"));
			StartTest("Invoke Chrome Browser");
			logger.log(LogStatus.INFO, "Browser is launched and navigated to URL " + prop.getProperty("url"));
			endTest();
		} else if (prop.getProperty("browser").equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().getCookies().clear();
			driver.get(prop.getProperty("url"));
			StartTest("Invoke firefox Browser");
			logger.log(LogStatus.INFO, "Browser is launched and navigated to URL " + prop.getProperty("url"));
			endTest();
		} else
			System.out.println("No Browser was found");
	}

	public void StartTest(String Testname) {
		logger = reports.startTest(Testname);

	}

	public void endTest() {
		reports.endTest(logger);
	}

	@AfterClass
	public void closebrowser() {
		driver.close();
		reports.flush();
	}

	public String takeScreenShot(WebDriver driver) throws Throwable {
		UUID uuid = UUID.randomUUID();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(reportLocation + uuid + ".png"));
		return uuid + ".png";
	}

}
