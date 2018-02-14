package core.admin.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class basePage {

    static WebDriver driver;

    public basePage(){}

    public basePage(WebDriver driver){
        this.driver = driver;

    }


    public static void typeText(WebElement element, String text){

        element.clear();
        element.sendKeys(text);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    public static void clickElement(WebElement element){

        waitForElement(element);
        element.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    public static void waitForElement(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitTillPageLoad(int i) {

        driver.manage().timeouts().pageLoadTimeout(i, TimeUnit.SECONDS);

    }

}
