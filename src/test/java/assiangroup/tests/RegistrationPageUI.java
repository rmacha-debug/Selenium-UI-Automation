package assiangroup.tests;

import assiangroup.pages.BasePage;
import assiangroup.pages.HomePage;
import assiangroup.pages.LoginPage;
import assiangroup.pages.RegisterPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Properties;

public class RegistrationPageUI {

    WebDriver driver = null;
    Faker faker = new Faker();
    Properties prop = null;
    @Test()
    @Parameters({"Browser", "Locale","Environment"})
    public void verifyRegistrationPageUI(String Browser, String Locale,String Environment) throws InterruptedException {
        BasePage driverPage = new BasePage();
        driver = driverPage.getBrowser(Browser);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        prop = driverPage.loadLocale(Locale);
        driver.get(driverPage.getAppUrl(Environment));
        Assert.assertEquals(true,true,"Application launched in successfully");
        Reporter.log("Application launched in successfully");
        loginPage.selectLocale(Locale);
        loginPage.clickOnRegister();
        RegisterPage registerPage = new RegisterPage(driver);
        SoftAssert softAssertion= new SoftAssert();
        softAssertion.assertEquals(registerPage.getEmail(),prop.get("ASG_Label_Email"),"Verify Email Label Text");
        softAssertion.assertEquals(registerPage.getPassword(),prop.get("ASG_Label_Password"),"Verify Password Label Text");
        softAssertion.assertEquals(registerPage.getConfirmPassword(),prop.get("ASG_Label_Confirm_password"),"Verify Confirm Password Label Text");
        softAssertion.assertEquals(registerPage.getRegister(),prop.get("ASG_Label_Register"),"Verify Register Label Text");
        softAssertion.assertEquals(registerPage.getBackToHome(),prop.get("ASG_Label_ASG_Label_Back_to_Login"),"Verify Register Label Text");
        softAssertion.assertEquals(registerPage.getRegisterTitle(),prop.get("ASG_Title_Register"),"Verify Register Title Label Text");
        softAssertion.assertEquals(registerPage.getLocale(),prop.get("ASG_Locale"),"Verify Register Locale Drop Down Text");
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
