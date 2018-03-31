package core.admin.tests;

import core.admin.pages.adminSearchPage;
import core.admin.utility.Listeners.TestListeners;
import core.admin.utility.commonMethods;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Properties;

@Listeners({ TestListeners.class })
@Epic("Core Tests")
@Feature("Search module")
public class adminSearchPageTest extends initTest {

    String url = "admin.tpconnects.net";
    adminSearchPage adminSearchPage;
    Properties prop;
    commonMethods commonMethods = new commonMethods();

    @BeforeClass
    public void initPage(){
        adminSearchPage = new adminSearchPage(driver);
    }

    @Test(description = "login to admin", priority = 0)
    public void loginAdmin(){
        prop = new Properties(commonMethods.getTestData());
        String username = prop.getProperty("validUser");
        String password = prop.getProperty("validPass");
        adminSearchPage.login(username,password);
    }

//    @Test(description = "verify search page is opened on clicking search menu links", priority = 1)
//    public void verifySearchPageOpened(){
//
//    adminSearchPage.verifySearchNavigation();
//    }

   // @Test(description = "")

}
