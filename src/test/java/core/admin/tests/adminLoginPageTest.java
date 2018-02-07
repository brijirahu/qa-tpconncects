package core.admin.tests;

import core.admin.utility.ScreenshotListener;
import core.admin.utility.commonMethods;
import core.admin.pages.adminLoginPage;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.util.Properties;
import org.apache.log4j.Logger;


@Listeners(ScreenshotListener.class)
public class adminLoginPageTest extends initTest  {


    String url = "http://admin.tpconnects.net";
    adminLoginPage adminLoginPage;

    public final Logger logger = Logger.getLogger("logger");
    commonMethods commonMethods = new commonMethods();
    Properties prop;

    @Parameters("browser")
    @BeforeClass
    public void initSetup(String browser) {
        initDriver(browser);
        openUrl(url);
        logger.info("****Inside adminLoginPageTest beforeClass*****");
        logger.info(getDriver().getWindowHandle());
        adminLoginPage = new adminLoginPage(getDriver());

    }

    @Test
    public void verifyLoginPageUrl(){
        logger.info("****Login page****");

            Assert.assertTrue( getDriver().getCurrentUrl().contains(url), "Page title is not as expected "+ getDriver().getCurrentUrl());
    }

    @Test
    public void verifyLoginPageElementsDisplayed() {

        logger.info("****login page elements****");
        adminLoginPage.verifyLoginElementsDisplayed();
    }

    @Test
    public void verifyErrorMsgForInvalidLogin(){
        prop = new Properties(commonMethods.getTestData());

            //prop = commonMethods.getTestData();
            String username = prop.getProperty("invalidUser");
            String password = prop.getProperty("invalidPass");
            adminLoginPage.verifyInvalidLoginErrorMsg(username,password);
    }

    @Test
    public void verifyvalidLogin(){
        prop = new Properties(commonMethods.getTestData());

        //prop = commonMethods.getTestData();
        String username = prop.getProperty("validUser");
        String password = prop.getProperty("validPass");
        adminLoginPage.verifyInvalidLoginErrorMsg(username,password);
    }

    @AfterClass
    public void closeDriver(){
       quitDriver();

    }




}

