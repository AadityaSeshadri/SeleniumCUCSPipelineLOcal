package pageobjects;
//import helpers.Log;

import cucumber.api.Scenario;
import helpers.Log;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import step_definitions.Hooks;
import step_definitions.Reusable_Functions;

import java.io.File;
import java.io.IOException;

//public class LoginPage extends BaseClass{

	public class LoginPage {
	WebDriver driver = Hooks.driver;

	@FindBy(how=How.XPATH, using="//input[@id='email']")
	public static WebElement Txt_User_Name;
	
	@FindBy(how=How.XPATH, using="//input[@id='pass']")
	public static WebElement Txt_password;
	
	@FindBy(how=How.XPATH, using="//input[@value='Log In']")
	public static WebElement Btn_signin;

    @FindBy(how=How.ID, using="anonLogin")
    public static WebElement Lnk_LazadaLoginSignIn;

    @FindBy(how=How.XPATH, using="//input[@placeholder='Please enter your Phone Number or Email']")
    public static WebElement Txt_LoginName;

    @FindBy(how=How.XPATH, using="//input[@placeholder='Please enter your password']")
    public static WebElement Txt_LoginPwd;

    @FindBy(how=How.XPATH, using=" //button[@class='mod-button mod-button mod-third-party-login-btn mod-third-party-login-fb']")
    public static WebElement Btn_FBLogin;

    @FindBy(how=How.XPATH, using="//button[@name='__CONFIRM__']")
    public static WebElement Btn_ContinueasPerson;


	//****************Place required to change when xpath or property changes



	public static void Enter_Username(String UName) throws IOException {

		Reusable_Functions.ClearTextBox(Txt_User_Name);
		Reusable_Functions.AddStepLogToReport("Username cleared");
		Reusable_Functions.EnterTextBox(Txt_User_Name,UName);
		Reusable_Functions.AddStepLogToReport("Username entered " + UName);

	}

	public static void Enter_Password(String Password)
	{
		Reusable_Functions.ClearTextBox(Txt_password);
		Reusable_Functions.AddStepLogToReport("Password cleared");
		Reusable_Functions.EnterTextBox(Txt_password,Password);
		Reusable_Functions.AddStepLogToReport("Password Entered XXXXXXXXX");
	}

	public static void Click_Signin()
	{
		Reusable_Functions.ButtonClick(Btn_signin);
		Reusable_Functions.AddStepLogToReport("Sign in Button Clicked");
	}

		public static void LoginLazada(WebDriver driver,String Uname,String Pwd) throws InterruptedException {
		    Reusable_Functions.LinkClick(driver,Lnk_LazadaLoginSignIn);
            Reusable_Functions.AddStepLogToReport("Login Button Clicked");
		    Reusable_Functions.ButtonClick(Btn_FBLogin);
            Reusable_Functions.AddStepLogToReport("Login with Facebook Button Clicked");
		    Reusable_Functions.switchToNewWindow(2);
            Reusable_Functions.AddStepLogToReport("Switched to Child Window");
            Reusable_Functions.WaitforElementtoLoad(driver,"//input[@id='email']");
			Reusable_Functions.EnterTextBox(Txt_User_Name,Uname);
            Reusable_Functions.AddStepLogToReport("User Name Entered:"  +Uname);
            Reusable_Functions.EnterTextBox(Txt_password,Pwd);
            Reusable_Functions.AddStepLogToReport("Password Entered:"   +"$$$$$$$$$$$$");
            Reusable_Functions.ButtonClick(Btn_signin);
            Reusable_Functions.AddStepLogToReport("Sign in Button Clicked");
            Reusable_Functions.switchToNewWindow(1);
            Reusable_Functions.AddStepLogToReport("Switched Back to Parent Window");




		}
	}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
