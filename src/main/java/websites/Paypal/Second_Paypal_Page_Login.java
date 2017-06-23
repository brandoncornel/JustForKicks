package websites.Paypal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

/**
 * Created by brandoncornel on 6/22/17.
 */
public class Second_Paypal_Page_Login {

    private WebDriver driver = null;
    private WebDriverWait wait;


    private By EMAIL_FIELD_BY = By.id("email");
    private By PASSWORD_FIELD_BY = By.id("password");
    private By LOGIN_BY = By.id("btnLogin");


    public Second_Paypal_Page_Login(WebDriver driver, int waitTime){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, waitTime);
    }

    public void waitForPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BY));
    }

    public void login(HashMap userInfo){
        driver.findElement(EMAIL_FIELD_BY).sendKeys(userInfo.get("Email").toString());
        driver.findElement(PASSWORD_FIELD_BY).sendKeys(userInfo.get("Password").toString());
        driver.findElement(LOGIN_BY).click();
    }
}
