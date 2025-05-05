package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


import automationCore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	
	@Test
	public void verifyUserLoginWithValidCredentials() throws IOException {
		String username=ExcelUtility.getStringData(0, 0, "Loginpage");
		String password=ExcelUtility.getStringData(0, 1,"Loginpage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickONLoginButon();
		boolean isdashboarddisplayed=login.dashboardDisplayed();
		Assert.assertTrue(isdashboarddisplayed, "User was unable to login successfully");
		
		
	}
		
		
		
	@Test
	public void verifyUserLoginWithInvalidUsernameAndValidPassword() throws IOException {
		String username=ExcelUtility.getStringData(1, 0, "Loginpage");
		String password=ExcelUtility.getStringData(1, 1,"Loginpage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickONLoginButon();
		String actual=login.getpagetitle();
		String expected="7rmart supermarket";
		Assert.assertEquals(actual, expected, "User was able to login with invalid username");
		
		
	}
	@Test
	public void verifyUserLoginWithValidUserNameAndInvalidPassword() throws IOException {
		String username=ExcelUtility.getStringData(2, 0, "Loginpage");
		String password=ExcelUtility.getStringData(2, 1,"Loginpage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickONLoginButon();
		
	}
	@Test
	public void verifyUserLoginWithInvalidUsernameAndInvalidPassword() throws IOException {
		
		String username=ExcelUtility.getStringData(3, 0, "Login page");
		String password=ExcelUtility.getStringData(3, 1,"Login page");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickONLoginButon();
	}
	
}



