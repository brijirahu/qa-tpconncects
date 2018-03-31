package core.admin.tests;

import core.admin.pages.adminLoginPage;
import core.admin.utility.Listeners.TestListeners;
import core.admin.utility.commonMethods;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class initTest {

     public static WebDriver driver;

     public static final String testDataExcelFileName = "TestData.xlsx";
    public final Logger logger = Logger.getLogger("logger");
    core.admin.utility.commonMethods commonMethods = new commonMethods();
    adminLoginPage adminLoginPage;
    Properties prop;

    String url = "http://admin.tpconnects.net";

    @Parameters("browser")
    @BeforeSuite
    public void initSetup(String browser) {
        initDriver(browser);

    }
    @BeforeTest
    public void initUrl(){
        openUrl(url);
        logger.info("**** Inside adminLoginPageTest beforeTest *****");
        logger.info(getDriver().getWindowHandle());
        adminLoginPage = new adminLoginPage(getDriver());
    }


    public void initDriver(String browser){

        if(browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "E:\\\\geckodriver-v0.19.1-win64\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();


        }
        else if(browser.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\Tower-7050-2\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        }

    }

    public WebDriver getDriver(){

        return this.driver;
    }

    @Step("Open url step ...")
    public void openUrl(String url){
        getDriver().get(url);
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void quitDriver(){
        driver.quit();
    }

    @AfterSuite
    public void closeDriver(){
        quitDriver();

    }

    public void change() {

String dt = "abc, fdgf,gfg, AD";

String [] a = dt.split(",");

String st = a[0] + a[a.length-1];


    }


}
