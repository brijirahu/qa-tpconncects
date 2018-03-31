package core.admin.tests;

import core.admin.pages.adminCarBlockPage;
import core.admin.pages.adminSearchCarPage;
import core.admin.pages.adminSearchPage;
import core.admin.utility.ExcelUtils;
import core.admin.utility.Listeners.TestListeners;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Listeners({ TestListeners.class })
@Epic("Core Tests")
@Feature("Search module")
public class adminSearchCarPageTest extends initTest {

    adminSearchCarPage adminSearchCarPage;
    adminCarBlockPage adminCarBlockPage;
    public static final String currentDir = System.getProperty("user.dir");
    private String sTestCaseName;
    static String[][] data;


    @BeforeClass
    public void initPage() {
        adminSearchCarPage = new adminSearchCarPage(driver);
        adminCarBlockPage = new adminCarBlockPage(driver);
    }

    @DataProvider
    public Object[][] carSearchData() {

        sTestCaseName = this.toString();
        sTestCaseName = ExcelUtils.getTestCaseName(this.toString());
        System.out.println("testcase name  "+ sTestCaseName);
        ExcelUtils.setExcelFileSheet("Sheet2");

        data = ExcelUtils.getData("Sheet2",sTestCaseName);
        System.out.println("data ----  "+ data[0][0]);
        return data;


    }

//    @DataProvider
//    public Object[][] searchData() {
//
//       return data[][] = {}
//
//
//    }

    @Test(description = "open car search page", priority = 0)
    public void openCarSearchPage() {

        adminSearchCarPage.openCarSearchPage();
    }

    @Test(description = "verify car search page elements", priority = 1)
    public void verifyCarSearchElements() {
        adminSearchCarPage.verifyCarSearchElements();
    }

    @Test(description = "verify error message for blank fields", priority = 2)
    public void verifyErrMsgBlankFields() {
        adminSearchCarPage.errorMsgForBlankField();
    }

    @Test(description = "error message for invalid car search criteria", priority = 3)
    public void verifyErrMsgInvalidData() {
        adminSearchCarPage.invalidSearchCriteria();
    }

    @Test(dataProvider = "carSearchData" , description = "valid car search criteria", priority = 4)
    public void verifyValidData(String pickup) {

        String searchurl = "http://admin.tpconnects.net/Cars/search";
        driver.navigate().to(searchurl);
        adminSearchCarPage.validSearchCriteria(pickup);
        adminSearchCarPage.verifyFirstSearchResult();
        adminSearchCarPage.clickCarBookButtonFirstResult();
        adminCarBlockPage = new adminCarBlockPage(driver);
        adminCarBlockPage.verifyCarBlockPage();
        adminCarBlockPage.clickConfirmCar();
        Assert.assertTrue("Booking is not confirmed, the status of the booking is "+ adminCarBlockPage.statusColumn.getText(),
                adminCarBlockPage.statusColumn.getText().contains("Confirmed"));
        Assert.assertTrue("", adminCarBlockPage.tripId.findElement(By.xpath("span")).getText().length() == 15 );

        Assert.assertTrue("Start date does not contain in Car detail column",adminCarBlockPage.carNameDateColumn.getText().contains("Start in"));
    }


}
