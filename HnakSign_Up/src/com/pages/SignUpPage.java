/**
 * 
 */
package com.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.utility.ConfigReader;

/**
 * @author HNAK_Administrator
 *
 */
public class SignUpPage {

	ConfigReader conf = new ConfigReader();

	WebDriver driver;

	public SignUpPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	public void openURL() {

		try {
			driver.get(conf.getURL());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void homePageTitleVerification() {
		try {
			Assert.assertEquals(driver.getTitle(), conf.homePageTitle());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
		public void clickSIGNUP() {

			try {
				driver.get(conf.signUp());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void fullNameField() {
			try {
				driver.get(conf.getfullName());
			}catch(Exception e) {
				//TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void mobileNumberField() {
			try {
				driver.get(conf.getmobileNumber());
			}catch(Exception e) {
				//TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void emailField() {
			try {
				driver.get(conf.getEmail());
			}catch(Exception e) {
				//TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void passwordField() {
			try {
				driver.get(conf.getPassword());
			}catch(Exception e) {
				//TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}



