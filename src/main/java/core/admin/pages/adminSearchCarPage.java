package core.admin.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class adminSearchCarPage extends adminSearchPage{

    WebDriver driver;
    String url = "http://admin.tpconnects.net/Cars/search";
    adminSearchPage adminSearchPage;

    @FindBy(xpath = ".//*[@id='pickup']")
    public WebElement pickupField;

    @FindBy( xpath = ".//*[@id='dropoff']")
    public WebElement dropOff;

    @FindBy(xpath = ".//*[@id='start_time']")
    public WebElement startTime;

    @FindBy(xpath = ".//*[@id='end_time']")
    public WebElement endTime;

    @FindBy(xpath = ".//*[@id='adult']")
    public WebElement markupInput;

    @FindBy(xpath = ".//div[contains(. , 'Markup By')]/../select")
    public WebElement markupType;

    @FindBy(xpath = ".//*[@id='s2id_adminOrganisationid']/a")
    public WebElement behalfOfBooking;

    @FindBy(css = "button[ng-click=\"cars.makeSearch()\"]")
    public WebElement carSearchButton;

    @FindBy(xpath = ".//*[@id = 'search_hotel_result']")
    public WebElement carSearchResult;

    @FindBy(xpath = "(.//*[@id='hotel-result']/div//button)[1]")
    public WebElement showDetailsBtn1;

    @FindBy(xpath = "(.//*[@id='hotel-result']//*[@class = 'activity_image'])[1]")
    public WebElement carImage1;

    @FindBy(xpath = "(.//*[@id='hotel-result']/div/div[1]/div/div[2])[1]")
    public WebElement carDescription1;

    @FindBy(xpath = "(.//*[@id='hotel-result']//div[contains(@class , 'pr0')])[1]")
    public WebElement carPriceDetails1;

    @FindBy(xpath = ".//*[@id='accordion']//button[@ng-click = 'cars.blockCars(item,program)']")
    public WebElement carBookButton1;



    public adminSearchCarPage(WebDriver driver){
        super(driver);

        PageFactory.initElements(driver , this);
        this.driver = driver;
        adminSearchPage = new adminSearchPage(driver);

}

    public void verifyCarSearchElements(){

        pickupField.isDisplayed();
        dropOff.isDisplayed();
        startDate.isDisplayed();
        startTime.isDisplayed();
        endDate.isDisplayed();
        endTime.isDisplayed();
        markupInput.isDisplayed();
        markupType.isDisplayed();
        behalfOfBooking.isDisplayed();
    }

    public void errorMsgForBlankField(){


        clickElement(carSearchButton);
        new WebDriverWait(driver , 30).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".messenger")));
    }

    @Step("open car search page")
    public void openCarSearchPage(){

        JavascriptExecutor js;
        js = (JavascriptExecutor)driver;

        js.executeScript("arguments[0].click()", searchLink);
        js.executeScript("arguments[0].click()", carsSearchLink);
        new WebDriverWait(driver, 50).until(ExpectedConditions.urlContains("Cars/search"));
        Assert.assertTrue("Cars search page is not opened", driver.getCurrentUrl().contains("Cars/search"));

    }

    @Step("car search with invalid input")
    public void invalidSearchCriteria(){


        typeText(pickupField , "qwe");
        typeText(dropOff, "qweee");
        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='start_date']")));
        clickElement(startDate);
        selectDate(startDate, 2);

        clickElement(endDate);
        selectDate(endDate, 5);

        clickElement(carSearchButton);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("messenger")));
        errorMessageContainer.getText().contains("Car Not Available");



    }
    @Step("car search with valid input")
    public void validSearchCriteria(String pickup){

//        driver.manage().deleteCookieNamed("Session");
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='pickup']")));

        typeText(pickupField , pickup);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(.//span[@class = 'airport-label'])[1]")));
        driver.findElement(By.xpath("(.//span[@class = 'airport-label'])[1]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='start_date']")));
        clickElement(startDate);
        selectDate(startDate, 2);

        clickElement(endDate);
        selectDate(endDate, 4);

        clickElement(carSearchButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='cars_progress']")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id = 'search_hotel_result']")));
        carSearchResult.isDisplayed();
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(showDetailsBtn1));


    }

    public void verifyFirstSearchResult()
    {
        carSearchResult.isDisplayed();
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(showDetailsBtn1));
        carImage1.isDisplayed();
        carDescription1.isDisplayed();
        carPriceDetails1.isDisplayed();
        carPriceDetails1.getText().contains("Price starting from");

        showDetailsBtn1.isDisplayed();
        clickElement(showDetailsBtn1);
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='hotel-result']//hroom//div[@class = 'tab-content']")));
        Assert.assertTrue("Car show details is not displayed", new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='hotel-result']//hroom//div[@class = 'tab-content']"))).isDisplayed());

    }

    public void clickCarBookButtonFirstResult(){

        Assert.assertTrue("book button is not enabled ",carBookButton1.isDisplayed());
        carBookButton1.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@ng-model='occupancy.first_name']")));
    }



}
