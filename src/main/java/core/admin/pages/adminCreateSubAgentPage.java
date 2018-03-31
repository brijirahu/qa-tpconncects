package core.admin.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class adminCreateSubAgentPage extends basePage {

    WebDriver driver;
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

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

    @FindBy(xpath = ".//*[@id='create_new_user']//*[@for='checkAll']")
    public WebElement subAgentCheckUncheckAllPermission;

    @FindBy(xpath = ".//*[@id='username']")
    public WebElement agentUsername;

    @FindBy(xpath = ".//*[@id='password']")
    public WebElement agentPassword;

    @FindBy(xpath = ".//*[@id='confirm_password']")
    public WebElement agentConfirmPassword;

    @FindBy(css = ".btn-success")
    public WebElement subagentSaveBtn;

    public adminCreateSubAgentPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void validSubAgent(){

        typeText(subAgentFname, "agentFname");
        typeText(subAgentLname, "agentLname");
        typeText(subAgentEmail, "brijitha1@mailinator.com");
        typeText(subAgentMobile, "9876543210");
        typeText(subAgentUserCount, "5");
        clickElement(subAgentCheckUncheckAllPermission);

        typeText(agentUsername, randomAgenctUserName());
        typeText(agentPassword, "agent1");
        typeText(agentConfirmPassword,"agent1");
        clickElement(subagentSaveBtn);
        waitTillPageLoad(20);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='checkboxhotel']")));

    }

    public void invalidSubAgent(){

        typeText(subAgentFname, "qwqw");
        typeText(subAgentLname, "agentLname");
        typeText(subAgentEmail, "brijitha1@mailinator.com");
        typeText(subAgentMobile, "9876543210");
        typeText(agentUsername, randomAgenctUserName());
        typeText(agentPassword, "agent");
        typeText(agentConfirmPassword,"agent1");
        clickElement(subagentSaveBtn);
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("flashMessage")));
        Assert.assertTrue("Message doesn't match", driver.findElement(By.id("flashMessage")).getText().contains("Password does not match"));

    }

    public String randomAgenctUserName(){

        Random rd = new Random();
        StringBuilder sb = new StringBuilder();
        while(sb.length() < 6){

            int index = (int) (rd.nextFloat() * AB.length());
            sb.append(AB.charAt(index));
        }
        String str = sb.toString();
        return str;

    }


}
