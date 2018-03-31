package core.admin.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;
//import ru.yandex.qatools.allure.annotations.Step;


public class adminLoginPage extends basePage{

    WebDriver driver;
    Logger logger = Logger.getLogger(adminLoginPage.class);
    JavascriptExecutor js;



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
        super(driver);

        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    @Step("Verify admin login page elements step..")
    public void verifyLoginElementsDisplayed(){
        adminUsernameField.isDisplayed();
        adminPasswordField.isDisplayed();
        adminSubmitBtn.isDisplayed();
        forgotPassLink.isDisplayed();
    }

    @Step("Admin Login with invalid credentials step..")
    public void verifyInvalidLoginErrorMsg(String username, String password){

        typeText(adminUsernameField,username);
        js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('login_pass').focus();");
        js.executeScript("document.getElementById('login_pass').click();");
        typeText(adminPasswordField,password);
        clickElement(adminSubmitBtn);
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(errorMsg));
        errorMsg.isDisplayed();
        String errMsg  = errorMsg.getText();
        logger.info("error message captured : "+errMsg);
       Assert.assertTrue("*** Error message "+errorMsg.getText()+" displayed is not appropriate ***",errMsg.equals("Your username or password was incorrect."));
    }

    @Step("Admin Login with valid credentials step..")
    public void verifyvalidLogin(String username, String password){

        typeText(adminUsernameField,username);
        js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('login_pass').focus();");
        js.executeScript("document.getElementById('login_pass').click();");
        typeText(adminPasswordField,password);
        clickElement(adminSubmitBtn);
        Assert.assertTrue("Message displayed is not as expected",driver.findElement( By.className("error_msg")).getText().contains("Successfully logging"));
        waitTillPageLoad(30);
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".username")));

     }




}
