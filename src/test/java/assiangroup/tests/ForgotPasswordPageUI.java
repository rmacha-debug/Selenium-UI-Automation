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
import org.testng.asserts.SoftAssert;

import java.util.Properties;

public class ForgotPasswordPageUI {
    WebDriver driver = null;
    @Test()
    @Parameters({"Browser", "Locale","Environment"})
    public void VerifyForgotPageUI(String Browser, String Locale,String Environment) throws InterruptedException {
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
        SoftAssert softAssertion= new SoftAssert();
        ForgotPasswordPage forgotPage = new ForgotPasswordPage(driver);
        softAssertion.assertEquals(forgotPage.getEmail(),prop.get("ASG_Label_Email"),"Verify Email Label Text");
        softAssertion.assertEquals(forgotPage.getSubmit(),prop.get("ASG_ForgotPwd_Submit"),"Verify Submit Text");
        softAssertion.assertEquals(forgotPage.getForgotPasswordInstruction(),prop.get("ASG_ForgotPwd_Instruction"),"Verify Forgot Password Instruction Text");
        softAssertion.assertEquals(forgotPage.getBackToHome(),prop.get("ASG_Label_ASG_Label_Back_to_Login"),"Verify Back to Home Label Text");
        softAssertion.assertEquals(forgotPage.getLocale(),prop.get("ASG_Locale"),"Verify Locale Drop Down Text");
        softAssertion.assertAll();
    }
    @AfterClass
    public void teardown()
    {
        driver.close();
        driver.quit();
        Reporter.log("Browser closed Successfully");
    }

}
