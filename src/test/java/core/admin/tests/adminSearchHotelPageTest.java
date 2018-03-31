package core.admin.tests;

import core.admin.pages.adminSearchHotelPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Core Tests")
@Feature("Search module")
public class adminSearchHotelPageTest extends initTest {

    String url = "admin.tpconnects.net";
    adminSearchHotelPage adminSearchHotelPage ;

    @BeforeClass
    public void initPage(){
        adminSearchHotelPage = new adminSearchHotelPage(driver);
    }

    @Test(description = "open hotel search page" , priority = 0)
    public void openCarSearchPage(){

        adminSearchHotelPage.openHotelSearchPage();
    }

    @Test(description = "blank field error message" , priority = 1)
    public void errorBlankField(){
        adminSearchHotelPage.errorMsgForBlankField();
    }
    @Test(priority = 2)
    public void invalidSearchCriteria(){
        adminSearchHotelPage.invalidSearchCriteria();
    }




}
