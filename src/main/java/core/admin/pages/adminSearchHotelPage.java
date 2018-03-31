package core.admin.pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class adminSearchHotelPage extends adminSearchPage{

    WebDriver driver;
    adminSearchPage adminSearchPage;
    JavascriptExecutor js;

    @FindBy(xpath = ".//*[@id='s2id_country_id']/a")
    public WebElement countrySelect;

    @FindBy(xpath = ".//*[@id='select2-drop']/div")
    public WebElement selectInputField;

    @FindBy(xpath = ".//*[@id='destination']")
    public WebElement destination;

    @FindBy(xpath = ".//*[@id='nights']")
    public WebElement nightCount;

    @FindBy(xpath = ".//*[@id='s2id_nationality']/a" )
    public WebElement nationalitySelect;

    @FindBy(xpath = ".//*[@id='s2id_resident']/a")
    public WebElement residentSelect;

    @FindBy(xpath = ".//input[@name='markupvalue']")
    public WebElement markupInputField;

    @FindBy(xpath = ".//div[contains(. , 'Markup By')]/../select")
    public WebElement markupType;

    @FindBy(xpath = ".//*[@id='room']")
    public WebElement hotelRoomSelection;

    @FindBy(xpath = ".//*[@id='room_1_adult']")
    public WebElement room1Adult;

    @FindBy(xpath = ".//*[@id='room_1_child']")
    public WebElement room1Child;

    @FindBy(xpath = ".//*[@class = 'strRtngwrp']")
    public WebElement starRating;

    @FindBy(xpath = ".//*[@id='package_name']")
    public WebElement hotelName;

    @FindBy(xpath = ".//*[@id='s2id_adminOrganisationid']/a")
    public WebElement behalfOfBooking;

    @FindBy(xpath = "//*[@id = 'hotel_search_panel']//button")
    public WebElement hotelSearchButton;



    public adminSearchHotelPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver , this);
        this.driver = driver;
        js = (JavascriptExecutor)driver;
        //adminSearchPage = new adminSearchPage(driver);
    }

    public void openHotelSearchPage(){


        js.executeScript("arguments[0].click()", searchLink);
        js.executeScript("arguments[0].click()", hotelSearchlink);
        new WebDriverWait(driver, 50).until(ExpectedConditions.urlContains("Hotels/search"));
        Assert.assertTrue("Cars search page is not opened", driver.getCurrentUrl().contains("Hotels/search"));
    }

    public void errorMsgForBlankField(){

        waitForElement(destination);
        js.executeScript("arguments[0].click()", hotelSearchButton);
//        clickElement(hotelSearchButton);
        new WebDriverWait(driver , 30).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".messenger")));
        Assert.assertTrue("error message is not proper" , errorMessageContainer.getText().contains("destination") || errorMessageContainer.getText().contains("checkin"));
    }

    public void invalidSearchCriteria(){


        clickElement(countrySelect);
        selectInputField.sendKeys("united" + Keys.TAB);
        typeText(destination , "qwee");
        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='start_date']")));
        clickElement(startDate);
        selectDate(startDate, 2);

        clickElement(endDate);
        selectDate(endDate, 5);

        clickElement(hotelSearchButton);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("messenger")));
        errorMessageContainer.getText().contains("Hotels Not Available");

    }

}
