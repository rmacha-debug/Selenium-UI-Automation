package assiangroup.tests;

import assiangroup.pages.BasePage;
import assiangroup.pages.DashboardPage;
import assiangroup.pages.HomePage;
import assiangroup.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver = null;
    @Test()
    @Parameters({"Browser", "Locale","Environment"})
    public void verifyLoginTest(String Browser, String Locale,String Environment) throws InterruptedException {
        BasePage driverPage = new BasePage();
        driver = driverPage.getBrowser(Browser);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        driverPage.loadLocale(Locale);
        driver.get(driverPage.getAppUrl(Environment));
        Assert.assertEquals(true,true,"Application launched in successfully");
        Reporter.log("Application launched in successfully");
        loginPage.selectLocale(Locale);
        String Username = "qauser@assiansgroup.com";
        loginPage.login(Username,"123456");
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertEquals(dashboardPage.verifyFlag(),true,"Application Logged in successfully");
        Reporter.log(Username +" Logged in successfully");
        Assert.assertEquals(loginPage.logout(),true,"verify the application logout");
        Reporter.log(Username +"Logged out successfully");
    }
    @AfterClass
    public void teardown()
    {
        driver.close();
        driver.quit();
        Reporter.log("Browser closed Successfully");
    }

}
