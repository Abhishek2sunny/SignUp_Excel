/**
 * 
 */
package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author HNAK_Administrator
 *
 */
public class ConfigReader {

	Properties prop;

	public ConfigReader() {

		try {
			File src = new File("./src/com/utility/resources/Config.properties");
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getDriverPath() {
		String path = prop.getProperty("driver_path");
		return path;

	}

	public String getDriverValue() {
		String value = prop.getProperty("driver_value");
		return value;
	}

	public String getURL() {
		return prop.getProperty("url");
	}

	public String homePageTitle() {
		return prop.getProperty("homePageTitle");
	}
	public String signUp() {
		return prop.getProperty("signup_url");
	}

	public String getfullName() {
		return prop.getProperty("signup_fullname");
	}

	public String getmobileNumber() {
		return prop.getProperty("signup_mobilenumber");
	}

	public String getEmail() {
		return prop.getProperty("signup_email");
	}

	public String getPassword() {
		return prop.getProperty("signup_password");
	}

	

	public String signupregisterbutton() {
		return prop.getProperty("signup_button");
	}

}
