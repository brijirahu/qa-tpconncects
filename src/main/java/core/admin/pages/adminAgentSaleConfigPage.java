package core.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class adminAgentSaleConfigPage extends basePage{

    WebDriver driver;


    @FindBy(xpath = "//input[@name='data[Sale][name]']")
    public WebElement admin2agentSaleName;

    @FindBy(xpath = ".//*[@id='organisation_id']")
    public WebElement agencyName;

    @FindBy(xpath = ".//*[@for='checkboxhotel']")
    public WebElement hotelCheckbox;

    @FindBy(xpath = ".//*[@for='checkboxflight']")
    public WebElement flightCheckbox;

    @FindBy(xpath = ".//*[@for='checkboxcarhires']")
    public WebElement carCheckbox;

    @FindBy(xpath = ".//*[@for='checkboxtransfers']")
    public  WebElement transferCheckbox;

    @FindBy(xpath = ".//*[@for='checkboxactivity']")
    public WebElement activityCheckbox;

    @FindBy(xpath = ".//*[@for='checkboxinsurance']")
    public WebElement insuranceCheckbox;
    @FindBy(xpath = ".//*[@for='checkboxcruises']")
    public WebElement cruiseCheckbox;

    @FindBy(xpath = ".//*[@id='updateSaleConfigFirst']//*[@name='savecontinue']")
    public WebElement saveBtn;


    public adminAgentSaleConfigPage(WebDriver driver){
    super(driver);

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public void saveAndContinue(){

        hotelCheckbox.click();
        flightCheckbox.click();
        carCheckbox.click();
        activityCheckbox.click();
        transferCheckbox.click();
        clickElement(saveBtn);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='save_markup']")));
        driver.findElement(By.xpath(".//*[@id='save_markup']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='orgrname']")));

    }
}


//}
