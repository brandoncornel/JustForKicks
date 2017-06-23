package websites.Paypal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by brandoncornel on 6/22/17.
 */
public class First_Paypal_Page_Login {

    private WebDriver driver = null;
    private WebDriverWait wait;


    private By LOGIN_BY = By.xpath("//a[text()='Log In']");
    private By LOADING_BY = By.id("spinner");


    public First_Paypal_Page_Login(WebDriver driver, int waitTime){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, waitTime);
    }

    public void waitForPage(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(LOADING_BY));
    }

    public void login(){
        driver.findElement(LOGIN_BY).click();
    }
}
