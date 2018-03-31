package core.admin.tests;

import core.admin.pages.adminCarBlockPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class adminCarBlockPageTest extends initTest {

    adminCarBlockPage adminCarBlockPage;

    @BeforeClass
    public void initPage(){
        adminCarBlockPage = new adminCarBlockPage(driver);
    }

    @Test(description = "verify car block page", priority = 0)
    public void verifyCarBlockPage(){
        adminCarBlockPage.verifyCarBlockPage();
    }

    @Test(description = "verify car booking", priority = 1)
    public void verifyCarBooking(){

        adminCarBlockPage.clickConfirmCar();

    }

    @Test(description = "verify car booking success page", priority = 2)
    public void verifyBookingSuccessPage(){

        Assert.assertTrue("Booking is not confirmed, the status of the booking is "+ adminCarBlockPage.statusColumn.getText(),
                adminCarBlockPage.statusColumn.getText().contains("Confirmed"));
        Assert.assertTrue("", adminCarBlockPage.tripId.findElement(By.xpath("span")).getText().length() == 15 );

        Assert.assertTrue("Start date does not contain in Car detail column",adminCarBlockPage.carNameDateColumn.getText().contains("Start in"));


    }
}
