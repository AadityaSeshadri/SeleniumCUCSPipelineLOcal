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

	@FindBy(how=How.XPATH, using="//span[contains(text(),'Add to Cart')]")
	public static WebElement Btn_AddToCart;

	@FindBy(how=How.XPATH, using="//span[@class='cart-icon']")
	public static WebElement Btn_HomepageCart;





	//****************Place required to change when xpath or property changes


	public static void check_HomePage(WebDriver driver)
	{

		Reusable_Functions.WaitforElementtoLoad(driver,"//a[@class='_2s25']");
		Assert.assertTrue(Lnk_Home.isDisplayed());
		Reusable_Functions.AddStepLogToReport("Home Page Displayed");

	}


	public static void ValidateLazadaHomePage(WebDriver driver) throws InterruptedException {
		Assert.assertTrue(Txt_SearchProduct.isDisplayed());
		Thread.sleep(5000);
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
		Reusable_Functions.AddStepLogToReport("Product Selected is " + product );
		Reusable_Functions.WaitforElementtoLoad(driver,"//span[contains(text(),'Filtered By')]//following-sibling::div/span[contains(text(),'Brand: ')]");
		//Reusable_Functions.WaitforElementtoLoad(driver,"//div[@class='ant-tag']/span[contains(text(),'"+brand+"')]");
		//driver.navigate().refresh();

		Reusable_Functions.CheckBoxClick(driver,ServiceXpath);
		Reusable_Functions.WaitforElementtoLoad(driver,"//div[@class='ant-tag']/span[contains(text(),'"+service+"')]");
		Reusable_Functions.AddStepLogToReport("Service Selected is " + service );
		//driver.navigate().refresh();

		Reusable_Functions.CheckBoxClick(driver,ColorXpath);
		Reusable_Functions.WaitforElementtoLoad(driver,"//div[@class='ant-tag']/span[contains(text(),'"+color+"')]");
		Reusable_Functions.AddStepLogToReport("color Selected is " + color );
		Thread.sleep(3000);
		driver.navigate().refresh();

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
		Reusable_Functions.AddStepLogToReport("rating Selected is " + rating );
	}

	public static void ValidateProductInfo(WebDriver driver, String Name, String Price)
	{
		Reusable_Functions.WaitforElementtoLoad(driver,"//div[@data-qa-locator='general-products']");
		driver.navigate().refresh();
		Reusable_Functions.LinkClick(driver,driver.findElement(By.xpath("//div[@data-qa-locator='general-products']/div[@data-item-id='272640233']//a[contains(text(),'Logitech G Pro HERO Wireless Mouse + Powerplay wireless charger')]")));
		Reusable_Functions.WaitforElementtoLoad(driver,"//div[@id='module_product_title_1']");
		String Act_Price = driver.findElement(By.xpath("//span[@class=' pdp-price pdp-price_type_normal pdp-price_color_orange pdp-price_size_xl']")).getText();
		Assert.assertTrue(Act_Price.contains(Price));
		//Reusable_Functions.AddStepLogToReport("Expected Price is  " + Price + "Actual Price  is " + Act_Price );




	}

	public static void AddtoCart(WebDriver driver) {
		Reusable_Functions.ButtonClick(Btn_AddToCart);
		Reusable_Functions.switchToNewWindow(2);
		Reusable_Functions.WaitforElementtoLoad(driver,"//span[contains(text(),'1 new item(s) have been added to your cart')]");
	}

	public static void ClickCart(WebDriver driver) {
		Reusable_Functions.LinkClick(driver,Btn_HomepageCart);
		Reusable_Functions.WaitforElementtoLoad(driver,"//a[contains(text(),'Logitech G Pro HERO Wireless Mouse')]");
		Reusable_Functions.AddStepLogToReport("Clicked on Cart" );


	}

	public static void ValidateCart(WebDriver driver, String name, String price) {
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Logitech G Pro HERO Wireless Mouse')]")).getText().contains(name));
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='current-price']")).getText().contains(price));
		Reusable_Functions.AddStepLogToReport(" Actual Product Name " +  driver.findElement(By.xpath("//a[contains(text(),'Logitech G Pro HERO Wireless Mouse')]")).getText());
		Reusable_Functions.AddStepLogToReport(" Actual Product Price " +  driver.findElement(By.xpath("//p[@class='current-price']")).getText());
	}

	public static void DeleteCart(WebDriver driver) {
		driver.findElement(By.xpath("//span[contains(text(),'Delete')]")).click();
		Reusable_Functions.WaitforElementtoLoad(driver,"//div[contains(text(),'Are you sure you want to delete these item(s)')]");
		driver.findElement(By.xpath("//button[contains(text(),'REMOVE')]")).click();
		Reusable_Functions.WaitforElementtoLoad(driver,"//div[contains(text(),'Your cart is empty')]");
	}
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	