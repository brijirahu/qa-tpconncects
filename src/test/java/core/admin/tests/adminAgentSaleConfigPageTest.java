package core.admin.tests;

import core.admin.pages.adminAgentSaleConfigPage;
import core.admin.pages.adminCreateSubAgentPage;
import core.admin.utility.Listeners.TestListeners;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ TestListeners.class })
@Epic("Core Tests")
@Feature("Admin agency sub create tests")
public class adminAgentSaleConfigPageTest extends initTest {

    String url = "admin.tpconnects.net/admin/organisations/addsaleconfig";
    adminAgentSaleConfigPage adminAgentSaleConfigPage;


    @BeforeClass
    public void initPage(){
        adminAgentSaleConfigPage = new adminAgentSaleConfigPage(driver);
    }

    @Test(priority = 0)
    @Description("verify sale config page url")
    public void verifySaleConfigUrl(){
        driver.getCurrentUrl().contains(url);
    }

    @Test(priority = 1)
    @Description("Verify elements present in sale config page")
    public void verifySaleConfigPageElements(){

        adminAgentSaleConfigPage.transferCheckbox.isDisplayed();
        adminAgentSaleConfigPage.hotelCheckbox.isDisplayed();
        adminAgentSaleConfigPage.flightCheckbox.isDisplayed();
        adminAgentSaleConfigPage.activityCheckbox.isDisplayed();
    }

    @Test(priority = 2)
    @Description("Create agency without markup")
    public void verifySaveContinue(){

        adminAgentSaleConfigPage.saveAndContinue();
    }


}
