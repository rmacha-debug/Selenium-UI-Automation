package assiangroup.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    WebDriver driver;
    By email = By.id("username");

    By label_email=By.xpath("//*[@id='kc-reset-password-form']//label[@for='email']");
    By SuccessMsg = By.xpath("//span[@class='pf-c-alert__title kc-feedback-text']");
    By Submit = By.xpath("//*[@class='pf-c-button pf-m-primary pf-m-block btn-lg']");

    By BackToHome = By.xpath("//*[@id='kc-form-options']/div/span/a");
    By ForgotPwdDescription = By.id("kc-info-wrapper");
    By ForgotTitle = By.id("kc-page-title");
    By ErrorMsg = By.id("input-error-username");

    public ForgotPasswordPage(WebDriver driver){
        this.driver= driver;
    }

    public void ForgotPasswordSubmission(String userId)
    {
        driver.findElement(email).sendKeys(userId);
        driver.findElement(Submit).click();
    }

    public String getSuccessMsg(){
        return driver.findElement(SuccessMsg).getText();
    }

    public String getErrorMsg(){
        return driver.findElement(ErrorMsg).getText();
    }

    public String getEmail(){
        return  driver.findElement(label_email).findElement(By.xpath("..")).getText();
    }

    public String getSubmit(){
        return  driver.findElement(Submit).getAttribute("value");
    }

    public String getBackToHome(){
        return  driver.findElement(BackToHome).getText();
    }

    public void clickBackToLogin(){
       driver.findElement(BackToHome).click();
    }

    public String getForgotPasswordInstruction(){
        return  driver.findElement(ForgotPwdDescription).getText();
    }

    public String getLocale(){
        return driver.findElement(By.id("kc-current-locale-link")).getText();
    }

}
