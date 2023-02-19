package assiangroup.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    By header = By.className("kc-header-wrapper");

    public HomePage(WebDriver driver){
        this.driver= driver;
    }
    public boolean verifyPageHeader(){
        return driver.findElement(header).isDisplayed();
    }
}
