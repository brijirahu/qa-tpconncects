package core.admin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.log4j.Logger;
import java.util.concurrent.TimeUnit;


public class adminLoginPage {

    WebDriver driver;
    Logger logger = Logger.getLogger(adminLoginPage.class);


    @FindBy(xpath = "//*[@id='login_username']")
    public WebElement adminUsernameField;

    @FindBy(xpath = "//*[@id='login_pass']")
    public WebElement adminPasswordField;

    @FindBy(xpath = "//*[@id='login_sbmt_btn']")
    public WebElement adminSubmitBtn;

    @FindBy(xpath = "//*[@id='forgot_link']/a")
    public WebElement forgotPassLink;

    @FindBy(xpath = ".//*[@class='error_msg']")
    public WebElement errorMsg;

    public adminLoginPage(WebDriver driver){

        PageFactory.initElements(driver, this);
        this.driver = driver;

    }
    public void verifyLoginElementsDisplayed(){
        adminUsernameField.isDisplayed();
        adminPasswordField.isDisplayed();
        adminSubmitBtn.isDisplayed();
        forgotPassLink.isDisplayed();
    }

    public void verifyInvalidLoginErrorMsg(String username, String password){
        adminUsernameField.sendKeys(username);
        adminPasswordField.sendKeys(password);
        adminSubmitBtn.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(errorMsg));
        errorMsg.isDisplayed();
        String errMsg  = errorMsg.getText();
        System.out.println("error ----> "+errMsg);
        logger.info("error message captured : "+errorMsg);
        Assert.assertTrue(errorMsg.getText().equals("Your username or password was incorrect."), "*** Error message   "+errorMsg.getText()+" displayed is not appropriate ***");
    }




}
