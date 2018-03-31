package core.admin.tests;

import core.admin.pages.adminHomePage;
import core.admin.pages.adminSaleConfigPage;
import core.admin.utility.Listeners.TestListeners;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ TestListeners.class })
@Epic("Core Tests")
@Feature("Sale Config")
public class adminSaleConfigPageTest extends initTest {

    adminSaleConfigPage adminSaleConfigPage;
    adminHomePage adminHomePage;

    String saleListUrl = "admin.tpconnects.net/admin/sales";

    @BeforeClass
    public void initPage() {

        adminSaleConfigPage = new adminSaleConfigPage(driver);
    }

    @Test(description = "open sale config list page")
    public void openSaleConfigPage() {

        adminHomePage = new adminHomePage(driver);
        adminHomePage.custClicksSaleConfigLink();
    }

    @Test(description = "verify page url")
    public void verifySaleConfigPageUrl(){

        driver.getCurrentUrl().contains(saleListUrl);
    }

    @Test(description = "select add new sale link for Agents")
    public void selectAddNewAgentSale() {
        adminSaleConfigPage.userClickAddNewAgentSale();
    }


}