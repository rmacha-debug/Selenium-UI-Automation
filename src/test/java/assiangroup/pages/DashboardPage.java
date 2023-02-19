package assiangroup.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class DashboardPage {
    WebDriver driver;
    By flag = By.cssSelector("button[class='btn ml-2 btn-primary btn-sm']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyFlag(){
        boolean found =false;
        try{
            found = driver.findElement(flag).isDisplayed();
        }catch (Exception e){
            found =false;
            Reporter.log("Unable to Identity the flag element");
        }
        return found;
    }
}
