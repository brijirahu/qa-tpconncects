package core.admin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class adminNewSaleAddMarkupPage extends adminAddNewSalePage {

    WebDriver driver;

    @FindBy(xpath = ".//*[@id='ajselectchange']")
    public WebElement supplierDropdown;

    @FindBy(xpath = "//input[@ng-model='markups.markup.markupHotel.markupAmount']")
    public WebElement hotelMarkup;

    public adminNewSaleAddMarkupPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver , this);
        this.driver = driver;
    }


}
