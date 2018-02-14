package core.admin.tests;


import core.admin.pages.adminOrganisationAddPage;
import core.admin.utility.Listeners.TestListeners;
import core.admin.utility.commonMethods;
import io.qameta.allure.Epic;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Properties;

@Listeners({ TestListeners.class })
@Epic("Core Tests")
public class adminOrganisationAddPageTest extends initTest {

    String url = "http://admin.tpconnects.net/admin/organisations/organisationsadd";
    adminOrganisationAddPage adminOrganisationAddPage;

    public final Logger logger = Logger.getLogger("logger");
    commonMethods commonMethods = new commonMethods();
    Properties prop;

    @Test(description = "")
    public void verifyErrorMessageinCreateAgency(){

        prop = new Properties(commonMethods.getTestData());
        adminOrganisationAddPage.validInputAgentCreation(prop);

    }
}
