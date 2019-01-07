package step_definitions;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Reusable_Functions {

    public static HashMap<String, String> hashMap = new HashMap<String, String>();


    public static void Set_PreRequisites(Scenario scenario) throws IOException {
        FileUtils.deleteDirectory(new File(System.getProperty("user.dir")+"//log"));
        FileUtils.forceMkdir(new File(System.getProperty("user.dir")+"//log"));
        FileUtils.deleteDirectory(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshots\\"));
        FileUtils.forceMkdir(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshots"));
        FileUtils.forceMkdir(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshots\\"+scenario.getName()));
        PropertyConfigurator.configure("log4j.properties");


    }


    public static void getData(String ScenarioName) throws IOException {
        InputStream ExcelFileToRead = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/testData/SampleData.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);

        XSSFWorkbook test = new XSSFWorkbook();

        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row;
        XSSFCell cell;


        //System.out.println("AAA+++++++++++++++" + sheet.getRow(0).getCell(0).getStringCellValue());
        int row_count = sheet.getLastRowNum();
       // System.out.println("row_Count" + row_count);

        for (int i = 0; i < row_count; i++) {
            if (sheet.getRow(i).getCell(0).getStringCellValue().contentEquals(ScenarioName)) {
                for (int j = 1; j < sheet.getRow(i).getLastCellNum(); j++) {
                    hashMap.put(sheet.getRow(0).getCell(j).getStringCellValue(), sheet.getRow(i).getCell(j).getStringCellValue());

                }
            }
            //System.out.println("*******************");
        }


    }
    public static void AddStepLogToReport(String message)
    {
        com.cucumber.listener.Reporter.addStepLog(message);
    }

    public static void AddScenarioLogToReport(String message)
    {
        com.cucumber.listener.Reporter.addScenarioLog(message);
    }

    public static  void ClearTextBox(WebElement element)
    {
        element.clear();
    }

    public static  void EnterTextBox(WebElement element,String Text)
    {
        element.sendKeys(Text);
    }

    public static void ButtonClick(WebElement element) {
        element.click();
    }
    public static void Take_Screenshot(WebDriver driver, Scenario scenario)
    {
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
    }

    public static void WaitforElementtoLoad(WebDriver driver,String Xpath) {

        WebDriverWait wait = new WebDriverWait(driver,25);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpath)));


    }

    public static void LinkClick(WebDriver driver,WebElement element) {

        Actions ob = new Actions(driver);
        ob.moveToElement(element);
        ob.click(element);
        Action action  = ob.build();
        action.perform();


    }

    public static void switchToNewWindow(int windowNumber) {
        int windowCount = 0;
        WebDriver driver = Hooks.driver;
        Set< String > s = driver.getWindowHandles();
        Iterator< String > ite = s.iterator();
        int i = 1;
        while (ite.hasNext() && i < 10) {
            String popupHandle = ite.next().toString();
            driver.switchTo().window(popupHandle);
            System.out.println("Window title is : "+driver.getTitle());
            if (i == windowCount) break;
            i++;
        }
    }

    public static void CheckBoxClick(WebDriver driver,String Xpathofelement) {
        /*Actions ob = new Actions(driver);
        ob.moveToElement(.xpath(Xpathofelement));
        ob.click( driver.findElement(By.xpath(Xpathofelement)));
        Action action  = ob.build();
        action.perform();*/
        //driver.findElement(By.xpath(Xpathofelement)).click();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(Xpathofelement)));
    }
}
