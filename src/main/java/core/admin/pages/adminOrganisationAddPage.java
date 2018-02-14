package core.admin.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class adminOrganisationAddPage extends basePage{

    WebDriver driver;
    Logger logger = Logger.getLogger(adminOrganisationAddPage.class);

    @FindBy(xpath = "//input[@id='agent_name']")
    public WebElement agencyNameField;

    @FindBy(xpath = "//input[@id='emailid']")
    public WebElement agencyEmailField;

    @FindBy(xpath = "//input[@id='contactnumber']")
    public WebElement agencyContactNoField;

    @FindBy(xpath = "///input[@id='credit_limit']")
    public WebElement agencyCreditLimitField;

    @FindBy(xpath = "//select[@id='payment_gateway']")
    public WebElement agencyPGSelect;

    @FindBy(xpath = "//a[contains(.,'UAE Dirham')]")
    public WebElement agencyDefaultCurrency;

    @FindBy(xpath = "(.//*[@id='contactnumber_chosen']/a/span[contains(.,'India')])[1]")
    public WebElement agencyOperatingCountrySelect;

    @FindBy(xpath = ".//*[@id='contactnumber_chosen']/a/span[contains(.,'Dubai')]")
    public WebElement agencyTimeZone;

    @FindBy(xpath = "//input[@id='contact_person_name']")
    public WebElement agencyContactPersonName;

    @FindBy(xpath = "//input[@id='contact_mobile_number']")
    public WebElement agencyContactPersonNoField;

    @FindBy(xpath = ".//*[@id='contact_person_email']")
    public WebElement agencyContactEmailField;

    @FindBy(xpath = "//input[@id='address_1']")
    public WebElement agencyContactAddress1;

    @FindBy(xpath = ".//*[@id='city_chosen']/a")
    public WebElement agencyConatctCity;

    @FindBy (xpath = ".//*[@id='state_province']")
    public WebElement agencyContactStateField;

    @FindBy(xpath = "//input[@id='zip']")
    public WebElement agencyContactZipField;

    @FindBy(xpath = "(.//*[@id='contactnumber_chosen']/a/span[contains(.,'India')])[2]")
    public WebElement agencyContactCountry;

    @FindBy(xpath = "//input[@id='flight_stats']")
    public WebElement agencyFlightStats;

    @FindBy(xpath = "//input[@id='hotel_stats']")
    public WebElement agencyHotelStats;

    @FindBy(xpath = "//input[@id='transfer_stats']")
    public WebElement agencyTransferStats;

    @FindBy(xpath = "//input[@id='insurance_stats']")
    public WebElement agencyInsuranceStats;

    @FindBy(xpath = "//input[@id='cruise_stats']")
    public WebElement agencyCruiseStats;

    @FindBy(xpath = "//input[@id='car_stats']")
    public WebElement agencyCarStats;

    @FindBy(xpath = "//input[@id='activities_stats']")
    public WebElement agencyActivitiesStats;

    @FindBy(xpath = "//button[contains(@data-target,'#myModal1')]")
    public WebElement agencyWebsiteUploadImage1;

    @FindBy(xpath = "//button[contains(@data-target,'#myModal2')]")
    public WebElement agencyInvoiceUploadImage2;

    @FindBy(xpath = "//button[contains(@data-target,'#myModal3')]")
    public WebElement agencySignatureUploadImage3;

    @FindBy(xpath = "#myModal1 .modal-content")
    public WebElement agencyUploadPopUp1;

    @FindBy(xpath = ".//*[@id='dos']")
    public WebElement websiteChooseFileBtn;

    @FindBy(xpath = ".//*[@id='image_file1_upload']")
    public WebElement agentUpload1;

    @FindBy(xpath = ".//*[@id='image_file2_upload']")
    public WebElement agentUpload2;

    @FindBy(xpath = ".//*[@id='image_file3_upload']")
    public WebElement agentUpload3;

    @FindBy(xpath = ".//*[@id='image_file4_upload']")
    public WebElement agentUpload4;


    @FindBy(xpath = ".//*[@id='about']")
    public WebElement companyInformation;




    public adminOrganisationAddPage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void verifyAllFieldsArepresent(){

        agencyNameField.isDisplayed();
        agencyEmailField.isDisplayed();
        agencyContactNoField.isDisplayed();
        agencyCreditLimitField.isDisplayed();
        agencyPGSelect.isDisplayed();
        agencyDefaultCurrency.isDisplayed();
        agencyTimeZone.isDisplayed();
        agencyOperatingCountrySelect.isDisplayed();
        //Contact Information : Agent Address
        agencyContactPersonName.isDisplayed();
        agencyContactEmailField.isDisplayed();
        agencyContactPersonNoField.isDisplayed();
        agencyContactAddress1.isDisplayed();
        agencyConatctCity.isDisplayed();
        agencyContactStateField.isDisplayed();
        agencyContactZipField.isDisplayed();
        agencyContactCountry.isDisplayed();

        //Monthly Target Information
        agencyFlightStats.isDisplayed();
        agencyTransferStats.isDisplayed();
        agencyActivitiesStats.isDisplayed();
        agencyInsuranceStats.isDisplayed();
        agencyCarStats.isDisplayed();
        agencyHotelStats.isDisplayed();

        //Branding Information
        agencyWebsiteUploadImage1.isDisplayed();
        agencyInvoiceUploadImage2.isDisplayed();
        agencySignatureUploadImage3.isDisplayed();

        //Agent uploads
        agentUpload1.isDisplayed();
        agentUpload2.isDisplayed();
        agentUpload3.isDisplayed();
        agentUpload4.isDisplayed();

        //Company Information
        companyInformation.isDisplayed();

    }

    public void validInputAgentCreation(Properties prop){

        typeText(agencyNameField, prop.getProperty("validAgencyName"));
        typeText(agencyEmailField, prop.getProperty("validAgencyEmail"));
        typeText(agencyContactNoField,prop.getProperty("validAgencyContact"));
        typeText(agencyCreditLimitField,prop.getProperty("validAgencyCreditLimit"));
        //typeText(agencyContactPersonName, prop.getProperty());



    }


}
