package assiangroup.tests;

import assiangroup.pages.BasePage;
import assiangroup.pages.HomePage;
import assiangroup.pages.LoginPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Properties;

public class InvalidEmailAddressAndPasswordErrorMessage {

    WebDriver driver = null;
    @Test()
    @Parameters({"Browser", "Locale","Environment"})
    public void verifyInvalidEmailErrorMessage(String Browser, String Locale,String Environment) throws InterruptedException {
        BasePage driverPage = new BasePage();
        driver = driverPage.getBrowser(Browser);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        Properties prop = driverPage.loadLocale(Locale);
        driver.get(driverPage.getAppUrl(Environment));
        Assert.assertEquals(true,true,"Application launched in successfully");
        Reporter.log("Application launched in successfully");
        loginPage.selectLocale(Locale);
        Faker faker = new Faker();
        String UserName = faker.name().username();
        loginPage.login(UserName,"123456");
        Assert.assertEquals(loginPage.getInvalidUserNameAndPasswordError(),prop.get("ASG_RegErr_InvalidUsernamePassword"),"Verify Invalid Username Message");

    }
    @AfterClass
    public void teardown()
    {
        driver.close();
        driver.quit();
        Reporter.log("Browser closed Successfully");
    }

}
