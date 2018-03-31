package core.admin.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class adminCarBlockPage extends adminSearchCarPage {

    WebDriver driver;

    @FindBy(xpath = ".//*[@id='collapseFour1']/div/div[2]/table")
    public WebElement carDetailsTable;

    @FindBy(xpath = "//input[@ng-model='occupancy.first_name']")
    public WebElement firstNameField;

    @FindBy(xpath = "//input[@ng-model='occupancy.last_name']")
    public WebElement lastNameField;

    @FindAll({@FindBy(xpath = ".//*[@id='CarsBookController']/form//table[contains(@ng-repeat, 'cancellationPolicies.cancellationPolicy')]")})
    public List<WebElement> cancellationPolicy;

    @FindBy(xpath = "//input[@ng-init='shopping.agent_reference']")
    public WebElement agentRef;

    @FindBy(xpath = ".//*[@id='CarsBookController']/form//h4[contains( . , 'Total Amount')]")
    public WebElement totalAmount;

    @FindBy(xpath = ".//*[@id='purchase']")
    public WebElement confirmButton;

    @FindBy(xpath = ".//td[last()]/span")
    public WebElement statusColumn;

    @FindBy(xpath = ".//span[contains( . ,'Trip ID:')]")
    public WebElement tripId;

    @FindBy(xpath = ".//*[contains(@class ,'tp_tableborder')]/td[1]")
    public WebElement carNameDateColumn;



    public adminCarBlockPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyCarBlockPage(){
        Assert.assertTrue("car booking details does not have VAT details",carDetailsTable.findElement(By.xpath(".//*[@id='collapseFour1']//table//td[contains(.,'Total Amount (VAT Inclusive)')]")).isDisplayed());
        Assert.assertTrue("firstname field not displayed", firstNameField.isDisplayed());
        Assert.assertTrue("lastname field not displayed" , lastNameField.isDisplayed());
        Assert.assertTrue("agent reference field not displayed", agentRef.isDisplayed());
        Assert.assertTrue("total amount with VAT text is not displayed",totalAmount.getText().contains("Total Amount (VAT Inclusive)"));
        Assert.assertTrue("",confirmButton.isDisplayed());
    }

    public void clickConfirmCar(){
        firstNameField.sendKeys("fName");
        lastNameField.sendKeys("test");
        agentRef.sendKeys("test");
        confirmButton.click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@class , 'invoice-body')]")));

    }



}
