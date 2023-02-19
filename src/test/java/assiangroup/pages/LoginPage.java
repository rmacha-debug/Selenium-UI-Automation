package assiangroup.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    By email = By.id("username");
    By password = By.id("password");
    By ForgotPassword = By.xpath("//div[@class='form-group login-pf-settings']/div[2]/span/a");
    By rememberMe = By.xpath("//*[@id='kc-form-options']/div/label");

    By Register = By.xpath("//div[@class='login-pf-signup']//div/span/a");
    By SignIn = By.id("kc-login");
    By NewUser = By.xpath("//*[@id='kc-registration']/span");
    By SignInTitle = By.id("kc-page-title");

    By userid = By.xpath("//div[@class='vue-avatar--wrapper']");
    By LogoutElement = By.xpath("//*[contains(text(),'Logout')]");
    By currentLocale = By.id("kc-current-locale-link");
    By signInTitle = By.id("kc-page-title");

    By InvalidEmailAndPasswordError = By.id("input-error");

    public LoginPage(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(this.driver, this);
    }

    public boolean login(String username,String pwd){
        boolean found =true;
        waitForElement(driver.findElement(email)).sendKeys(username);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(SignIn).click();
        return found;
    }

    public boolean logout(){
        boolean found =true;
        try{
            WebElement element = driver.findElement(userid);
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", element);
            waitForElement(driver.findElement(LogoutElement)).click();
            found=driver.findElement(email).isDisplayed();
        }catch (Exception e){
            found =false;
        }
        return  found;
    }

    public void selectLocale(String Locale) throws InterruptedException {
        String lan = null;
        switch(Locale.toLowerCase()){
            case "en":
                lan = "English";
                break;
            case "ja" :
                lan ="日本語";
                break;
            case "kr" :
                lan ="kr";
                break;
            case "zh_cn" :
                lan ="中文简体";
                break;
        }
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(currentLocale))
                .perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(text(),'"+lan+"')]")).click();

    }

    public  WebElement waitForElement(WebElement ele){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(ele));
    }

    public void clickOnForgotPassword(){
        waitForElement(driver.findElement(ForgotPassword)).click();
    }

    public void clickOnRegister(){
        waitForElement(driver.findElement(Register)).click();
    }

    public String getInvalidUserNameAndPasswordError(){
        return  driver.findElement(InvalidEmailAndPasswordError).getText();
    }

    public String getEmail(){
        return  driver.findElement(email).findElement(By.xpath("..")).getText();
    }

    public String getPassword(){
        return  driver.findElement(password).findElement(By.xpath("..")).getText();
    }

    public String getForgotPassword(){
        return driver.findElement(ForgotPassword).getText();
    }

    public String getSignIn(){
        return driver.findElement(SignIn).getAttribute("value");
    }

    public String getRegister(){
        return driver.findElement(Register).getText();
    }

    public String getNewUser(){
        return driver.findElement(NewUser).getText();
    }

    public String getRememberMe(){
        return driver.findElement(rememberMe).getText();
    }

    public String getSignTitle(){
        return driver.findElement(SignInTitle).getText();
    }

}
