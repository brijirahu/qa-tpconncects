package core.admin.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class adminAddNewSalePage extends adminSaleConfigPage {

    WebDriver driver;
    String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @FindBy(xpath = ".//*[@id='name']")
    public WebElement saleNameField;

    @FindBy(xpath = ".//*[@id='s2id_multi']/ul")
    public WebElement agentField;

    @FindBy(xpath = ".//*[@id='select2-drop']/ul/li[contains( . , 'Testers')]")
    public WebElement agentSelectDropDown;

    @FindBy(xpath = ".//*[@id='status']")
    public WebElement saleStatus;

    @FindBy(xpath = ".//label[@for = 'checkboxhotel']")
    public WebElement hotelChkBox;

    @FindBy(xpath = ".//label[@for = 'checkboxflight']")
    public WebElement flightChkBox;

    @FindBy(xpath = ".//label[@for = 'checkboxcarhires']")
    public WebElement carChkBox;

    @FindBy(xpath = ".//label[@for = 'checkboxtransfers']")
    public WebElement transfersChkBox;

    @FindBy(xpath = ".//label[@for = 'checkboxactivity']")
    public WebElement activityChkBox;

    @FindBy(xpath = ".//label[@for = 'checkboxinsurance']")
    public WebElement insuranceChkBox;

    @FindBy(xpath = ".//label[@for = 'checkboxcruises']")
    public WebElement cruisesChkBox;

    @FindBy(xpath = ".//*[@id='savecontinue']")
    public WebElement saveAndApplyMarkupBtn;

    @FindBy(xpath = ".//*[@id='create_new_shopping']/div[4]/button[1]")
    public WebElement saveUpdateBtn;


    public adminAddNewSalePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void verifyErrorMsg(){

        clickElement(saveAndApplyMarkupBtn);
        Assert.assertFalse("sale created without sale name", driver.findElement(By.xpath(".//*[@id='sale_id']")).isDisplayed());
    }

    public void validDataCreateSaleAgent(){

        typeText(saleNameField, randomSaleUserName()+ "testSale" );
        clickElement(agentField);
        waitForElement(agentSelectDropDown);
        clickElement(agentSelectDropDown);
        clickElement(hotelChkBox);
        clickElement(flightChkBox);
        clickElement(carChkBox);
        clickElement(transfersChkBox);
        clickElement(activityChkBox);
        clickElement(insuranceChkBox);
        clickElement(saveAndApplyMarkupBtn);
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='sale_id']")));
        driver.getCurrentUrl().contains("/markups/add/");

    }



    public String randomSaleUserName(){

        Random rd = new Random();
        StringBuilder sb = new StringBuilder();
        while(sb.length() < 6){

            int index = (int) (rd.nextFloat() * AB.length());
            sb.append(AB.charAt(index));
        }
        String str = sb.toString();
        return str;

    }


}
