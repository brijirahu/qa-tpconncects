package core.admin.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class adminHomePage extends basePage {

    WebDriver driver;
    Logger logger = Logger.getLogger(adminHomePage.class);

    @FindBy(css = "#BookingsTripId")
    public WebElement bookingTripId;

    @FindBy(xpath = "//span[contains(.,'Create New Agent')]")
    public WebElement createNewAgentLink;

    @FindBy(xpath = "//a[contains(.,'Add Agent')]")
    public WebElement addAgentLink;

    @FindBy(xpath = ".//*[@id='search_hotel']//*[@class='btn btn-info']")
    public WebElement bookingSearchButton;

    @FindBy(css = ".header-quick-nav .text-right .username")
    public WebElement welcomeMsg;

    @FindBy(xpath = "//a[@href='/users/logout']")
    public WebElement logoutLink;

    @FindBy(xpath = "div.tiles>.tiles-body")
    public WebElement bookingInfoTiles;

    public adminHomePage(WebDriver driver){
        super(driver);

        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void custClicksCreateNewAgent(){

        clickElement(createNewAgentLink);
        waitForElement(addAgentLink);
        clickElement(addAgentLink);
        waitTillPageLoad(10);
        waitForElement(driver.findElement(By.id("agent_name")));

    }






}
