package core.admin.utility.Listeners;

import core.admin.tests.initTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners extends initTest implements ITestListener{

    private  static String getTestMethodName(ITestResult iTestResult){
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    //Image Attachments for Allure
    @Attachment(value = "Page screenshot" , type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    //Text Attachments for Allure
    @Attachment(value = "Save log" , type = "text/plain")
    public static String saveTextLog(String message){
        return message;
    }

    //HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

    @Override
    public void onStart(ITestContext iTestContext) {

        System.out.println(" onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", this.driver);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("I am in onFinish method " + iTestContext.getName());

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult){
        System.out.println("I am in onTestKipped method " + iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult){
        System.out.println("I am in onTestSuccess method " + iTestResult.getName());
    }

    @Override
    public void onTestStart(ITestResult iTestResult){
        System.out.println(" onTestSuccess method " + iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult){
        System.out.println(" onTestFailure method  " + getTestMethodName(iTestResult) +  "failed");

        Object testClass = iTestResult.getInstance();
        WebDriver driver = ((initTest)testClass).getDriver();

        //Allure screenshot and save text log
        if (driver != null){

            System.out.println("Screenshot captured for test case: "+ getTestMethodName(iTestResult));
            saveScreenshotPNG(driver);
        }
        attachHtml(getTestMethodName(iTestResult) + "html ");
        saveTextLog(getTestMethodName(iTestResult) + "failed and screenshot taken! ");
    }


    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
}
