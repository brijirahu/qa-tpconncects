package core.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class adminSaleConfigPage extends basePage{

    WebDriver driver;
    JavascriptExecutor js;

    @FindBy(xpath = ".//*[contains(@class,'btn-warning')]")
    public WebElement addNewSalesBtn;

    @FindBy(xpath = ".//*[@href = '/admin/sales/add']")
    public WebElement agentsAddNewSaleLink;

    @FindBy(xpath = ".//*[@href = '/sales/corporatesales']")
    public WebElement corporateAddNewSaleLink;

    @FindBy(xpath = "//input[@id='keyword']")
    public WebElement nameOrganisationField;


    public adminSaleConfigPage(WebDriver driver){
     super(driver);

     PageFactory.initElements(driver, this);
     this.driver = driver;
      js = (JavascriptExecutor)driver;
    }


    public void userClickAddNewAgentSale(){

        js.executeScript("arguments[0].click();", addNewSalesBtn);
        waitTillPageLoad(10);
        clickElement(agentsAddNewSaleLink);
        waitTillPageLoad(20);
        waitForElement(driver.findElement(By.xpath(".//*[@id='name']")));

    }



}
