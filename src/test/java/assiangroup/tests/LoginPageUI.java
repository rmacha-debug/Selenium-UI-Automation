package assiangroup.tests;

import assiangroup.pages.BasePage;
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

public class LoginPageUI {
    WebDriver driver = null;
    @Test()
    @Parameters({"Browser", "Locale","Environment"})
    public void VerifyLoginPageUI(String Browser, String Locale,String Environment) throws InterruptedException {
        BasePage driverPage = new BasePage();
        driver = driverPage.getBrowser(Browser);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        driverPage.loadLocale(Locale);
        Properties prop = driverPage.loadLocale(Locale);
        driver.get(driverPage.getAppUrl(Environment));
        Assert.assertEquals(true,true,"Application launched in successfully");
        Reporter.log("Application launched in successfully");
        loginPage.selectLocale(Locale);
        SoftAssert softAssertion= new SoftAssert();
        softAssertion.assertEquals(loginPage.getEmail(),prop.get("ASG_Label_Email"),"Verify Email Label Text");
        softAssertion.assertEquals(loginPage.getPassword(),prop.get("ASG_Label_Password"),"Verify Password Label Text");
        softAssertion.assertEquals(loginPage.getSignIn(),prop.get("ASG_Button_Sign_In"),"Verify Sign In Label Text");
        softAssertion.assertEquals(loginPage.getRememberMe(),prop.get("ASG_Label_Remember_me"),"Verify Remember me Label Text");
        softAssertion.assertEquals(loginPage.getForgotPassword(),prop.get("ASG_Label_Forgot_Password"),"Verify Forgot Password Label Text");
        softAssertion.assertEquals(loginPage.getNewUser(),prop.get("ASG_Label_NewUser")+""+prop.get("ASG_Label_Register") ,"Verify NewUser Label Text");
        softAssertion.assertEquals(loginPage.getRegister(),prop.get("ASG_Label_Register"),"Verify Register Label Text");
        softAssertion.assertEquals(loginPage.getSignTitle(),prop.get("ASG_Header_Title"),"Verify Login Page Title Label Text");
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
