package assiangroup.tests;

import assiangroup.pages.BasePage;
import assiangroup.pages.ForgotPasswordPage;
import assiangroup.pages.HomePage;
import assiangroup.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Properties;

public class BlankForgotPasswordErrorMessage {
    WebDriver driver = null;
    @Test()
    @Parameters({"Browser", "Locale","Environment"})
    public void VerifyBlankForgotPasswordErrorMessage(String Browser, String Locale,String Environment) throws InterruptedException {
        BasePage driverPage = new BasePage();
        driver = driverPage.getBrowser(Browser);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        Properties prop = driverPage.loadLocale(Locale);
        driver.get(driverPage.getAppUrl(Environment));
        Assert.assertEquals(true,true,"Application launched in successfully");
        Reporter.log("Application launched in successfully");
        loginPage.selectLocale(Locale);
        loginPage.clickOnForgotPassword();
        ForgotPasswordPage forgotPage = new ForgotPasswordPage(driver);
        forgotPage.ForgotPasswordSubmission("");
        Assert.assertEquals(forgotPage.getErrorMsg(),prop.get("ASG_RegErr_Username"),"Blank Email error Message at Forgot Password page");
        Reporter.log("Verified Blank Email error Message at Forgot Password page");
    }
    @AfterClass
    public void teardown()
    {
        driver.close();
        driver.quit();
        Reporter.log("Browser closed Successfully");
    }
}
