package pageobjects;
//import helpers.Log;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import step_definitions.Hooks;
import step_definitions.Reusable_Functions;

import java.io.IOException;

//public class HomePage extends BaseClass{
	public class LazadaLandingPage {
	WebDriver driver = Hooks.driver;

	@FindBy(how=How.XPATH, using="//input[@id='email']")
	public static WebElement Txt_User_Name;


	//****************Place required to change when xpath or property changes



	public static void NavigateLazada(WebDriver driver) throws IOException
	{
		driver.get("https://www.lazada.sg/");
		Reusable_Functions.WaitforElementtoLoad(driver,"//div[@id='anonLogin']");
		driver.manage().window().maximize();


	}


}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	