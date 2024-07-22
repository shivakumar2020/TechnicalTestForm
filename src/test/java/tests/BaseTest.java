package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.ConfiguratorSupport;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

/**
 * The Class BaseTest.
 */
public class BaseTest {

	/** The cs. */
	protected ConfiguratorSupport cs = new ConfiguratorSupport("config.properties");
	
	/** The browser name. */
	protected String browserName = cs.getProperty("browser");
	
	/** The headless mode. */
	private String headlessMode = cs.getProperty("headless");

	/** The driver. */
	protected WebDriver driver;
	
	/** The extent. */
	protected ExtentReports extent;
	
	/** The test. */
	protected ExtentTest test;

	/**
	 * Sets the up extent.
	 */
	@BeforeSuite
	public void setUpExtent() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("reports/AutomationReport.html");
		reporter.config().setReportName("Automation Test  Report");
		reporter.config().setDocumentTitle("Test Results");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Shiva Kumar");
	}

	/**
	 * Sets the up.
	 */
	@BeforeMethod
	public void setUp() {
		if(browserName == null) {
			browserName = "chrome";
		}
		if(headlessMode == null) {
			headlessMode = "true";
		}
		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			if (headlessMode.equalsIgnoreCase("true")) {
				options.addArguments("--headless");
			}

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("firefox")) {

			FirefoxOptions options = new FirefoxOptions();
			
			if (headlessMode.equalsIgnoreCase("true")) {
				options.addArguments("--headless");
			}
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(options);
		} else if (browserName.equalsIgnoreCase("edge")) {
			 EdgeOptions edgeOptions = new EdgeOptions();
			 edgeOptions.addArguments("--remote-allow-origins=*");
			 if (headlessMode.equalsIgnoreCase("true")) {
				 edgeOptions.addArguments("--headless");
				}
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(edgeOptions);
		} else {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	/**
	 * Tear down.
	 */
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	/**
	 * Tear down extent.
	 */
	@AfterSuite
	public void tearDownExtent() {
		extent.flush();
	}
}