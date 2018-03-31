package core.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class basePage {

    WebDriver driver;
    JavascriptExecutor js;

    @FindBy(xpath = ".//*[@id='start_date']")
    public WebElement  startDate;

    @FindBy(xpath = ".//*[@id='end_date']")
    public WebElement endDate;

    @FindBy(css = ".messenger")
    public WebElement errorMessageContainer;

    public basePage(){}

    public basePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }


    public  void typeText(WebElement element, String text){

       // element.clear();
        element.sendKeys(text);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    public void clickElement(WebElement element){

        //waitForElement(element);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        js = (JavascriptExecutor)driver;
//        js.executeScript("arguments[0].click();" , element);
        element.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    public  void waitForElement(WebElement element) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 50);
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public  void waitTillPageLoad(int i) {

        driver.manage().timeouts().pageLoadTimeout(i, TimeUnit.SECONDS);
        //driver.manage().timeouts().setScriptTimeout(i,TimeUnit.SECONDS);

    }

    public void validLoginAdmin(String username, String password){


        driver.findElement(By.xpath("//*[@id='login_username']")).sendKeys(username);
        js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('login_pass').focus();");
        js.executeScript("document.getElementById('login_pass').click();");
        driver.findElement(By.xpath("//*[@id='login_pass']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id='login_sbmt_btn']")).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".username")));

    }

}
