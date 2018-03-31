package core.admin.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class adminHomePage extends basePage {

    WebDriver driver;
    Logger logger = Logger.getLogger(adminHomePage.class);

    @FindBy(css = "#BookingsTripId")
    public WebElement bookingTripId;

//    @FindBy(css = "//span[contains(.,'Create New Agent')]")
    @FindBy(css = "#main-menu-wrapper>ul>li:nth-child(2)")
    public WebElement createNewAgentLink;

    @FindBy(xpath = ".//a[contains(.,'Add Agent')]")
    public WebElement addAgentLink;

    @FindBy(xpath = "//*[@id='search_hotel']//*[@class='btn btn-info']")
    public WebElement bookingSearchButton;

    @FindBy(css = ".header-quick-nav .text-right .username")
    public WebElement welcomeMsg;

    @FindBy(xpath = ".//a[@href='/users/logout']")
    public WebElement logoutLink;

    @FindBy(css = "div.tiles>.tiles-body")
    public WebElement bookingInfoTiles;

    @FindBy(xpath = ".//*[contains(text(),'Sales Configuration')]")
    public WebElement saleConfigurationLink;

    @FindBy(xpath = ".//*[@href = '/admin/sales']")
    public WebElement saleConfigLink;

    @FindBy(xpath = ".//*[@href = '/admin/markups']")
    public WebElement markupRulesLink;

    public adminHomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
        this.driver = driver;
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public void custClicksCreateNewAgent(){

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", addAgentLink);
        waitTillPageLoad(30);

        waitForElement(driver.findElement(By.id("agent_name")));

    }

    public void custClicksSaleConfigLink(){

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", saleConfigurationLink);
        waitTillPageLoad(30);
        js.executeScript("arguments[0].click();", saleConfigLink);

        waitForElement(driver.findElement(By.xpath(".//*[contains(@class,'btn-warning')]")));

    }






}
