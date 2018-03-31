package core.admin.tests;

import core.admin.utility.Listeners.TestListeners;
import core.admin.utility.commonMethods;
import core.admin.pages.adminLoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.Properties;
import org.apache.log4j.Logger;


@Listeners({ TestListeners.class })
@Epic("Core Tests")
@Feature("Admin login tests")
public class adminLoginPageTest extends initTest  {


    String url = "http://admin.tpconnects.net";
    public adminLoginPage adminLoginPage;

    public final Logger logger = Logger.getLogger("logger");
    commonMethods commonMethods = new commonMethods();
    Properties prop;

    @BeforeTest
    public void initUrl(){
        openUrl(url);
        logger.info("**** Inside adminLoginPageTest beforeTest *****");
        logger.info(getDriver().getWindowHandle());
        adminLoginPage = new adminLoginPage(getDriver());
    }



    @Step("Verify admin login page url step..")
    @Test(description = "Verify login page url")
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
        adminLoginPage.verifyvalidLogin(username,password);
    }





}

