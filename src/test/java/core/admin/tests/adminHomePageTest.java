package core.admin.tests;

import core.admin.pages.adminHomePage;
import core.admin.utility.Listeners.TestListeners;
import core.admin.utility.commonMethods;
import io.qameta.allure.Epic;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;

import java.util.Properties;

@Listeners({ TestListeners.class })
@Epic("Core Tests")
public class adminHomePageTest extends initTest {

    String url = "http://admin.tpconnects.net";
    public adminHomePage adminHomePage;

    public final Logger logger = Logger.getLogger("logger");
    commonMethods commonMethods = new commonMethods();

    @BeforeTest
    public void initPage(){
        adminHomePage = new adminHomePage(driver);
    }


    @Test(description = "verify homepage elements" , priority = 0)
    public void verifyHomePageElements(){
        adminHomePage.bookingTripId.isDisplayed();
        adminHomePage.createNewAgentLink.isDisplayed();
        adminHomePage.logoutLink.isDisplayed();
        adminHomePage.welcomeMsg.isDisplayed();
        adminHomePage.bookingSearchButton.isDisplayed();
        adminHomePage.bookingInfoTiles.isDisplayed();

    }

    @Test(description = "click on create new agent", priority = 1)
    public void clickCreateAgency(){
        adminHomePage.custClicksCreateNewAgent();

    }






}
