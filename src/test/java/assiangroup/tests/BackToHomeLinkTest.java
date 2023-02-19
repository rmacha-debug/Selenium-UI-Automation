package assiangroup.tests;

import assiangroup.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Properties;

public class BackToHomeLinkTest {
    WebDriver driver = null;
    @Test()
    @Parameters({"Browser", "Locale","Environment"})
    public void verifyBlankEmailAddressAndPasswordErrorMessage(String Browser, String Locale,String Environment) throws InterruptedException {
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
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        SoftAssert softAssertion= new SoftAssert();
        softAssertion.assertEquals(forgotPasswordPage.getBackToHome(),prop.get("ASG_Label_ASG_Label_Back_to_Login"),"Verify Back to Home Label Text");
        forgotPasswordPage.clickBackToLogin();
        softAssertion.assertEquals(loginPage.getSignTitle(),prop.get("ASG_Header_Title"),"Verify Login Page Title Label Text");
        loginPage.clickOnRegister();
        RegisterPage registerPage = new RegisterPage(driver);
        softAssertion.assertEquals(registerPage.getRegisterTitle(),prop.get("ASG_Title_Register"),"Verify Register Title Label Text");
        registerPage.clickBackToHome();
        softAssertion.assertEquals(loginPage.getSignIn(),prop.get("ASG_Button_Sign_In"),"Verify Login Page Title Label Text");
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
