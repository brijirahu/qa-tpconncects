package core.admin.tests;


import core.admin.pages.adminHomePage;
import core.admin.pages.adminOrganisationAddPage;
import core.admin.utility.Listeners.TestListeners;
import core.admin.utility.commonMethods;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.log4j.Logger;
import org.testng.annotations.*;

import java.util.Properties;

@Listeners({ TestListeners.class })
@Epic("Core Tests")
@Feature("Admin agency create tests")
public class adminOrganisationAddPageTest extends initTest {

    String url = "admin.tpconnects.net/admin/organisations/organisationsadd";
    adminOrganisationAddPage adminOrganisationAddPage;

    public final Logger logger = Logger.getLogger("logger");
    commonMethods commonMethods = new commonMethods();
    Properties prop;

    @BeforeClass
    public void initPage(){
        adminOrganisationAddPage = new adminOrganisationAddPage(driver);
    }

    @Test(description = "verify add agent page url", priority = 0)
    public void verifyAddAgentUrl(){

        driver.getCurrentUrl().contains(url);
    }

    @Test(description = "verify all fields in agency add page" , priority = 1)
    public void verifyAddAgencyElements(){
        adminOrganisationAddPage.verifyAllFieldsArepresent();
    }



    @Test(description = "valid input agency create 1st step", priority = 2)
    public void verifyValidCreateAgency(){

        prop = new Properties(commonMethods.getTestData());
        adminOrganisationAddPage.validInputAgentCreation(prop);

    }


//    @AfterSuite
//    public void closeDriver(){
//        quitDriver();
//
//    }

}
