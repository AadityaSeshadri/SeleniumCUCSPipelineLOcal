package step_definitions;

import static org.testng.AssertJUnit.assertEquals;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import helpers.Log;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.HomePage;
import pageobjects.LazadaLandingPage;
import pageobjects.LoginPage;

import java.util.List;
import java.util.Map;
//import helpers.Log;


public class StepDefinitions {
    public WebDriver driver;
    public Scenario scenario;

    public StepDefinitions()
    {
    	driver = Hooks.driver;
    	 scenario = Hooks.scenario;
        PageFactory.initElements(driver, LoginPage.class);
        PageFactory.initElements(driver, HomePage.class);
        PageFactory.initElements(driver, LazadaLandingPage.class);


    }

    @When("^User Logins Facebook with Username \"(.*?)\"  and Password \"(.*?)\"$")
    public void user_Logins_Facebook_with_Username_and_Password(String uname, String pass) throws Throwable {
        System.out.println("Scenario name inside -------------------------" + scenario.getName());
        Reusable_Functions.AddStepLogToReport("Execution Started");

        driver.get("https://www.facebook.com");
        Reusable_Functions.AddStepLogToReport("Navigated to Facebook Website");
        LoginPage.Enter_Username(uname);
        Reusable_Functions.Take_Screenshot(driver,scenario);
        if(pass.equals("XXXXXXXXXXXX"))
        {
            pass = "VelayaParu@541990";
        }
        LoginPage.Enter_Password(pass);
        Reusable_Functions.Take_Screenshot(driver,scenario);

        LoginPage.Click_Signin();
        Reusable_Functions.Take_Screenshot(driver,scenario);



    }

    @Then("^User should be able to view Homepage$")
    public void user_should_be_able_to_view_Homepage() throws Throwable {

        HomePage.check_HomePage(driver);
        Log.info("Checked for Homepage");

    }

    @Given("^Login to Lazada with Facebook$")
    public void User_Login_to_Lazada(DataTable usercredentials) throws Throwable {

        List<Map<String,String>> data = usercredentials.asMaps(String.class,String.class);
        String Password = data.get(0).get("Password");
        if (Password.equals("XXXXXXXX"))
        {
            Password = "VelayaParu@541990";
        }
        System.out.println("*********************Given Background********************");
        LazadaLandingPage.NavigateLazada(driver);
        Reusable_Functions.Take_Screenshot(driver,scenario);
        Reusable_Functions.AddStepLogToReport("User Navigated to Lazada");
        LoginPage.LoginLazada(driver,data.get(0).get("Username"),Password);
        HomePage.ValidateLazadaHomePage(driver);
        Reusable_Functions.Take_Screenshot(driver,scenario);
        System.out.println("**************End of Given******************");

    }




    @When("^Search for Product with Below Specs$")
    public void search_for_Product_with_Below_Specs(DataTable ProductList) throws Throwable {
        List<Map<String,String>> data = ProductList.asMaps(String.class,String.class);
        HomePage.SelectProducts(driver,data.get(0).get("Product"),data.get(0).get("Brand"),data.get(0).get("Rating"),data.get(0).get("Color"),data.get(0).get("Service"));
        Reusable_Functions.Take_Screenshot(driver,scenario);
    }

    @When("^Validate Info of First Product in List$")
    public void ValidateProductINfo(DataTable ProductINfo) throws Throwable {
        List<Map<String,String>> data = ProductINfo.asMaps(String.class,String.class);
        HomePage.ValidateProductInfo(driver,data.get(0).get("Name"),data.get(0).get("Price"));
        Reusable_Functions.Take_Screenshot(driver,scenario);
    }

    @Then("^Add Products into Cart$")
    public void add_Products_into_Cart() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        HomePage.AddtoCart(driver);
        Reusable_Functions.Take_Screenshot(driver,scenario);
    }

    @When("^Clicked on Cart$")
    public void clicked_on_Cart() throws Throwable {
        HomePage.ClickCart(driver);

    }

    @Then("^Validate Products in cart$")
    public void validate_added_product_existence_into_Cart(DataTable ProductINfo) throws Throwable {
        List<Map<String,String>> data = ProductINfo.asMaps(String.class,String.class);
        HomePage.ValidateCart(driver,data.get(0).get("Name"),data.get(0).get("Price"));
        Reusable_Functions.Take_Screenshot(driver,scenario);
    }

    @And("^Delete Product in Cart$")
    public void DeleteCart() throws Throwable {

        HomePage.DeleteCart(driver);
        Reusable_Functions.Take_Screenshot(driver,scenario);
    }

}