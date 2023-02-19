package assiangroup.tests;

import assiangroup.pages.*;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Properties;

public class RegistrationTest {
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
        String UserName = faker.internet().emailAddress();
        registerPage.userRegistration(UserName,"123456","123456");
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertEquals(dashboardPage.verifyFlag(),true,"Application Logged in successfully");
        Reporter.log(UserName +"Registered and Logged in successfully");
        Assert.assertEquals(loginPage.logout(),true,"");
        Reporter.log("User "+ UserName+" log out in successfully");
    }

    @AfterClass
    public void teardown()
    {
        driver.close();
        driver.quit();
        Reporter.log("Browser closed Successfully");
    }

}
