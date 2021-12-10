/**
 * 
 */
package com.test;

import java.io.File;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import com.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.pages.SignUpPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utility.ConfigReader;
import com.utility.WindowHandle;


/**
 * @author HNAK_Administrator
 *
 */
public class SignUpTest {
	
	ExtentReports extent;
	ExtentTest logger;

	ConfigReader conf;
	WebDriver driver;
	SignUpPage sp;
	WindowHandle wh;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HNAK_Administrator\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		sp = new SignUpPage(driver);
		wh = new WindowHandle(driver);
		conf = new ConfigReader();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(4000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

	}

	@BeforeTest
	public void reportInitiation() {

		
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/SignUpExtentReport.html", true);
		extent.loadConfig(new File("./src/resources/extent-config.xml"));
	}

	@Test(testName = "OpenHomePage URL")
	public void openPage() {
		System.out.println("openPage");
		logger = extent.startTest("openPage", "Verify the URL").assignCategory("Functional");

		sp.openURL();
		logger.log(LogStatus.INFO, "URL Opens");
		logger.log(LogStatus.PASS, "URL Open Successful");
	}

	
	@Test(dependsOnMethods = "openPage", testName = "Verify the Home Page Title")
	public void verifyTitle() {
		System.out.println("verify title");
		logger = extent.startTest("verifyTitle", "Verify the Home Page Title").assignCategory("Functional");

		sp.homePageTitleVerification();

		logger.log(LogStatus.PASS, "Home Page Title verified");
	}
	
	@Test(dependsOnMethods = "verifyTitle", testName = "Click on SIGNUP")
	public void signup() throws Exception {
	//	System.out.println("signup");
		logger = extent.startTest("signup", "Click on Signup").assignCategory("Functional");
		for(SignUpUser signUpUser: SignUpExcel.getSignUpUser()) {
			sp.clickSIGNUP();
			driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);

		
			logger.log(LogStatus.INFO, "SIGNUP Opens");
			logger.log(LogStatus.PASS, "Signup successful");


			driver.findElement(By.xpath(conf.getfullName())).clear();
			driver.findElement(By.xpath(conf.getfullName())).sendKeys(signUpUser.getFullName());

			driver.findElement(By.xpath(conf.getEmail())).clear();
			driver.findElement(By.xpath(conf.getEmail())).sendKeys(signUpUser.getEmail());

			driver.findElement(By.xpath(conf.getmobileNumber())).clear();
			driver.findElement(By.xpath(conf.getmobileNumber())).sendKeys(signUpUser.getMobileNumber());

			driver.findElement(By.xpath(conf.getPassword())).clear();
			driver.findElement(By.xpath(conf.getPassword())).sendKeys(signUpUser.getPassword().toString());

			driver.findElement(By.xpath(conf.signupregisterbutton())).click();

			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}



	@AfterMethod
	public Iterator<Object[]> tearDown(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) {
			Utility.captureScrenshot(driver, result.getName());
		} else {
			logger.log(LogStatus.ERROR, "Dependant test caese(s) will be skipped if any..! ");
			logger.log(LogStatus.FAIL, result.getThrowable());
			Utility.captureScrenshot(driver, result.getName() + "_failed");
		}
		extent.endTest(logger);
		extent.flush();
		return null;
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("driver close");

		driver.quit();
		extent.close();
	}

}
