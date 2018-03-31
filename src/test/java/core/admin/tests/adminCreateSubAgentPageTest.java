package core.admin.tests;

import core.admin.pages.adminCreateSubAgentPage;
import core.admin.utility.Listeners.TestListeners;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ TestListeners.class })
@Epic("Core Tests")
@Feature("Admin agency sub create tests")
public class adminCreateSubAgentPageTest extends initTest {

    String url = "admin.tpconnects.net/admin/organisations/createsubagent";
    adminCreateSubAgentPage adminCreateSubAgentPage;

    @BeforeClass
    public void initPage(){
        adminCreateSubAgentPage = new adminCreateSubAgentPage(driver);
    }

    @Test(description = "verify add agent page url", priority = 0)
    public void verifyAddSubAgentUrl(){

        driver.getCurrentUrl().contains(url);
    }
    @Test(description = "verify error message for password mismatch" , priority = 1)
    public void verifyAddAgencyElements(){
        adminCreateSubAgentPage.invalidSubAgent();
    }

    @Test(description = "verify creation with valid data" , priority = 2)
    public void verifyValidAgentCreation(){
        adminCreateSubAgentPage.validSubAgent();
    }




}
