package assiangroup.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;
    By email = By.id("email");

    By label_email= By.xpath("//*[@id='kc-register-form']//label[@for='email']");
    By label_password=By.xpath("//*[@id='kc-register-form']//label[@for='password']");

    By label_confirmPassword=By.xpath("//*[@id='kc-register-form']//label[@for='password-confirm']");
    By password = By.id("password");
    By confirmPassword = By.id("password-confirm");
    By Register =By.xpath("//*[@type='submit']");
    By RegisterTitle = By.id("kc-page-title");
    By BackToHome = By.xpath("//*[@id='kc-form-options']/div/span/a");
    By BlankErrMessage = By.xpath("//span[@class='pf-c-alert__title kc-feedback-text']");

    public RegisterPage(WebDriver driver) {
        this.driver= driver;
    }

    public void userRegistration(String userid,String pword,String ConfirmPwd){
        driver.findElement(email).sendKeys(userid);
        driver.findElement(password).sendKeys(pword);
        driver.findElement(confirmPassword).sendKeys(ConfirmPwd);
        driver.findElement(Register).click();
    }

    public String getErrorMsg(){
        return driver.findElement(BlankErrMessage).getText();
    }

    public String getEmail(){
        return  driver.findElement(label_email).getText();
    }

    public String getPassword(){
        return  driver.findElement(label_password).getText();
    }

    public String getConfirmPassword(){
        return  driver.findElement(label_confirmPassword).getText();
    }

    public String getRegisterTitle(){
        return  driver.findElement(RegisterTitle).getText();
    }

    public String getRegister(){
        return  driver.findElement(Register).getAttribute("value");
    }

    public String getBackToHome(){
        return  driver.findElement(BackToHome).getText();
    }
    public void clickBackToHome(){
       driver.findElement(BackToHome).click();
    }

    public String getLocale(){
        return driver.findElement(By.id("kc-current-locale-link")).getText();
    }
}
