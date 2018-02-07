package core.admin.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class initTest {

     public static WebDriver driver;
    //String url = "http://admin.tpconnects.net";

    public void initDriver(String browser){

        if(browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "E:\\\\geckodriver-v0.19.1-win64\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        }
        else if(browser.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\Tower-7050-2\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        }

    }

    public WebDriver getDriver(){

        return this.driver;
    }

    public void openUrl(String url){
        getDriver().get(url);
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    public void quitDriver(){
        driver.quit();
    }

}
