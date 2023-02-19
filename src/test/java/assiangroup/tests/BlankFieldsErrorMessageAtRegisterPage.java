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
import java.util.Properties;

public class BlankFieldsErrorMessageAtRegisterPage {
    WebDriver driver = null;
    Faker faker = new Faker();
    Properties prop = null;
    @Test()
    @Parameters({"Browser", "Locale","Environment"})
    public void verifyUserRegistration(String Browser, String Locale,String Environment) throws InterruptedException {
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
        registerPage.userRegistration("","","");
        String EmailError = (String) prop.get("ASG_RegErr_email");
        String UserError = (String) prop.get("ASG_RegErr_Username");
        String PasswordError = (String) prop.get("ASG_RegErr_password");
        String RegisterPageErrMsg = registerPage.getErrorMsg();
        if(RegisterPageErrMsg.contains(EmailError)){
            Reporter.log("Verify Blank Email Error Register Page"+EmailError);
        }else{
            Assert.assertEquals(RegisterPageErrMsg,PasswordError," Expected : Please specify Email."+"Actual"+RegisterPageErrMsg);
        };
        if(RegisterPageErrMsg.contains(PasswordError)){
            Reporter.log("Verify Blank Password Error Register Page "+PasswordError);
        }else{
            Assert.assertEquals(RegisterPageErrMsg,PasswordError," Expected : Please specify Password."+"Actual"+RegisterPageErrMsg);
        };
        if(RegisterPageErrMsg.contains(UserError)){
            Reporter.log("Verify Blank Username Error Register Page "+UserError);
        }else{
            Assert.assertEquals(RegisterPageErrMsg,PasswordError," Expected : Please specify UserName."+"Actual"+RegisterPageErrMsg);
        };


    }
    @AfterClass
    public void teardown()
    {
        driver.close();
        driver.quit();
        Reporter.log("Browser closed Successfully");
    }
}
