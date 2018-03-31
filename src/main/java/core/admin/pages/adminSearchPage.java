package core.admin.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class adminSearchPage extends basePage{

    WebDriver driver;
    JavascriptExecutor js;

    @FindBy(xpath = "(.//*[@id='main-menu-wrapper']/ul/li/a/span[contains(.,'Search')])[1]")
    public WebElement searchLink;

    @FindBy(xpath = "(.//a[@href = '/Hotels/search'])[1]")
    public WebElement hotelSearchlink;

    @FindBy(xpath = "(.//a[@href = '/Flights/searchv2'])[1]")
    public WebElement flightsSearchLink;

    @FindBy(xpath = "(.//a[@href = '/Cars/search'])[1]")
    public WebElement carsSearchLink;

    @FindBy(xpath = "(.//a[@href = '/Transfers/search'])[1]")
    public WebElement transfersSearchLink;

    @FindBy(xpath = "(.//a[@href = '/Activities/search'])[1]")
    public WebElement activitiesSearchLink;

    @FindBy(xpath = "(.//a[@href = '/Insurances/search'])[1]")
    public WebElement insuranceSearchLink;

    @FindBy(xpath = "(.//a[@href = '/Cruises/search'])[1]")
    public WebElement cruiseSearchLink;

    @FindBy(xpath = ".//span[contains(., 'Home')]/..")
    public WebElement homeLink;

    public adminSearchPage(){}

    public adminSearchPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Step("Menu search link navigation")
    public void verifySearchNavigation(){


        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='DashboardController']/div[2]/div/div")));
        js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",searchLink);
        js.executeScript("arguments[0].click()",hotelSearchlink);
        new WebDriverWait(driver, 50).until(ExpectedConditions.urlContains("Hotels/search"));
        Assert.assertTrue("search page is not opened",driver.getCurrentUrl().contains("Hotels/search"));

        //js.executeScript("window.history.go(-1)");
        //new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='DashboardController']/div[2]/div/div")));

       // js.executeScript("arguments[0].click()",searchLink);
        js.executeScript("arguments[0].click()", flightsSearchLink);
        new WebDriverWait(driver, 50).until(ExpectedConditions.urlContains("Flights/searchv2"));
        Assert.assertTrue("flight search page is not opened", driver.getCurrentUrl().contains("Flights/searchv2"));
        js.executeScript("arguments[0].click()",searchLink);

        js.executeScript("arguments[0].click()", carsSearchLink);
        new WebDriverWait(driver, 50).until(ExpectedConditions.urlContains("Cars/search"));
        Assert.assertTrue("Cars search page is not opened", driver.getCurrentUrl().contains("Cars/search"));
        js.executeScript("arguments[0].click()",searchLink);

        js.executeScript("arguments[0].click()", transfersSearchLink);
        new WebDriverWait(driver, 50).until(ExpectedConditions.urlContains("Transfers/search"));
        Assert.assertTrue("Transfers search page is not opened",driver.getCurrentUrl().contains("Transfers/search"));
        js.executeScript("arguments[0].click()",searchLink);

        js.executeScript("arguments[0].click()", activitiesSearchLink);
        new WebDriverWait(driver, 50).until(ExpectedConditions.urlContains("Activities/search"));
        Assert.assertTrue("Activities search page is not opened",driver.getCurrentUrl().contains("Activities/search"));

        clickElement(homeLink);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".username")));

    }

    @Step("valid login step")
    public void login(String username, String password){

        validLoginAdmin(username,password);
    }

    public void selectDate(WebElement el, int noOfday) {

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY");
        Date dt = new Date();
        Calendar cl = Calendar.getInstance();
        cl.setTime(dt);
        cl.add(Calendar.DAY_OF_YEAR, noOfday);
        dt = cl.getTime();

        String str = df.format(dt);
        String st = str.substring(0,2);
        if(str.substring(0,1).equals("0"))
            st = str.substring(1,2);

        System.out.println("the date today is " + st);

        driver.findElement(By.xpath(".//td[./text() = '"+st+"' and (not(contains(@class , 'disabled')) and not(contains(@class , 'old')))]")).click();
        waitTillPageLoad(20);
    }


}
