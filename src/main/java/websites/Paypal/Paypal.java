package websites.Paypal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by brandoncornel on 6/22/17.
 */
public class Paypal {

    private WebDriver driver = null;
    private WebDriverWait wait;


    private By PAYPAL_BY = By.xpath("//div[@id='body-main']//p[@class='paypal-logo']/a");


    Paypal(WebDriver driver, int waitTime){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, waitTime);
    }

    public void waitForPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAYPAL_BY));
    }

    public void checkout(){
        driver.findElement(PAYPAL_BY).click();
    }



}
