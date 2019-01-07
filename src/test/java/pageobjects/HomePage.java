package pageobjects;
//import helpers.Log;

import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;
import cucumber.api.Scenario;
import helpers.Log;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import step_definitions.Hooks;
import step_definitions.Reusable_Functions;

import javax.naming.Reference;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

//public class HomePage extends BaseClass{
	public class HomePage {

	WebDriver driver = Hooks.driver;

	/*public HomePage(WebDriver driver){
		super(driver);
	}*/

	//****************Place required to change when xpath or property changes
	@FindBy(how=How.XPATH, using="//a[@class='_2s25']")
	public static WebElement Lnk_Home;


	@FindBy(how=How.XPATH, using="//input[@placeholder='Search in Lazada']")
	public static WebElement Txt_SearchProduct;

	@FindBy(how=How.XPATH, using="//button[contains(text(),'SEARCH')]")
	public static WebElement Btn_Search;






	//****************Place required to change when xpath or property changes


	public static void check_HomePage()
	{
		Assert.assertTrue(Lnk_Home.isDisplayed());
		Reusable_Functions.AddStepLogToReport("Home Page Displayed");

	}


	public static void ValidateLazadaHomePage(WebDriver driver) throws InterruptedException {
		Assert.assertTrue(Txt_SearchProduct.isDisplayed());
		Thread.sleep(7000);
		//Reusable_Functions.WaitforElementtoLoad(driver,"//h3[contains(text(),'Lazada Southeast Asia')]");
		//Assert.assertTrue(driver.findElements(By.xpath("//span[contains(text(),'Black')]")).get(1).isDisplayed());

	}

	public static void SelectProducts(WebDriver driver,String product, String brand, String rating, String color, String service) throws InterruptedException {
		Reusable_Functions.EnterTextBox(Txt_SearchProduct,product);
		Reusable_Functions.ButtonClick(Btn_Search);
		String ProductXpath = "//span[contains(text(),'"+brand+"')]//preceding::span[@class='ant-checkbox']";
		String ServiceXpath = "//div[contains(text(),'Service')]//parent::div//span[contains(text(),'"+service+"')]";
		String ColorXpath = "//div[contains(text(),'Color')]//following-sibling::div//span[contains(text(),'"+color+"')]";

		Reusable_Functions.WaitforElementtoLoad(driver,ProductXpath);
		//System.out.println("%%%%%%%%%%%%%%%%%%%%%ProductXpath"+ProductXpath+"%%%%%%%%%%%%%%%%%%%%");
		Reusable_Functions.CheckBoxClick(driver,ProductXpath);
		Reusable_Functions.WaitforElementtoLoad(driver,"//span[contains(text(),'Filtered By')]//following-sibling::div/span[contains(text(),'Brand: ')]");
		//Reusable_Functions.WaitforElementtoLoad(driver,"//div[@class='ant-tag']/span[contains(text(),'"+brand+"')]");

		Reusable_Functions.CheckBoxClick(driver,ServiceXpath);
		Reusable_Functions.WaitforElementtoLoad(driver,"//div[@class='ant-tag']/span[contains(text(),'"+service+"')]");

		Reusable_Functions.CheckBoxClick(driver,ColorXpath);
		Reusable_Functions.WaitforElementtoLoad(driver,"//div[@class='ant-tag']/span[contains(text(),'"+color+"')]");

		if (rating.equals("5"))
		{
			Reusable_Functions.LinkClick(driver,driver.findElements(By.xpath("//div[contains(text(),'Rating')]//following-sibling::div/div")).get(0));
		}
		else if (rating.equals("4"))
		{
			Reusable_Functions.LinkClick(driver,driver.findElements(By.xpath("//div[contains(text(),'Rating')]//following-sibling::div/div")).get(1));
		}
		else if(rating.equals("3"))
		{
			Reusable_Functions.LinkClick(driver,driver.findElements(By.xpath("//div[contains(text(),'Rating')]//following-sibling::div/div")).get(2));
		}
		else if (rating.equals("2"))
		{
			Reusable_Functions.LinkClick(driver,driver.findElements(By.xpath("//div[contains(text(),'Rating')]//following-sibling::div/div")).get(3));
		}
		else if(rating.equals("1"))
		{
			Reusable_Functions.LinkClick(driver,driver.findElements(By.xpath("//div[contains(text(),'Rating')]//following-sibling::div/div")).get(4));
		}


		Thread.sleep(3000000);

		/*Reusable_Functions.CheckBoxClick(driver,ColorXpath);
		Reusable_Functions.WaitforElementtoLoad(driver,"//div[@class='ant-tag']/span[contains(text(),'"+color+"')]");*/


		//Reusable_Functions.CheckBoxClick(driver,ProductXpath);
		//Thread.sleep(10000);


	}
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	