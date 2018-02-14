package core.admin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class adminCreateSubAgentPage extends basePage {

    WebDriver driver;

    @FindBy(xpath =".//*[@id='create_new_user']//select")
    public WebElement agentAddessingSelect;

    @FindBy(xpath = ".//*[@id='firstname']")
    public WebElement subAgentFname;

    @FindBy(xpath = ".//*[@id='lastname']")
    public WebElement subAgentLname;

    @FindBy(xpath = ".//*[@id='email']")
    public WebElement subAgentEmail;

    @FindBy(xpath = ".//*[@id='mobile']")
    public WebElement subAgentMobile;

    @FindBy(xpath = ".//*[@id='securityansw']")
    public WebElement subAgentUserCount;

    @FindBy(xpath = ".//input[@id='male']")
    public WebElement subAgentMaleRadioBtn;

    @FindBy(xpath = ".//input[@id='female']")
    public WebElement subAgentFemaleRadioBtn;

    @FindBy(xpath = ".//*[@id='create_new_user']//*[@id='checkAll']")
    public WebElement subAgentCheckUncheckAllPermission;

    @FindBy(xpath = ".//*[@id='username']")
    public WebElement agentUsername;

    @FindBy(xpath = ".//*[@id='password']")
    public WebElement agentPassword;

    @FindBy(xpath = ".//*[@id='confirm_password']")
    public WebElement agentConfirmPassword;

    public adminCreateSubAgentPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
}
