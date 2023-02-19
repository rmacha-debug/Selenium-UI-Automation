package assiangroup.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

import java.io.*;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.Properties;


public class BasePage {
    private WebDriver driver = null;
    private Properties lan = null;
    public WebDriver getBrowser(String browser){
        switch (browser.toUpperCase()) {
            case "CHROME":
                ChromeOptions chromeOptions = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "EDGE":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    public Properties loadLocale(String locale){

        try{
            lan = new Properties();
            FileInputStream input = new FileInputStream(new File(System.getProperty("user.dir")+File.separator+"AsiansUsersSystemsGroup_"+locale+".properties"));
            lan.load(new InputStreamReader(input, Charset.forName("UTF-8")));
        }catch(Exception e){
            e.printStackTrace();
        }
        return  lan;
    }

    public  WebElement waitForElement(WebElement ele){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(ele));
    }

    public String getAppUrl(String Environment){
        String AppUrl =null;
        switch(Environment.toUpperCase()){
            case "UAT":
                AppUrl= "https://console.uat.asians.group/#/domain/list";
                break;
            default:
                Reporter.log("Please provide the valid environment details");
        }
        return AppUrl;
    }

}
